import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class ExpenseGUI extends JFrame {

    JTextField categoryField, amountField, dateField;
    DefaultTableModel model;
    ExpenseManager manager;

    public ExpenseGUI() {
        manager = new ExpenseManager();

        setTitle("Smart Expense Tracker");
        setSize(750, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== TITLE =====
        JLabel title = new JLabel("💰 Expense Tracker", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setOpaque(true);
        title.setBackground(new Color(30, 144, 255));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(title, BorderLayout.NORTH);

        // ===== TOP PANEL =====
        JPanel topPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        categoryField = new JTextField();
        amountField = new JTextField();
        dateField = new JTextField("YYYY-MM-DD");

        JButton addBtn = new JButton("Add Expense");
        JButton deleteBtn = new JButton("Delete Selected");

        topPanel.add(new JLabel("Category"));
        topPanel.add(new JLabel("Amount"));
        topPanel.add(new JLabel("Date"));
        topPanel.add(new JLabel(""));

        topPanel.add(categoryField);
        topPanel.add(amountField);
        topPanel.add(dateField);
        topPanel.add(addBtn);

        add(topPanel, BorderLayout.BEFORE_FIRST_LINE);

        // ===== TABLE =====
        model = new DefaultTableModel(new String[]{"ID", "Category", "Amount", "Date"}, 0);
        JTable table = new JTable(model);
        table.setRowHeight(25);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // ===== BOTTOM PANEL =====
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);

        JButton summaryBtn = new JButton("Monthly Summary");
        JButton categoryBtn = new JButton("Category Summary");
        JButton budgetBtn = new JButton("Set Budget");

        bottomPanel.add(deleteBtn);
        bottomPanel.add(summaryBtn);
        bottomPanel.add(categoryBtn);
        bottomPanel.add(budgetBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        // ===== LOAD DATA =====
        loadTable();

        // ===== ADD EXPENSE =====
        addBtn.addActionListener(e -> {
            try {
                String cat = categoryField.getText();
                double amt = Double.parseDouble(amountField.getText());
                LocalDate date = LocalDate.parse(dateField.getText());

                Expense exp = new Expense(model.getRowCount() + 1, cat, amt, date);
                manager.addExpense(exp);

                model.addRow(new Object[]{exp.id, cat, amt, date});

                categoryField.setText("");
                amountField.setText("");
                dateField.setText("YYYY-MM-DD");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        // ===== DELETE EXPENSE =====
        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                int id = (int) model.getValueAt(row, 0);
                manager.deleteExpense(id);
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Select a row first!");
            }
        });

        // ===== MONTHLY SUMMARY =====
        summaryBtn.addActionListener(e -> {
            try {
                String input = JOptionPane.showInputDialog("Enter month (1-12):");
                int month = Integer.parseInt(input);

                double total = manager.list.stream()
                        .filter(exp -> exp.date.getMonthValue() == month)
                        .mapToDouble(exp -> exp.amount)
                        .sum();

                JOptionPane.showMessageDialog(this, "Total Expense: ₹" + total);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        // ===== CATEGORY SUMMARY =====
        categoryBtn.addActionListener(e -> {
            StringBuilder result = new StringBuilder();

            manager.list.stream()
                    .map(exp -> exp.category)
                    .distinct()
                    .forEach(cat -> {
                        double sum = manager.list.stream()
                                .filter(e2 -> e2.category.equals(cat))
                                .mapToDouble(e2 -> e2.amount)
                                .sum();
                        result.append(cat).append(": ₹").append(sum).append("\n");
                    });

            JOptionPane.showMessageDialog(this, result.toString());
        });

        // ===== SET BUDGET =====
        budgetBtn.addActionListener(e -> {
            try {
                String b = JOptionPane.showInputDialog("Enter monthly budget:");
                double budget = Double.parseDouble(b);
                manager.setBudget(budget);
                JOptionPane.showMessageDialog(this, "Budget set to ₹" + budget);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid budget!");
            }
        });

        setVisible(true);
    }

    // ===== LOAD TABLE DATA =====
    void loadTable() {
        for (Expense e : manager.list) {
            model.addRow(new Object[]{e.id, e.category, e.amount, e.date});
        }
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {
        new ExpenseGUI();
    }
}