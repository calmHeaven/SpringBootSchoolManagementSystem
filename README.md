# School Management System

This is a Spring Boot project for managing school-related tasks such as student registration and management. The system allows users to register students, view student details, update student information, and delete student records. Additionally, the project includes features for teacher management.

## Features

- **Student Registration**: Allows users to register new students by providing their name, email, date of birth, major, and years in the program.
- **Student Management**: Provides functionality to view, update, and delete student records.
- **Teacher Management**: Allows administrators to manage teachers' information, including their name, email, date of birth, degree, and faculty.

## Technologies Used

- **Spring Boot**: Backend framework for building the application.
- **Spring Data JPA**: Simplifies database access using the Java Persistence API (JPA).
- **Thymeleaf**: Server-side Java template engine for rendering HTML views.
- **Bootstrap**: Frontend framework for responsive design and styling.
- **PostgreSQL**: Relational database management system used for storing student and teacher information.
- **JavaScript**: Programming language for client-side interactions and form submissions.
- **HTML/CSS**: Markup and styling languages for building web interfaces.

## Getting Started

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/your-username/school-management-system.git
   ```

2. **Database Configuration**:

   - Install PostgreSQL and create a new database for the application.
   - Update the database configuration in `src/main/resources/application.properties` with your database URL, username, and password.

3. **Run the Application**:

   ```bash
   mvn spring-boot:run
   ```

   The application will start running at [http://localhost:8080/api/v1/[entityname]/].

4. **Access the Application**:

   Open a web browser and navigate to [http://localhost:8080/api/v1/[entityname]] to access the School Management System.

## Usage

- **Registration**: Click on the "Register" link to register a new student by providing their information in the registration form.
- **View/Edit/Delete**: Use the navigation links to view, edit, or delete existing student and teacher records.
- **Responsive Design**: The application is responsive and can be accessed from desktop, tablet, or mobile devices.

## Contributing

Contributions are welcome! Please feel free to open issues or submit pull requests for any improvements or new features.
