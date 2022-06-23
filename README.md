# users-accounts

## About it

This project is a basic implementation of Spring-Boot with Swagger 3.0, and a its data is being persisted on H2 Database (in Memory).

## Enviroment of Development

It was built using JDK 18, on Windows 10.

## To Run it

You must clone the repository to your local host, and run the file in:
**/users-accounts-main/src/main/java/com/exercise5/usersaccounts/UsersAccountsApplication.java**

## To Containerize

Firt, it is needed to build the project using **Maven**:
```
root/users-accounts/~: ./mvnw package
```
Second, test the application:
```
root/users-accounts/~: java -jar target/users-accounts-0.0.1-SNAPSHOT.jar
```
And Finally, you can execute Dockerfile to create a Docker Image.
```
root/users-accounts/~: docker build -t users-accounts-application:latest .
```

## API Documentation (Swagger) and H2 Database

Once the application is running you can access:
  - all API Features Documentation on http://localhost:8080/swagger-ui/index.html
  - H2 Database GUI on http://localhost:8080/h2 (User Name: **sa** / Password: )
