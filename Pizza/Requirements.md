
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