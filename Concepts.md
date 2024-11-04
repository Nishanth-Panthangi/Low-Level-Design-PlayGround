# Object Oriented Design Learnings

## Encapsulation
- Encapsulation is one of the core principles of object-oriented programming. 
- It involves bundling the data (attributes) and the methods that operate on that data into a single unit, typically a class. 
- Additionally, encapsulation restricts direct access to some of an object's components, which means the internal state of an object is hidden from the outside. This is usually achieved using access modifiers like provate, protected, and public.
- Example: Designing a [class] like a Transaction/ Vehicle/ Receipt etc.

## Abstraction
- Abstraction is about simplifying complex systems by modelling classes appropriate to the problem, and working at the most relevant level of complexity.
- It involves exposing only the necessary details and hiding the underlying implementation.
- it allows developers to focus on high-level-operations without getting bogged down by intricate details.
- While encapsulation is about bundling data and methods and restricting access, abstraction is about hiding complexity and showing only the essential features.
- Example: Think of a PaymentProcessor [interface] in a banking application. This interface might have a method like processPayment(). Different payment methods—such as CreditCardProcessor, PayPalProcessor, or BankTransferProcessor—implement this interface. The client code interacts with the PaymentProcessor interface without needing to know the specific details of how each payment method processes transactions. This makes the system more flexible and easier to extend with new payment methods in the future.

## Inheritance
- Inheritance is a fundamental concept in object-oriented programming that allows one class to inherit properties and behaviors from another class. 
- This establishes a hierarchical relationship between the classes, promoting code reusability and enabling the creation of more specific classes based on general ones
- Example: Consider a base class called Animal that has attributes like name and age, and methods like eat() and sleep(). We can create a subclass called Dog that inherits from Animal. The Dog class automatically gains the name and age attributes and the eat() and sleep() methods from Animal, but it can also have additional attributes like breed and methods like bark(). This way, we avoid duplicating common code in each subclass, making our codebase cleaner and more maintainable.

## Polymorphism
- Polymorphism is the ability of different classes to be treated as instances of the same class through a common interface.
- It allows objects of different types to be processed through same interface, enabling flexibility and the ability to extend systems easily.
- There are two main types of polymorphism:
  - Compile-Time (static) : This is achieved through method overloading and operator overloading. For example, having multiple methods with the same name but different parameters within the same class.
  - Runtime (dynamic) : This is achieved through method overriding, where a subclass provides a specific implementation of a method that is already defined in its superclass.
- Example: Consider a base class Shape with a method draw(). Subclasses like Circle, Rectangle, and Triangle each override the draw() method to render the specific shape. When we have a collection of Shape objects, we can iterate through them and call draw() on each one without needing to know the specific type of shape. This makes the code more flexible and scalable
