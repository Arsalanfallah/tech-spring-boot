# Spring Boot Project: Tech-Project

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies](#technologies)
4. [Setup and Installation](#setup-and-installation)
5. [Running the Application](#running-the-application)
6. [API Documentation](#api-documentation)
7. [Database Configuration](#database-configuration)
8. [Testing](#testing)
9. [Contributing](#contributing)
10. [License](#license)

## Introduction
[Provide a brief introduction to your project.]

This is a Spring Boot-based application that [describe what your application does]. It includes features such as [list some key features or functionality].

## Features
- Mapstruct
- Swagger
- Lombok

## Technologies
- **Java**: 17 (or your version)
- **Spring Boot**: 3.1.1
- **Maven**: [or Gradle if you use that]
- **Database**: H2, MySQL, PostgreSQL (whichever you're using)
- **Swagger/OpenAPI**: For API documentation
-    http://localhost:8080/swagger-ui/index.html  
- **JUnit/Mockito**: For unit and integration testing

## Setup and Installation

### Prerequisites
- Java 17 (or compatible version)
- Maven (or Gradle)
- An IDE (e.g., IntelliJ IDEA, Eclipse) or text editor
- [Any other tools you are using, e.g., Docker]
### Oracle Datasource
- If you want to install and config in windows,first you must download oracle with following address:
- https://www.oracle.com/database/technologies/xe-downloads.html
- If you want to learn how to install this you can watch this video
- Https://www.youtube.com/watch?v=DYleroLay5E
- After you install on your computer please , do following steps:
- 1- go to Windows Menu of Oracle and click SQLPLUS
- 2- Enter user-name: / as sysdba;
- 3- SQL> select name from v$pdbs;
- 4- SQL> connect sys/password@localhost:1521/XEPDB1 as sysdba;
- 5- SQL> create user student identified by password default talespace users quota unlimited on users;
- 6- SQL> grant create session,create table to student;
- 7- SQL> connect student/password@localhost:1521/XEPDB1;
### Installation Steps
 Clone the repository:   
 ```bash
   git clone https://github.com/ArsalanFallah/tech-spring-boot.git

