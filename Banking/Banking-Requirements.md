A payment bank has a balance limit of ₹1,00,000, and certain conditions for deposits and withdrawals:
	•	Deposits: Minimum ₹500, maximum ₹50,000 per transaction, no more than 3 deposits per day.
	•	Withdrawals: Minimum ₹1,000, maximum ₹25,000 per transaction, no more than 3 withdrawals per day.
	•	Account balance must stay between ₹0 and ₹1,00,000.
	•	Account numbers must be valid for any transaction.
	•	For withdrawals, the account must have sufficient funds.

Commands and Conditions

	1.	Create: Creates a new account with a name, returning a unique account number.
	2.	Deposit: Adds funds to an account, adhering to the deposit rules.
	3.	Withdraw: Withdraws funds from an account, ensuring withdrawal rules are followed.
	4.	Balance: Retrieves the current balance of a specified account.
	5.	Transfer: Moves funds between two accounts, adhering to deposit and withdrawal rules.

Sample Input & Output Examples

	•	Account Creation:
	•	Create "Amit Dugal" ➔ Output: 1001

	•	Deposit:
	•	Deposit 1001 500 ➔ Output: 500
	•	Deposit 1001 60000 ➔ Output: Maximum deposit amount is 50000

	•	Withdrawal:
	•	Withdraw 1001 500 ➔ Output: Minimum withdrawal amount is 1000
	•	Withdraw 1001 20000 ➔ Output: Insufficient balance

	•	Transfer:
	•	Transfer 1001 1002 5000 ➔ Output: Successful

Guidelines for Implementation

	•	Focus on clean, object-oriented code.
	•	Apply SOLID principles, YAGNI, and KISS.
	•	Implement unit tests or TDD (Test-Driven Development).
	•	Keep the solution simple, readable, and maintainable.