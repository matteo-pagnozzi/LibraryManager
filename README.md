# Library Manager API 📚

A professional RESTful API built with **Spring Boot** to manage a digital library. This project demonstrates the implementation of CRUD operations, exception handling, and clean code principles.

## 🚀 Technologies
* **Java 17**
* **Spring Boot 3.x**
* **Spring Web** (REST API)
* **Maven** (Dependency Management)

## 🛠️ Features
* **Get all books**: Retrieve the complete list of available books.
* **Find by ID**: Search for a specific book using its unique identifier.
* **Error Handling**: Custom responses for cases like "Book Not Found".

## 📋 API Endpoints
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/books` | Get all books |
| `GET` | `/books/title/{id}` | Get a book's title by ID |

## 🏗️ How to run
1. Clone the repository: `git clone https://github.com/matteo-pagnozzi/LibraryManager.git`
2. Run the application using Maven: `./mvnw spring-boot:run`
3. The API will be available at `http://localhost:8080`
