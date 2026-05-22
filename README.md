# Football Teams Manager

A simple full-stack project for managing football teams using Spring Boot (backend) and a basic frontend built with HTML, CSS, and JavaScript.

The project is designed to run locally using IntelliJ IDEA with default Spring Boot configuration.

---

## Project Status
In development  
New features will be added in the future, including players, ranking system, and a FIFA-style card system.

---

## Technologies Used

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL

### Frontend
- HTML
- CSS
- JavaScript (Fetch API)

---

## Current Features

- Create a team
- List all teams
- Update team data
- Delete team
- Full integration between frontend and backend (REST API)

---

## API Endpoints

- POST /times → Create a new team  
- GET /times → Get all teams  
- GET /times/{id} → Get team by ID  
- PUT /times/{id} → Update team  
- DELETE /times/{id} → Delete team  

---

## How to Run the Project (DEFAULT INTELLIJ WAY)

### 1. Backend (Spring Boot)

- Open the project in IntelliJ IDEA  
- Run the main class:


src/main/java/com/josepedro/projeto/ProjetoApplication.java


- The backend will start automatically on:


http://localhost:8080


---

### 2. Frontend

The frontend is served directly by Spring Boot.

Make sure your frontend files are placed in:


src/main/resources/static/


Example structure:


static/
├── index.html
├── script.js
├── style.css


---

### 3. Access the Application

After running the project, open your browser and go to:


http://localhost:8080/


The frontend will load automatically.

---

## Important Notes

- No need to use Live Server or any external frontend server
- No need to change API URLs in JavaScript
- The application runs fully inside Spring Boot
- The frontend and backend are served from the same domain (no CORS issues)

---

## Future Improvements

- Player system (FIFA-style cards)
- Team ranking system
- Points and standings table
- Better UI/UX design
- Authentication system

---

## Author

José Pedro
