# Low-Level Design Playground 🎢

*This is where my low-level design ideas take shape and come alive!*

---

## Why This Playground? 

This repo serves as:

- **A Personal Diary**: A place where ideas are scribbled, refined, and transformed into design gems.
- **A Learning Hub**: Quick brush-ups on essential OOD concepts and principles.
- **An Inspiration Station**: Finding some spark to code by exploring different design patterns and principles.

---

## Quick OOD Brush-Up

### The SOLID Principles 

Building software is like constructing a building—you need a strong foundation. The SOLID principles are the bedrock of maintainable and scalable object-oriented design.

1. **Single Responsibility Principle (SRP)**

   *"A class should have one, and only one, reason to change."*

   **Example**: Imagine a `TextEditor` class that handles text formatting, spell checking, and file saving. According to SRP, each of these should be separate classes. This way, changes in spell checking algorithms don't affect file saving functionalities.

2. **Open/Closed Principle (OCP)**

   *"Software entities should be open for extension, but closed for modification."*

   **Example**: Suppose you have a `Notification` system that sends emails. Later, you need to add SMS notifications. Instead of modifying the existing email code, you can extend the `Notification` class to include SMS, adhering to OCP.

3. **Liskov Substitution Principle (LSP)**

   *"Objects of a superclass should be replaceable with objects of subclasses without breaking the application."*

   **Example**: If you have a `Bird` class with a `fly()` method, and a `Penguin` subclass, the `Penguin` should not inherit `fly()` since penguins can't fly. Violating LSP can lead to unexpected behaviors.

4. **Interface Segregation Principle (ISP)**

   *"No client should be forced to depend on methods it does not use."*

   **Example**: If you have an interface `IMultiFunctionDevice` that includes `print()`, `scan()`, and `fax()`, a device that only prints shouldn't be forced to implement empty `scan()` and `fax()` methods. Instead, split the interfaces into smaller, specific ones.

5. **Dependency Inversion Principle (DIP)**

   *"Depend upon abstractions, not concretions."*

   **Example**: High-level modules shouldn't depend on low-level modules. Both should depend on abstractions. For instance, a `DatabaseAccess` class should depend on a `DatabaseInterface` rather than a concrete `MySQLDatabase` class.

---

### Top 5 Design Patterns You Should Know 

Design patterns are tried-and-true solutions to common problems in software design. Here's a quick tour of the most impactful ones:

1. **Singleton Pattern**

   *Ensure a class has only one instance and provide a global point of access to it.*

   **Use Case**: Managing a shared resource like a configuration object or a connection pool.

2. **Factory Pattern**

   *Define an interface or abstract class for creating an object but let subclasses decide which class to instantiate.*

   **Use Case**: When the exact types and dependencies of the objects aren't known until runtime.

3. **Observer Pattern**

   *Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified.*

   **Use Case**: Event handling systems, like UI frameworks where a change in one component updates others.

4. **Strategy Pattern**

   *Define a family of algorithms, encapsulate each one, and make them interchangeable.*

   **Use Case**: Implementing different sorting algorithms that can be swapped based on the context.

5. **Decorator Pattern**

   *Attach additional responsibilities to an object dynamically.*

   **Use Case**: Adding functionalities to objects without altering their structure, like adding scrollbars to a window.

---

*Happy Designing!* 🎉
