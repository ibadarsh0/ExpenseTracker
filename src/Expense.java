import java.time.LocalDate;

class Expense {
    int id;
    String category;
    double amount;
    LocalDate date;

    public Expense(int id, String category, double amount, LocalDate date) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String toFileString() {
        return id + "," + category + "," + amount + "," + date;
    }

    public static Expense fromFileString(String line) {
        String[] p = line.split(",");
        return new Expense(
            Integer.parseInt(p[0]),
            p[1],
            Double.parseDouble(p[2]),
            LocalDate.parse(p[3])
        );
    }

    public String toString() {
        return id + " | " + category + " | ₹" + amount + " | " + date;
    }
}