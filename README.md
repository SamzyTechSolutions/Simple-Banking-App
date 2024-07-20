```markdown
# SimpleBankingApp

A simple banking application implemented in Java with support for consumer and commercial accounts. This application includes account management, transactions, and user authentication. The project follows an object-oriented design and is tested using JUnit.

## Features

- Create consumer and commercial accounts
- Authenticate users
- Credit and debit accounts
- Manage authorized users for commercial accounts

## Class Diagram

The UML class diagram for this application is as follows:

![UML Class Diagram](UMLDiagram.png)

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/SamzyTechSolutions/Simple-Banking-App.git
    ```
2. Navigate to the project directory:
    ```sh
    cd Simple-Banking-App
    ```
3. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).

## Usage

### Creating Accounts

```java
Bank bank = new Bank();

// Create a consumer account
Person johnDoe = new Person("John", "Doe", 1);
Long consumerAccountNumber = bank.openConsumerAccount(johnDoe, 1234, 500.0);

// Create a commercial account
Company acmeCorp = new Company("Acme Corp", 123456);
Long commercialAccountNumber = bank.openCommercialAccount(acmeCorp, 5678, 1000.0);
```

### Managing Accounts

```java
// Authenticate user
boolean isAuthenticated = bank.authenticateUser(consumerAccountNumber, 1234);

// Credit and debit operations
bank.credit(consumerAccountNumber, 200.0);
bank.debit(consumerAccountNumber, 150.0);

// Check balance
double balance = bank.getBalance(consumerAccountNumber);
System.out.println("Balance: " + balance);
```

### Commercial Account Operations

```java
CommercialAccount commercialAccount = (CommercialAccount) bank.getAccount(commercialAccountNumber);
Person janeDoe = new Person("Jane", "Doe", 2);
commercialAccount.addAuthorizedUser(janeDoe);

// Check if a user is authorized
boolean isAuthorized = commercialAccount.isAuthorizedUser(janeDoe);
System.out.println("Is Jane Doe authorized? " + isAuthorized);
```

## Testing

JUnit tests are provided to verify the functionality of the application. To run the tests:

1. Open the project in your preferred IDE.
2. Run the test classes located in the `src/main/java` directory.

### Test Classes

- `BankTest`
- `ConsumerAccountTest`
- `CommercialAccountTest`

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes. Make sure to include tests for any new features or bug fixes.

### Directory Structure

```
Simple-Banking-App/
├── src/

│   ├── main/

│   │   ├── java/

│   │   │   ├── Bank.java

│   │   │   ├── Person.java

│   │   │   ├── Company.java

│   │   │   ├── Transaction.java

│   │   │   ├── BankInterface.java

│   │   │   ├── ConsumerAccount.java

│   │   │   ├── CommercialAccount.java

│   │   │   ├── AccountHolder.java

│   │   │   ├── TransactionInterface.java

│   │   │   ├── Account.java

│   │   │   ├── AccountInterface.java

│   ├── test/

│   │   ├── java/

│   │   │   ├── BankTest.java

│   │   │   ├── ConsumerAccountTest.java

│   │   │   ├── CommercialAccountTest.java

├── .gitignore

├── README.md

└── UML-Diagram.png

```
