# 💻 Cloud Native Challenge


> Welcome to the cloud native challenge. You will use this readme file to guide you through your tasks.

### ☕ Functional requirements

> Your client operates in the field of sports activities. It asked you to build a rest api based on the [openapi.xml](openapi.xml) document.

> You can use https://editor.swagger.io/ for a better view of the document.
Read more about it [here](https://swagger.io/docs/specification/about/)

### 🤓 Technical requirements

> The client has required you to use the following technologies:

- Java 8+
- Maven
- Spring Boot, MVC and JPA
- Docker
- JUnit
- [JIB](https://cloud.google.com/java/getting-started/jib)
- [Lombok](https://medium.com/collabcode/projeto-lombok-es1crevendo-menos-c%C3%B3digo-em-java-8fc87b379209)
- Google Kubernetes Engine (GKE)
- Container Registry
- Google Cloud Storage
- Cloud Logging

### 🐞 Backlog

1. Go to https://start.spring.io/ and create a new spring boot project and then add it to this project as a first commit. You can add a default dependencies:
 - Spring Web
 - Spring Data JPA
2. Implement the rest api documented in the openapi.xml file using the technologies.
 - Spring Boot, MVC and JPA
 - Lombok (to avoid verbose classes)
 - [Postman (to call your rest api)](https://learning.postman.com/docs/getting-started/sending-the-first-request/)
 - PgAdmin(to query used database tables)
3. Create a Container Image using [JIB](https://cloud.google.com/java/getting-started/jib)
4. Deploy your Container Image to [GKE](https://cloud.google.com/kubernetes-engine/docs/tutorials/hello-app)
5. Use lombok and log4j to write your API logs.
6. Look for your application logs in Cloud Logging.
8. Ensure your code has at least 60% [test coverage](https://www.jetbrains.com/help/idea/running-test-with-coverage.html#fe1f1331) using Junit