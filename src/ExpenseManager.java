import java.io.*;
import java.time.LocalDate;
import java.util.*;

class ExpenseManager {

    ArrayList<Expense> list = new ArrayList<>();
    final String FILE = "expenses.txt";
    double budget = 0;

    public ExpenseManager() {
        load();
    }

    void addExpense(Expense e) {
        list.add(e);
        save();
    }

    void viewAll() {
        for (Expense e : list) {
            System.out.println(e);
        }
    }

    void deleteExpense(int id) {
        list.removeIf(e -> e.id == id);
        save();
    }

    void searchByCategory(String cat) {
        for (Expense e : list) {
            if (e.category.equalsIgnoreCase(cat)) {
                System.out.println(e);
            }
        }
    }

    void monthlySummary(int month) {
        double total = 0;
        for (Expense e : list) {
            if (e.date.getMonthValue() == month) {
                total += e.amount;
            }
        }

        System.out.println("Total: ₹" + total);

        if (budget > 0) {
            System.out.println("Budget: ₹" + budget);
            System.out.println("Remaining: ₹" + (budget - total));

            if (total > budget) {
                System.out.println("⚠ Budget exceeded!");
            }
        }
    }

    void categorySummary() {
        HashMap<String, Double> map = new HashMap<>();

        for (Expense e : list) {
            map.put(e.category, map.getOrDefault(e.category, 0.0) + e.amount);
        }

        for (String k : map.keySet()) {
            System.out.print(k + ": ₹" + map.get(k) + " ");
            int bars = (int)(map.get(k) / 100);
            for (int i = 0; i < bars; i++) System.out.print("█");
            System.out.println();
        }
    }

    void setBudget(double b) {
        budget = b;
    }

    void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Expense e : list) {
                bw.write(e.toFileString());
                bw.newLine();
            }
        } catch (Exception e) {}
    }

    void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Expense.fromFileString(line));
            }
        } catch (Exception e) {}
    }
}