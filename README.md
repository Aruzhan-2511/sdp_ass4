# Student Print Center

## Project Description

Student Print Center is a simple Java application that demonstrates the Facade Design Pattern.

The system allows students to print documents. It checks the file, verifies the printer, calculates the price, processes the payment, and prints the document.

The main goal is to simplify the printing process using the Facade Pattern.

## Design Pattern

**Pattern:** Facade

**Type:** Structural Design Pattern

The Facade Pattern provides a simple interface to a complex system. Instead of working with multiple classes, the client communicates with one Facade class.

In this project, `PrintFacade` manages the printing process.

## Project Structure

The project contains 6 Java classes:

1. **Main** — The client class that uses PrintFacade.
2. **PrintFacade** — Coordinates all subsystem classes.
3. **FileChecker** — Checks the file format, pages, and copies.
4. **Printer** — Checks printer availability and simulates printing.
5. **Price** — Calculates the printing cost.
6. **Payment** — Manages the student's balance and payment.

## How It Works

1. The student requests document printing.
2. FileChecker validates the document.
3. Printer checks if enough paper is available.
4. Price calculates the total cost.
5. Payment checks the balance and processes the payment.
6. Printer prints the document.

The client only interacts with PrintFacade.

## Features

- PDF and DOCX file validation
- Black and white printing — 20 KZT per page
- Color printing — 80 KZT per page
- Printing cost calculation
- Student balance management
- Printer paper management
- Error handling for invalid files, insufficient balance, and insufficient paper

This project simulates printing and payments without using a real printer or payment service.

## Clean Code Principles

1. **Meaningful Names** — Classes and methods have clear names.
2. **Single Responsibility Principle** — Each class has one main responsibility.
3. **Encapsulation** — Internal data is protected using private fields.
4. **Small Methods** — Methods are simple and focused on specific tasks.
5. **Error Handling** — The system handles invalid input and printing errors using exceptions.

## How to Run

1. Open the project in IntelliJ IDEA.
2. Open `Main.java`.
3. Run the main method.
4. Check the results in the console.

## Technologies

- Java
- IntelliJ IDEA
- Git and GitHub

## Conclusion

This project demonstrates how the Facade Design Pattern simplifies communication between different classes. It makes the client code easier to understand and maintain.