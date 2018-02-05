# spring-crud-operations
REST API of CRUD Operations Using 1)Spring Boot 2)JPA 3)Swagger 4)MySql

# Installation Instructions
    #Prerequisite: jdk, maven, mysql,git
    #Installation Steps
        1)Clone the repository
        2)Go to src/main/resources/application.properties
        3)Change the username and password(if needed) of 
                i)spring.datasource.username=<username>
                ii)spring.datasource.username=<password>
                
                
        4)mvn clean install
        5)java -jar target/course-api-data-0.0.1-SNAPSHOT.jar
        6)Browse Documentation: http://localhost:8080/swagger-ui.html
            i)Enter the username as "anand" and password as "anand123"