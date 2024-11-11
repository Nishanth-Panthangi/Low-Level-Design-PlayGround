Quick Notes: LocalDate

	•	LocalDate.now(): Gets today’s date (no time component).
	•	Creating a Date: LocalDate.of(year, month, day).
	•	Add/Subtract Days: date.plusDays(14), date.minusDays(7).
	•	Comparisons:
	•	date1.isAfter(date2) – true if date1 is after date2.
	•	date1.isBefore(date2) – true if date1 is before date2.
	•	date1.isEqual(date2) – true if both are the same date.
	•	Finding Differences:
	•	Use Period.between(date1, date2).getDays() for day difference.

	Tip: Use LocalDate over Date for cleaner, immutable, timezone-independent date handling.