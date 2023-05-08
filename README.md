
# Notes Service


## Features

- Authorization
- Authentication
- Swagger integration with schema description
- Docker compose file for MongoDB
- MongoExpress
Api posibility:
- register user
- getting access to distinct endpoints
- note CRUD operations
- user CRUD operations
- like CRUD operations


## API Reference

#### SWAGGER UI

```http
http://localhost:8080/swagger-ui/index.html#
```

#### MONGO EXPRESS

```http
http://localhost:8081
```



## Run Locally

Maven install

```bash
  mvn clean install
```

Run docker container

```bash
  docker-compose up -d 
```

Create MongoDB with MongoExpress UI

```bash
  add db by name -> notesdb
```

Lets go

```bash
  run project
```

