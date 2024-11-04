package Banking;
import java.time.LocalDate;

/**
 * Abstract class representing a generic transaction.
 * This class is designed to be extended by specific transaction types like Deposit and Withdraw.
 */
public abstract class Transaction {
    protected int amount;
    protected LocalDate date;

    /**
     * Constructor initializes the transaction with an amount and sets the date to the current date.
     * @param amount The amount involved in the transaction.
     */
    public Transaction(int amount) {
        this.amount = amount;
        this.date = LocalDate.now();
    }

    /**
     * Abstract method to execute the transaction.
     * Concrete subclasses must implement this method.
     * @return true if the transaction is successful, false otherwise.
     */
    public abstract boolean execute();
}
