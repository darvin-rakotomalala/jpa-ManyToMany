## Spring Data JPA/Hibernate | Many-To-Many
Dans ce repo, nous allons voir comment implémenter le mappage bidirectionnel Spring JPA `Many-To-Many` avec Hibernate dans un exemple Spring Boot à l'aide d'annotations `@ManyToMany`.

### Technologies
---
- Java 11
- Spring Boot 2.7.7
- Spring Data JPA
- Lombok
- MapStruct
- Maven 3+
- PostgreSQL

### Exemple
---
CRUD - L'entité `Student` a une relation plusieurs à plusieurs avec l'entité `Course`.

### Exécuter et tester le projet
---
- Exécuter l'application `mvn spring-boot:run`
- Importer dans Postman la collection `jpa-ManyToMany.postman_collection.json` pour tester les APIs
- Vous pouver utiliser aussi l'url du Swagger ou importer l'url Swagger dans Postman
  - Les descriptions OpenAPI seront disponibles au chemin `/v3/api-docs` par défaut : http://localhost:8081/v3/api-docs/ et/ou http://localhost:8081/swagger-ui/index.html
