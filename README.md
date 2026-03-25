# 💰 Smart Expense Tracker (Java)

## 📌 Overview

The **Smart Expense Tracker** is a Java-based application designed to help users manage and analyze their daily expenses efficiently. It provides both a **console-based interface** and a **graphical user interface (GUI)** using Java Swing.

This project goes beyond basic expense tracking by including **budget management, category analysis, and smart insights**, making it a practical real-world solution.

---

## 🎯 Problem Statement

Students and individuals often fail to track their daily expenses, leading to poor financial planning and overspending.

---

## 💡 Solution

This application allows users to:

* Record daily expenses
* Categorize spending
* Analyze monthly expenses
* Set and monitor budgets
* View data in a user-friendly GUI

---

## 🌟 Key Features

### ✅ Core Features

* Add expenses with category, amount, and date
* View all expenses
* Save and load data using file handling

### 📊 Analysis Features

* Monthly expense summary
* Category-wise spending analysis
* Text-based graph representation

### 💰 Smart Features

* Budget setting and tracking
* Warning when budget is exceeded
* Search expenses by category
* Delete expenses

### 🖥️ GUI Features (Java Swing)

* Interactive window-based interface
* Table view for expenses
* Buttons for actions (Add, Delete, Summary, Budget)
* Popup dialogs for summaries and alerts

---

## 🛠️ Technologies Used

* Java (Core Java)
* OOP (Object-Oriented Programming)
* Java Swing (GUI)
* File Handling (BufferedReader, BufferedWriter)
* Collections Framework (ArrayList, HashMap)
* Date & Time API (LocalDate)

---

## 📂 Project Structure

```
ExpenseTracker/
│── src/
│   ├── Expense.java
│   ├── ExpenseManager.java
│   ├── Main.java          (Console Version)
│   ├── ExpenseGUI.java    (GUI Version)
│── expenses.txt           (Data storage file)
│── README.md
```

---

## ⚙️ How to Run the Project

### 🔹 Step 1: Open Terminal

Navigate to the `src` folder:

```
cd src
```

---

### 🔹 Step 2: Compile the Project

```
javac *.java
```

---

## ▶️ Run Console Version

```
java Main
```

### 💡 Features:

* Menu-driven interface
* Works entirely in terminal
* Good for understanding logic

---

## 🖥️ Run GUI Version (Recommended)

```
java ExpenseGUI
```

### 💡 Features:

* Interactive window
* Table-based expense display
* Buttons for all operations
* Easy to use and visually appealing

---

## 🧪 Example Usage

1. Enter:

   * Category → Food
   * Amount → 200
   * Date → 2026-03-25

2. Click **Add Expense**

3. View it in the table

4. Use:

   * Monthly Summary
   * Category Summary
   * Set Budget

---

## ⚠️ Important Notes

* Date must be entered in format: `YYYY-MM-DD`
* Category should be text (e.g., Food, Travel)
* Data is automatically saved in `expenses.txt`

---

## 🚀 Unique Aspects of This Project

Unlike basic expense trackers, this project includes:

* Budget monitoring with alerts
* Category-wise analysis with visual representation
* Both CLI and GUI versions
* Persistent data storage
* Clean and user-friendly interface

---

## 📚 Learning Outcomes

Through this project, the following concepts were applied:

* Object-Oriented Programming (OOP)
* File Handling in Java
* GUI development using Swing
* Data structures (ArrayList, HashMap)
* Real-world problem solving

---

## 👨‍💻 Author

Adarsh Bhardwaj

---

## 📌 Conclusion

The Smart Expense Tracker is a practical and efficient tool that helps users manage their expenses effectively. It demonstrates the application of core Java concepts in solving a real-world problem with both functionality and usability.

---
