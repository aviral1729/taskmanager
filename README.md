# Task Manager API

A simple **Task Manager API** built with **Spring Boot** to manage tasks. This application supports CRUD operations for tasks, with user assignment using a PostgreSQL database.

---

## Features
- Create, read, update, and delete tasks.
- Assign tasks to users.
- Fetch tasks for specific users.
- Store task and user data in PostgreSQL.
- RESTful API with JSON responses.

---

## Prerequisites
To run this project, ensure you have the following installed:
1. **Java Development Kit (JDK)** (version 11 or higher)
2. **Maven** (for dependency management)
3. **PostgreSQL** (version 12 or higher)
4. **Postman**  (for testing APIs)






The Task Manager API was developed to manage tasks and users in a structured and efficient way. The main goal was to create an application where users can perform CRUD (Create, Read, Update, Delete) operations for both tasks and users. Additionally, tasks needed to be assigned to users, and this assignment was a mandatory requirement to ensure clarity in task ownership.

To start, I identified the core requirements and structured the system into two primary entities: User and Task. The User entity includes fields like firstName, lastName, timeZone, and isActive, representing the user’s basic information and status. The Task entity captures information about the task itself, including title, description, status, and timestamps (createdAt and updatedAt). Each task is assigned to a specific user through a foreign key relationship, ensuring a clear linkage between tasks and their respective owners.

I chose Spring Boot for this project as it simplifies REST API development. For the database, I used PostgreSQL, which is reliable and supports advanced features for relational data. The data layer was managed using Spring Data JPA and Hibernate for seamless interaction between the Java code and the database. Maven was used for managing dependencies and building the project efficiently.

The database was designed with two tables: Users and Tasks. The Users table stores user details, while the Tasks table holds task-related information. A one-to-many relationship was established between the two, where one user can have multiple tasks, but each task belongs to only one user. This relationship was implemented using JPA annotations like @OneToMany and @ManyToOne.

The project followed a layered architecture. The Entity Layer defined the data models, while the Repository Layer handled database operations using Spring Data JPA. The Service Layer encapsulated the business logic, ensuring that the code remained modular and easy to maintain. Finally, the Controller Layer exposed the endpoints for interacting with the API. For instance, endpoints were created for creating, updating, deleting, and retrieving users and tasks.

For testing, I used Postman to verify the functionality of all API endpoints. This ensured that the application behaved as expected, with proper validation for required fields and constraints. During the development, I also ensured that timestamps were stored in UTC, making the application consistent across different time zones.

While the Task Manager API fulfills its primary purpose, I considered potential enhancements for the future. Adding authentication and authorization (e.g., using JWT tokens) would make the system more secure. Pagination could be introduced to handle large datasets efficiently, and additional error-handling mechanisms could improve user feedback further. Writing comprehensive unit and integration tests would also enhance the reliability of the code.







