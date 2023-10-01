# Student Management System (Spring Framework)

This project is a simple Student Management System built using the Spring Framework. It allows you to perform basic CRUD (Create, Read, Update, Delete) operations on student records stored in a MySQL database.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Database Configuration](#database-configuration)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- MySQL Database Server
- Git (optional, for cloning the project)

## Getting Started

### Database Configuration

1. Create a MySQL database named `springjdbc`.
2. Update the database connection details in the `application.properties` file located in `src/main/resources` if needed.

### Running the Application

1. Clone this repository (if not done already):

   ```shell
   git clone https://github.com/yourusername/spring-student-management.git
   ```

2. Navigate to the project directory:

   ```shell
   cd spring-student-management
   ```

3. Build the project using Maven:

   ```shell
   mvn clean install
   ```

4. Run the application:

   ```shell
   mvn spring-boot:run
   ```

The application will start, and you can access it via a command-line menu.

## Usage

The application provides the following options:

1. Insert new student details.
2. Retrieve details of a single student.
3. Update student details.
4. Delete a student.
5. Display details of all students.
6. Exit the application.

Follow the on-screen instructions to interact with the system.

## Project Structure

- `src/main/java/com.springcurd.entities`: Contains the Student entity class.
- `src/main/java/com.springcurd.dao`: Contains the Student DAO (Data Access Object) class.
- `src/main/java/com.springcurd.main`: Contains the application configuration and main class.
- `src/main/resources`: Contains configuration files, including `application.properties`.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, please open an issue or create a pull request.

## License
