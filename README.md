# MovieDatabase-API

Spring Boot REST Service to obtain movie information.

| HTTP Method | URI |Description |
| --- | --- | --- |
| GET | `/api/v1/movies` | Return a list of movies |
| GET | `/api/v1/movies/id={movie_id}` | Return a specific movie |
| GET | `/api/v1/movies/t={title)` | Return a list of movies with given title (ignore case) |
| GET | `/api/v1/movies/count` | Return the number of movies in the database |
| POST | `/api/v1/movies` | Create a new movie |
| PUT | `/api/v1/movies` | Update a movie |


## Tested on

- Java SE Development Kit 8
- Maven 3.0+
- MySQL 5.0+ _(should work with any other relational database, but you need to change dependency)_

## Getting Started

Import the Maven project straight to your Java IDE, create database with name moviedb and change db credientials in file **_application.properties_**.