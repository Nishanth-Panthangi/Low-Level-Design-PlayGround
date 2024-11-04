package Banking;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the Banking interface.
 * Manages accounts and performs operations like deposit, withdrawal, and transfer.
 */
public class BankingImpl implements Banking {
    private Map<Integer, Account> accounts;
    private int lastAccountNumber;

    /**
     * Constructor initializes the banking system with an empty account list.
     */
    public BankingImpl() {
        accounts = new HashMap<>();
        lastAccountNumber = 1000;
    }

    /**
     * Creates a new account with a unique account number.
     * @param name The name of the account holder.
     * @return The new account number.
     */
    @Override
    public int createAccount(String name) {
        int accountNumber = ++lastAccountNumber;
        accounts.put(accountNumber, new Account(accountNumber, name));
        return accountNumber;
    }

    /**
     * Deposits an amount into the specified account.
     * @param accountNumber The account number to deposit into.
     * @param amount The amount to deposit.
     * @return true if the deposit is successful, false otherwise.
     */
    @Override
    public boolean deposit(int accountNumber, int amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.deposit(amount);
        }
        return false;
    }

    /**
     * Withdraws an amount from the specified account.
     * @param accountNumber The account number to withdraw from.
     * @param amount The amount to withdraw.
     * @return true if the withdrawal is successful, false otherwise.
     */
    @Override
    public boolean withdraw(int accountNumber, int amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.withdraw(amount);
        }
        return false;
    }

    /**
     * Transfers an amount from one account to another.
     * @param fromAccountNumber The account number to transfer from.
     * @param toAccountNumber The account number to transfer to.
     * @param amount The amount to transfer.
     * @return true if the transfer is successful, false otherwise.
     */
    @Override
    public boolean transfer(int fromAccountNumber, int toAccountNumber, int amount) {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(amount)) {
                if (toAccount.deposit(amount)) {
                    return true;
                } else {
                    // Rollback the withdrawal if deposit fails
                    fromAccount.deposit(amount);
                }
            }
        }
        return false;
    }

    /**
     * Checks the balance of the specified account.
     * @param accountNumber The account number to check.
     * @return The balance of the account, or -1 if the account does not exist.
     */
    @Override
    public int checkBalance(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        return -1; // Indicate invalid account number
    }
}
