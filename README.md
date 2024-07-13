# Transaction Service

## About the Project

The Transaction Service is a core component of a financial application, designed to handle various operations related to transactions. This service is implemented using Spring Boot, with a focus on ensuring reliability, scalability, and maintainability. It offers functionalities such as adding, retrieving, editing, and deleting transactions, while also handling exceptions and ensuring transactional integrity.

## Key Features

1. **Add Transaction**: 
   - Allows the creation of new transactions and saves them to the database.

2. **Retrieve Transactions**:
   - Fetches all transactions stored in the database.
   - Retrieves a specific transaction by its ID, with appropriate exception handling if the transaction does not exist.

3. **Edit Transaction**:
   - Updates the details of an existing transaction, ensuring the transaction exists before attempting to modify it.

4. **Delete Transaction**:
   - Deletes a transaction by its ID, with exception handling for non-existent transactions.

## Technology Stack

- **Java**: Core programming language used.
- **Spring Boot**: Framework for building the service.
- **Spring Data JPA**: For interacting with the database.
- **H2 Database**: An in-memory database for development and testing.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- IDE of your choice (IntelliJ, Eclipse, etc.)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/transaction-service.git

2. Navigate to the project directory:
   ```bash
   cd transaction-service

3. Build the project using Maven:
   ```bash
   mvn clean install

4. Run the application:
   ```bash
   mvn spring-boot:run


