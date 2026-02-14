# Library Manager API 📚

A professional RESTful API built with **Spring Boot** to manage a digital library. This project implements a complete set of CRUD operations with error handling and best practices.

## 🚀 Technologies
* **Java 17**
* **Spring Boot 3.x**
* **Spring Web** (REST API)
* **Maven** (Dependency Management)

## 🛠️ Features
* **Full CRUD**: Create, Read, Update, and Delete books.
* **Flexible Updates**: Supports both full (`PUT`) and partial (`PATCH`) updates for titles, authors, and page counts.
* **Batch Insertion**: Add multiple books in a single request.
* **ResponseEntity**: Uses professional HTTP status code responses for key endpoints.

## 📋 API Endpoints

### 📖 Reading
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/books` | Get all books |
| `GET` | `/books/title/{id}` | Get a book's title by ID (returns ResponseEntity) |
| `GET` | `/books/author/{name}` | Search books by author name |

### ✍️ Writing & Modifying
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/books` | Add a list of new books |
| `PUT` | `/books/{id}` | Update an entire book's data |
| `PATCH` | `/books/{id}/pages` | Update only the page count |
| `PATCH` | `/books/{id}/author` | Update only the author |
| `PATCH` | `/books/{id}/title` | Update only the title |

### 🗑️ Deleting
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `DELETE` | `/books/{id}` | Remove a book from the library |

## 🏗️ How to run
1. Clone the repository: `git clone https://github.com/matteo-pagnozzi/LibraryManager.git`
2. Run the application: `./mvnw spring-boot:run`
3. The API will be available at `http://localhost:8080`
