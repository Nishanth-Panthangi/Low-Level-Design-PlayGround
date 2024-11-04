package Banking;
/**
 * Class representing a deposit transaction.
 * It extends the Transaction class and implements the execute method.
 */
public class DepositTransaction extends Transaction {
    private static final int MIN_DEPOSIT = 500;
    private static final int MAX_DEPOSIT = 50000;
    private final int accountNumber;
    private final Banking banking;

    /**
     * Constructor for DepositTransaction.
     * @param accountNumber The account number to deposit into.
     * @param amount The amount to deposit.
     * @param banking The banking system interface to perform the deposit.
     */
    public DepositTransaction(int accountNumber, int amount, Banking banking) {
        super(amount);
        this.accountNumber = accountNumber;
        this.banking = banking;
    }

    /**
     * Executes the deposit transaction.
     * Checks if the amount is within the allowed range before proceeding.
     * @return true if the deposit is successful, false otherwise.
     */
    @Override
    public boolean execute() {
        if (amount < MIN_DEPOSIT || amount > MAX_DEPOSIT) {
            return false;
        }
        return banking.deposit(accountNumber, amount);
    }
}
