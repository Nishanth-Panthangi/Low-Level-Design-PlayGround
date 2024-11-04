package Banking;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Class representing a bank account.
 * Manages balance, transactions, and enforces transaction limits.
 */
public class Account {
    private static final int MAX_BALANCE = 100000;
    private static final int MAX_DAILY_TRANSACTIONS = 3;

    private final int accountNumber;
    private final String name;
    private int balance;
    private List<Transaction> dailyTransactions;
    private LocalDate lastTransactionDate;

    /**
     * Constructor for Account.
     * @param accountNumber The unique account number.
     * @param name The name of the account holder.
     */
    public Account(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0;
        this.dailyTransactions = new ArrayList<>();
        this.lastTransactionDate = LocalDate.now();
    }

    /**
     * Deposits an amount into the account if conditions are met.
     * @param amount The amount to deposit.
     * @return true if the deposit is successful, false otherwise.
     */
    public boolean deposit(int amount) {
        if (canPerformTransaction() && balance + amount <= MAX_BALANCE) {
            balance += amount;
            addTransaction(new DepositTransaction(accountNumber, amount, null));
            return true;
        }
        return false;
    }

    /**
     * Withdraws an amount from the account if conditions are met.
     * @param amount The amount to withdraw.
     * @return true if the withdrawal is successful, false otherwise.
     */
    public boolean withdraw(int amount) {
        if (canPerformTransaction() && balance - amount >= 0) {
            balance -= amount;
            addTransaction(new WithdrawTransaction(accountNumber, amount, null));
            return true;
        }
        return false;
    }

    /**
     * Retrieves the current balance of the account.
     * @return The current balance.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Retrieves the account number.
     * @return The account number.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Checks if a transaction can be performed based on daily limits.
     * @return true if a transaction can be performed, false otherwise.
     */
    private boolean canPerformTransaction() {
        LocalDate today = LocalDate.now();
        if (!today.equals(lastTransactionDate)) {
            dailyTransactions.clear();
            lastTransactionDate = today;
        }
        return dailyTransactions.size() < MAX_DAILY_TRANSACTIONS;
    }

    /**
     * Adds a transaction to the daily transaction list.
     * @param transaction The transaction to add.
     */
    private void addTransaction(Transaction transaction) {
        dailyTransactions.add(transaction);
    }
}
