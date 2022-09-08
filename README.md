# hogwarts-room-manager
This project is a simple RESTful Spring Boot application where rooms in a wizard school can be managed.
From the index page, access the room manager page by a button click, where you can find further operations. 

## Endpoints
| Endpoint   | Function           |
|------------|--------------------|
| GET /      | Display index page.|
| GET /rooms | Display all rooms. |
| GET /rooms/available | Display rooms which are not full yet. |
| GET /rooms/rat-owners | Display rooms where there are no cat or owl owner students. |
| POST /rooms | Create new room. |
| GET /rooms/{roomId} | Get room by room id. |
| DELETE /rooms/{roomId} | Delete room by room id. |
| PUT /rooms/{roomId} | Update a room to be "renovated". |
| GET /students | Display all students. |


## Prerequisites
 - [Java 17+](https://www.oracle.com/java/technologies/downloads/#java17)
 - [Apache Maven 3.8.5 +](https://maven.apache.org/download.cgi)
 
 ## Running application using Maven
 - Open a terminal and navigate to the project folder
 - Run the following Maven command to start the application:
    - ./mvnw clean spring-boot:run

## Shutdown
- To stop the application, go to the terminal where it is running and press Ctrl+C.
