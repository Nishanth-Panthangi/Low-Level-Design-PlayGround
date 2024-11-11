Problem Statement (Phase A)

Design a system for a basic Library Management System with the following requirements:

	1.	Books have attributes: title, author, ISBN (unique identifier), and availability status (available or checked out).
	2.	The system should allow the following actions:
	•	Add a Book: Add a new book to the library.
	•	Check Out a Book: Mark a book as checked out if it is available.
	•	Return a Book: Mark a book as available if it is checked out.
	3.	The library can hold multiple copies of the same book (identified by the same title and author but with unique ISBNs for each copy).

---
Phase B Extension

In Phase B, let’s add some new requirements to your Library Management System:

	1.	Loan Period Tracking:
	•	When a book is checked out, record the check-out date and due date (let’s assume a standard loan period, like 14 days).
	•	Track overdue books based on their due date.
	2.	Overdue Status:
	•	Add a way to determine if a book is overdue. When checking the status of a book, if the current date is past the due date, the book should be marked as overdue.
	3.	Member Tracking (optional):
	•	Allow books to be checked out by specific library members. Track which member checked out each book.
	•	A member can only check out a limited number of books at once (e.g., 5 books).
