
	Design a program that calculates the price of a pizza. A pizza has:

	•	A base (like thin, regular, cheesy crust)
	•	A size (small, medium, large)
	•	Toppings (such as olives, cheese, pepperoni)

You should assume the system stores everything in-memory, with no need for persistent storage.

Key Points:

	•	Create a Pizza class that can hold the base, size, and toppings.
	•	Calculate the price based on these attributes.
	•	Consider extensibility for potential follow-up requirements (e.g., adding other items to the order).

    
    
    •	Base Pricing: Each base type (e.g., thin, regular, cheesy crust) has a different base price.
	•	Size Modifier: The size (small, medium, large) modifies the base price by a specific factor. For example, small might be the base price, medium might be 1.5 times the base price, and large might be 2 times the base price.
	•	Toppings Pricing: Each topping has a fixed cost, regardless of size or base.

Here are some sample values for you to work with:

	•	Base:
	•	Thin: $5
	•	Regular: $6
	•	Cheesy Crust: $7
	•	Size Modifier:
	•	Small: 1x
	•	Medium: 1.5x
	•	Large: 2x
	•	Toppings:
	•	Olives: $1
	•	Cheese: $1.5
	•	Pepperoni: $2

With this structure, you can calculate the total price by combining the base price, size modifier, and topping costs.

---

Phase 2 Question

Imagine that we want to extend the system to handle full orders, not just individual pizzas. Customers should be able to order multiple items together, like pizzas and drinks.

Here are some requirements:

	1.	An order can contain one or more pizzas and any number of drinks.
	2.	Drinks have different types and sizes, each with a different price.
	3.	We should be able to calculate the total price of the order, considering both pizzas and drinks.

    drink Pricing

	•	Types of Drinks:
	•	Water: $1 (any size)
	•	Soda: $1.5 (small), $2 (medium), $2.5 (large)
	•	Juice: $2 (small), $3 (medium), $4 (large)
	•	Sizes:
	•	Small, Medium, Large

Each drink type has a specific price per size, except for Water, which has a flat price regardless of size.