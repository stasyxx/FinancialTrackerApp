package financialTrackerApp.component;

import java.math.BigDecimal;

public class FinanceManager {

    private static BigDecimal balance = BigDecimal.ZERO;

    public static void main(String[] args) {

        kindOfTransaction(true, new BigDecimal(10)); // Expense
        kindOfTransaction(false, new BigDecimal(20)); // Income

        System.out.println("Final Balance: $" + balance);
    }

    public static void kindOfTransaction(boolean isExpense, BigDecimal amount) {
        if (isExpense) {
            processExpense(amount);
        } else {
            processIncome(amount);
        }
    }

    private static void processExpense(BigDecimal expenseAmount) {
        System.out.println("Processing Expense: $" + expenseAmount);
        balance = balance.subtract(expenseAmount);
        System.out.println("Updated Balance after Expense: $" + balance);
    }

    private static void processIncome(BigDecimal incomeAmount) {
        System.out.println("Processing Income: $" + incomeAmount);
        balance = balance.add(incomeAmount);
        System.out.println("Updated Balance after Income: $" + balance);
    }
}
