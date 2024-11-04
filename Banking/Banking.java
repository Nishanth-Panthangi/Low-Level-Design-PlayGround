package Banking;
/**
 * Interface defining the operations for a banking system.
 * Includes methods for account creation, deposit, withdrawal, transfer, and balance check.
 */
public interface Banking {
    int createAccount(String name);
    boolean deposit(int accountNumber, int amount);
    boolean withdraw(int accountNumber, int amount);
    boolean transfer(int fromAccountNumber, int toAccountNumber, int amount);
    int checkBalance(int accountNumber);
}
