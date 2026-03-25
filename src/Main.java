import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseManager m = new ExpenseManager();
        int id = 1;

        while (true) {

            System.out.println("\n====== Expense Tracker ======");
            System.out.println("1.Add Expense");
            System.out.println("2.View Expenses");
            System.out.println("3.Monthly Summary");
            System.out.println("4.Category Summary");
            System.out.println("5.Set Budget");
            System.out.println("6.Search Category");
            System.out.println("7.Delete Expense");
            System.out.println("8.Exit");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    sc.nextLine();
                    System.out.print("Category: ");
                    String cat = sc.nextLine();

                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();

                    sc.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());

                    m.addExpense(new Expense(id++, cat, amt, date));
                    break;

                case 2:
                    m.viewAll();
                    break;

                case 3:
                    System.out.print("Month: ");
                    int month = sc.nextInt();
                    m.monthlySummary(month);
                    break;

                case 4:
                    m.categorySummary();
                    break;

                case 5:
                    System.out.print("Set Budget: ");
                    m.setBudget(sc.nextDouble());
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("Enter category: ");
                    m.searchByCategory(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Enter ID: ");
                    m.deleteExpense(sc.nextInt());
                    break;

                case 8:
                    return;
            }
        }
    }
}