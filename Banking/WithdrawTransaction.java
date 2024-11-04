package Banking;
/**
 * Class representing a withdrawal transaction.
 * It extends the Transaction class and implements the execute method.
 */
public class WithdrawTransaction extends Transaction {
    private static final int MIN_WITHDRAWAL = 1000;
    private static final int MAX_WITHDRAWAL = 25000;
    private final int accountNumber;
    private final Banking banking;

    /**
     * Constructor for WithdrawTransaction.
     * @param accountNumber The account number to withdraw from.
     * @param amount The amount to withdraw.
     * @param banking The banking system interface to perform the withdrawal.
     */
    public WithdrawTransaction(int accountNumber, int amount, Banking banking) {
        super(amount);
        this.accountNumber = accountNumber;
        this.banking = banking;
    }

    /**
     * Executes the withdrawal transaction.
     * Checks if the amount is within the allowed range before proceeding.
     * @return true if the withdrawal is successful, false otherwise.
     */
    @Override
    public boolean execute() {
        if (amount < MIN_WITHDRAWAL || amount > MAX_WITHDRAWAL) {
            return false;
        }
        return banking.withdraw(accountNumber, amount);
    }
}
