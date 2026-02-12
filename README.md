💊 Pharmacy Management System

A Java-based web application for managing pharmacy operations such as adding medicines, viewing available stock, and displaying medicine details.
The application follows a layered architecture using Servlets, JSP, DAO, and Utility classes.

#📌 Project Overview#

This Pharmacy Management System allows administrators to:

➕ Add new medicines

📋 View all available medicines

🔍 Search and view specific medicine details

⚠️ Handle invalid inputs with custom exception handling

The application follows a clean MVC-like layered structure:

Bean Layer – Represents data model

DAO Layer – Handles database interactions

Service Layer – Contains business logic

Servlet Layer – Handles HTTP requests/responses

Utility Layer – Database connection and custom exceptions

View Layer (JSP/HTML) – Frontend pages

🧩 Technologies Used

Java

Servlets

JSP

JDBC

HTML

Apache Tomcat (Server)

Oracle (Database – configurable in DBUtil.java)

🔄 Application Flow

User accesses Menu.html

Requests are sent to MainServlet

Servlet calls the Administrator (Service Layer)

Service layer interacts with PharmacyDAO

DAO performs database operations via DBUtil

Results are forwarded to appropriate JSP pages

⚙️ Setup Instructions

1️⃣ Prerequisites

JDK 8 or above

Apache Tomcat 9+

Oracle Database

Eclipse (Dynamic Web Project)

3️⃣ Deployment Steps

Import project into Eclipse as Dynamic Web Project

Configure Apache Tomcat Server

Build the project

Deploy on server

🚀 Features

Layered architecture (Clean separation of concerns)

Custom exception handling

JDBC-based database interaction

Simple and intuitive UI

Scalable structure

👨‍💻 Author

Developed as part of Java Web Application practice project.

Output:

<img width="726" height="355" alt="Screenshot 2026-02-12 135936" src="https://github.com/user-attachments/assets/d2a5c9df-e9c2-478d-8309-aaa603328727" />


<img width="707" height="568" alt="Screenshot 2026-02-12 135957" src="https://github.com/user-attachments/assets/9de2c532-8c06-4986-b92e-6bb2a0678f4d" />


<img width="742" height="515" alt="Screenshot 2026-02-12 135916" src="https://github.com/user-attachments/assets/de6d6e17-7e1d-41a5-b74e-f6c401d2ad43" />


<img width="747" height="343" alt="Screenshot 2026-02-12 135927" src="https://github.com/user-attachments/assets/970435b1-afaf-4234-91b7-1870dd84243b" />


<img width="950" height="396" alt="Screenshot 2026-02-12 135945" src="https://github.com/user-attachments/assets/eedd9900-3838-446a-a3e5-7d0c9b56b38a" />


<img width="1012" height="609" alt="Screenshot 2026-02-12 140042" src="https://github.com/user-attachments/assets/0facb450-9250-4d14-b213-f8e0bae611ef" />





