# 📝 Issue Commenting API

A minimal Java backend API built with Spring Boot 3.2.0 to manage comments on issues.  
It uses **in-memory storage** (no database), follows **REST principles**, and includes **validation**, **unit tests**, and **Docker support**.

---

##  Features

-  Add comments to an issue
-  Fetch comments by `issueId`
-  Filter comments by `author`
-  In-memory storage using `ConcurrentHashMap`
-  Jakarta Validation (Spring Boot 3+)
-  RESTful API with clean separation (Controller, Service, Model)
-  Unit and Controller tests with JUnit 5 & MockMvc
-  Dockerized build

---


## Build & Run Instructions

### Prerequisites

- Java 17+
- Maven 3.8+
- Docker (for containerized run)

### Build the Project

```bash
mvn clean package
```

---

### Run the App (Locally)

Make sure you've built the project using Maven:

```bash
mvn clean package
```

Then, start the application using the packaged JAR file:

```bash
java -jar target/comment-api-1.0.0.jar
```

The application will start on:  
 `http://localhost:8080`

---

## API Endpoints

### `POST /comments` — Add a New Comment

```bash
curl -X POST http://localhost:8080/comments   -H "Content-Type: application/json"   -d '{
    "issueId": "11111111-1111-1111-1111-111111111111",
    "author": "john_doe",
    "message": "This is my first comment"
  }'
```

### `GET /comments?issueId=...` — Get Comments by Issue ID

```bash
curl "http://localhost:8080/comments?issueId=11111111-1111-1111-1111-111111111111"
```

### `GET /comments?author=...` — Get Comments by Author

```bash
curl "http://localhost:8080/comments?author=john_doe"
```

### `GET /comments` — Get All Comments

```bash
curl http://localhost:8080/comments
```

---

## Run Tests

This project includes unit and controller-level tests using JUnit 5 and Spring's MockMvc.

To run the full test suite:

```bash
mvn test
```


##  Docker Instructions

Ensure Docker is installed and running.

###  Build Docker Image

```bash
docker build -t comment-api .
```

### Run the Container

```bash
docker run -p 8080:8080 comment-api
```

Now access the API at:  
 `http://localhost:8080`

> Note: Since the app uses in-memory storage, all data is reset on container restart.
