# Strategic Solutions Multi DB Concept

*Overview*
This repository contains a Java source code that demonstrates the use of multiple datasources within a single Spring Boot App. 
The application uses the following technologies:
- Java 21
- Spring Boot 3.2.5
- Gradle 8.8
- 2x PostgreSQL Databases
- 1x Mongodb Database

---
## Running guide
*Steps and commands to run the application locally:*
- Clone the repository
- Use Docker to run the databases (docker-compose.yml files in the *docker* directory)
- Use PGAdmin to setup the Pet database
    - Open http://localhost:8888 
    - Login with the following credentials:
        - Email: pgadmin@pgadmin.org
        - Password: pgadmin
    - Register a Server with the following parameters:
        - Name: pet
        - Hostname: postgres-pet
        - Port: 5432
        - Username: admin
        - Password: example
    - Add a new database called pet
    - Use the Query tool to execute the following:
        ```sql
        CREATE TABLE IF NOT EXISTS pet (
            id BIGINT PRIMARY KEY,
            pet_name VARCHAR(255) NOT NULL,
            pet_type VARCHAR(255) NOT NULL,
            breed VARCHAR(255) NOT NULL,
            age INTEGER NOT NULL,
        );
      
        CREATE SEQUENCE IF NOT EXISTS pet_id_seq;
            AS BIGINT
            START WITH 1
            INCREMENT BY 1;
        ```
    - Close the browser tab before proceeding

---      
- Use PGAdmin to setup the Contact database
    - Open http://localhost:9999
    - Login with the following credentials:
        - Email: pgadmin@pgadmin.org
        - Password: pgadmin
    - Register a Server with the following parameters:
        - Name: contact
        - Hostname: postgres-contact
        - Port: 5432
        - Username: admin
        - Password: example
    - Add a new database called employee
    - Use the Query tool to execute the following:
        ```sql
        CREATE TABLE IF NOT EXISTS contact (
            id BIGINT PRIMARY KEY,
            contact_name VARCHAR(255) NOT NULL,
            phone VARCHAR(255) NOT NULL,
            email VARCHAR(255) NOT NULL,
            address VARCHAR(255) NOT NULL
        );
      
        CREATE SEQUENCE IF NOT EXISTS contact_id_seq;
            AS BIGINT
            START WITH 1
            INCREMENT BY 1;
      ```
---
- Mongodb does not require manual setup
- run the application using the following command:
    ```shell
    gradle bootRun
    ```
---
- Interact with the databases using the following requests (Also located in *http* directory):
    ```http request
    ### Save Pet
    POST http://localhost:8080/pet
    Content-Type: application/json
    
    {
      "petName": "Cody",
      "petType": "Dog",
      "breed": "Pitbull",
      "age": 8
    }
    
    ### Save Contact
    POST http://localhost:8080/contact
    Content-Type: application/json
    
    {
      "contactName": "Percy the Pup",
      "phone": "555-123-4567",
      "email": "percy.pup@example.com",
      "address": "123 Happy Guy Lane, Bevery Grove CA, 90048"
    }
    
    ### Save Character
    POST http://localhost:8080/character
    Content-Type: application/json
    
    {
      "name": "Dr. Bell",
      "tvShowName": "The Resident",
      "main": false,
      "villain": false,
      "hero": true
    }
    
    ### Get Pets
    GET http://localhost:8080/pet
    
    ### Get Contacts
    GET http://localhost:8080/contact
    
    ### Get Characters
    GET http://localhost:8080/character
    
    ### Delete Pet by ID
    DELETE http://localhost:8080/pet/{id}
    
    ### Delete Contact by ID
    DELETE http://localhost:8080/contact/{id}
    
    ### Delete Character by ID
    DELETE http://localhost:8080/character/{id}
    ```
---
- Shut down the app by typing **ctrl+c** in your terminal
---

## Environments
This application only runs locally.