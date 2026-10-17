# Assignment 4 – Facade Design Pattern

## Student Print Center

This project demonstrates the **Facade Design Pattern** using a Student Print Center system.

The main purpose of the project is to simplify the document printing process.

The system performs several operations:

- File validation
- Printer checking
- Price calculation
- Payment processing
- Document printing

Instead of calling all subsystem classes directly, the client uses one Facade class that manages the entire process.

## Facade Pattern Structure

### Facade – PrintFacade

`PrintFacade` is the main class that provides a simple interface to the printing system.

It contains references to four subsystem classes:

```java
private final FileChecker fileChecker;
private final Printer printer;
private final Price price;
private final Payment payment;
```

The objects are created in the constructor:

```java
public PrintFacade() {
    fileChecker = new FileChecker();
    printer = new Printer();
    price = new Price();
    payment = new Payment();
}
```

The main method is `printDocument()`.

It calls the subsystem methods in the correct order:

```java
fileChecker.checkFile(fileName, pages, copies);

printer.checkReady(pages, copies);

int total = price.calculate(pages, copies, color);

payment.pay(total);

printer.printFile(fileName, pages, copies, color);
```

This allows the client to perform the entire printing process through one method.

The Facade also provides `addBalance()` and `getBalance()` methods to manage the student's balance.

### Subsystem 1 – FileChecker

`FileChecker` is responsible for validating documents before printing.

Its main method is:

```java
checkFile(String fileName, int pages, int copies)
```

It checks:

- The file name is not empty.
- The file format is PDF or DOCX.
- The number of pages is greater than zero.
- The number of copies is greater than zero.

If the input is invalid, the method throws an `IllegalArgumentException`.

This prevents invalid documents from being processed.

### Subsystem 2 – Printer

`Printer` is responsible for checking the printer and simulating document printing.

The printer starts with 100 sheets of paper.

It contains two main methods:

**checkReady()**

Checks whether there is enough paper for the requested pages and copies.

**printFile()**

Simulates printing the document and updates the remaining paper.

For example:

```java
int totalPages = pages * copies;
paperLeft -= totalPages;
```

If there is not enough paper, the system throws an `IllegalStateException`.

The printer supports both color and black-and-white printing modes in the simulation.

### Subsystem 3 – Price

`Price` is responsible for calculating the total printing cost.

The system uses two prices:

- Black and White – 20 KZT per page
- Color – 80 KZT per page

The main method is:

```java
calculate(int pages, int copies, boolean color)
```

The price depends on the number of pages, copies, and printing mode.

For example, 5 pages with 2 copies in black and white:

```java
5 * 2 * 20 = 200 KZT
```

The method returns the total price to the Facade.

The Facade then passes this amount to the Payment subsystem.

### Subsystem 4 – Payment

`Payment` is responsible for managing the student's balance and processing payments.

The initial balance is 1000 KZT.

It contains three methods:

- `pay()` – Checks the amount and processes payment.
- `addBalance()` – Adds money to the student's balance.
- `getBalance()` – Returns the current balance.

For example:

```java
balance -= amount;
```

If the student does not have enough money, the system throws an `IllegalStateException`.

Payment is completed before the document is printed.

### Client – Main

`Main` is the client class that uses the Facade.

It creates only the `PrintFacade` object:

```java
PrintFacade facade = new PrintFacade();
```

The client requests printing through one method:

```java
facade.printDocument("assignment.pdf", 5, 2, false);
```

The parameters represent:

- File name – assignment.pdf
- Pages – 5
- Copies – 2
- Color – false (Black and White)

The client does not create or directly call `FileChecker`, `Printer`, `Price`, or `Payment`.

The Facade manages all these operations internally.

## Project Structure

```text
src/
├── Main.java
├── PrintFacade.java
├── FileChecker.java
├── Printer.java
├── Price.java
└── Payment.java
```

## Clean Code Requirements

### 1. Meaningful Names

The project uses simple and descriptive class and method names.

For example:

- `FileChecker` clearly represents file validation.
- `Printer` represents printer operations.
- `Price` is responsible for price calculation.
- `Payment` handles payments.
- `PrintFacade` manages the printing process.

Methods such as `checkFile()`, `checkReady()`, `calculate()`, and `pay()` clearly describe their actions.

This makes the code easy to read and understand.

### 2. Single Responsibility Principle

Each class has one main responsibility.

- FileChecker validates files.
- Printer checks and prints documents.
- Price calculates printing costs.
- Payment manages the balance and payments.
- PrintFacade coordinates the printing process.

The Facade does not calculate prices or process payments itself.

Instead, it delegates these tasks to the correct subsystem classes.

This keeps responsibilities clearly separated.

### 3. No Leaking of Subsystem Details

The Facade provides simple public methods without exposing subsystem objects to the client.

For example:

```java
facade.printDocument("assignment.pdf", 5, 2, false);
```

The client only provides the document information.

It does not need to know how file validation, price calculation, payment, or printing work internally.

Subsystem details remain outside the client's normal interaction.

### 4. Small and Focused Classes

Each subsystem class contains methods focused on specific tasks.

For example:

- `checkFile()` validates document information.
- `calculate()` calculates the printing price.
- `pay()` processes the payment.
- `printFile()` performs the printing simulation.

The methods are separated instead of putting all operations into one large method.

This makes the system easier to understand and maintain.

### 5. Proper Error Handling

The project uses exceptions to handle invalid operations.

For example:

```java
throw new IllegalArgumentException("Invalid payment amount.");
```

The system handles several error situations:

- Invalid file names or formats
- Invalid number of pages or copies
- Not enough paper
- Not enough money
- Invalid payment amounts

The Main class uses `try-catch` to handle these errors and display messages.

The Facade calls validation methods before payment, preventing charges for invalid documents or insufficient paper.

This helps prevent incorrect operations.

## Why Facade Pattern Is Used

Without the Facade Pattern, the client would need to create and coordinate several objects:

```java
FileChecker fileChecker = new FileChecker();
Printer printer = new Printer();
Price price = new Price();
Payment payment = new Payment();
```

The client would also need to call their methods in the correct order.

**With the Facade Pattern**, the client only needs:

```java
PrintFacade facade = new PrintFacade();

facade.printDocument("assignment.pdf", 5, 2, false);
```

The Facade coordinates all four subsystem classes.

The system structure is:

```text
                 Main
                  |
                  v
             PrintFacade
                  |
       +----------+----------+
       |          |          |
       v          v          v
  FileChecker   Printer    Price
                  |
                Payment
```

All four subsystem classes are managed by `PrintFacade`. The arrows show a simplified view of the printing system.

The subsystem classes do not depend on `PrintFacade` and can also be used separately.

As a result, the client code becomes simpler and is less dependent on the internal system.

## Conclusion

The Facade Design Pattern provides a simple interface to a complex subsystem.

In this project, `PrintFacade` manages four subsystem classes: `FileChecker`, `Printer`, `Price`, and `Payment`.

Each class performs its own task, while the Facade coordinates the entire printing process.

This design reduces dependencies, separates responsibilities, and makes the code easier to understand, use, and maintain.
