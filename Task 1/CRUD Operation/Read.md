# CRUD API for Books

## Objective
Create a REST API that allows users to perform CRUD (Create, Read, Update, Delete) operations on a book.

## Requirements
- Use a web framework (e.g., Spring Boot for Java).
- Implement the following endpoints:
  - **POST /books**: Create a new book.
  - **GET /books**: Retrieve a list of all books.
  - **GET /books/:id**: Retrieve a specific book by ID.
  - **PUT /books/:id**: Update a specific book by ID.
  - **DELETE /books/:id**: Delete a specific book by ID.
- Use a database to store book information (e.g., MySQL, PostgreSQL).
- Validate input data to ensure data integrity.
- Handle errors gracefully and return appropriate HTTP status codes.

## Example
Here is an example of how the API endpoints should work:

### Create a new book
**POST /books**
```json
{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "publishedDate": "1925-04-10"
}
```

### Retrieve all books
**GET /books**

### Retrieve a specific book by ID
**GET /books/1**

### Update a specific book by ID
**PUT /books/1**
```json
{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "publishedDate": "1925-04-10"
}
```

### Delete a specific book by ID
**DELETE /books/1**

## Project Structure

```
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           └── crud_api
    │               ├── Controller
    │               │   └── BookController.java
    │               ├── Service
    │               │   └── BookService.java
    │               ├── Repository
    │               │   └── BookRepository.java
    │               ├── model
    │               │   └── Book.java
    │               └── CrudApiApplication.java
    └── resources
        ├── application.properties
```
