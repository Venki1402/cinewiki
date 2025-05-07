# CineWiki - A Movie Directory Application

## Problem Statement
CineWiki is a web-based movie directory application designed to manage and showcase information about movies and their directors. The application addresses the need for:
- Organizing and maintaining a structured database of movies and directors
- Establishing relationships between movies and their respective directors
- Providing an intuitive interface for managing movie and director information
- Enabling easy access to movie details and director filmographies

## Architecture

### Technology Stack
- **Backend**: Spring Boot 3.2.3
- **Frontend**: JSP with Bootstrap 5
- **Database**: MySQL
- **Build Tool**: Maven
- **Java Version**: 21

### Project Structure
```
cinewiki/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.cinewiki/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   ├── resources/
│   │   │   └── application.properties
│   │   └── webapp/
│   │       └── WEB-INF/
│   │           └── views/
│   └── test/
│       └── java/
└── pom.xml
``` 

### Key Components
1. **Models**:
   - Movie (id, title, releaseYear, genre, plot, budget, boxOffice)
   - Director (id, name, birthDate, nationality)

2. **Controllers**:
   - MovieController
   - DirectorController

3. **Services**:
   - MovieService
   - DirectorService

4. **Repositories**:
   - MovieRepository (JPA)
   - DirectorRepository (JPA)

## APIs

### Movie Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/movies` | List all movies |
| GET | `/movies/new` | Show movie creation form |
| POST | `/movies` | Create new movie |
| GET | `/movies/{id}` | Show movie details |
| GET | `/movies/{id}/edit` | Show movie edit form |
| POST | `/movies/{id}` | Update movie |

### Director Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/directors` | List all directors |
| GET | `/directors/new` | Show director creation form |
| POST | `/directors` | Create new director |
| GET | `/directors/{id}` | Show director details |
| GET | `/directors/{id}/edit` | Show director edit form |
| POST | `/directors/{id}` | Update director |

## Screenshots

### Home

```
[Screenshot of movie creation form]
``` 

### Movie Management
- **Create Movie**
```
[Screenshot of movie creation form]
``` 
- **List Movies**
```
[Screenshot of movies list page]
``` 
- **Edit Movie**
```
[Screenshot of movie edit form]
``` 

### Director Management
- **Create Director**
```
[Screenshot of director creation form]
``` 
- **List Directors**
```
[Screenshot of directors list page]
``` 
- **Edit Director**
```
[Screenshot of director edit form]
``` 

## Tests

### Unit Tests
The application includes comprehensive unit tests for:
- Repository layer (using H2 in-memory database)
- Service layer
- Controller layer

### Test Coverage

- MovieRepositoryTest
    - testFindByDirectorId
    - testFindAllMoviesWithDirectors
    - testSaveMovie
    - testDeleteMovie
    - testFindById

- DirectorRepositoryTest
    - testFindById
    - testSaveDirector
    - testDeleteDirector
    - testFindAllDirectors

- MovieServiceTest
    - testGetAllMovies
    - testGetMovieById
    - testSaveMovie
    - testDeleteMovie
    - testGetMoviesByDirectorId

- DirectorServiceTest
    - testGetAllDirectors
    - testGetDirectorById
    - testSaveDirector
    - testDeleteDirector

- MovieControllerTest
    - testListMovies
    - testCreateMovie
    - testUpdateMovie
    - testDeleteMovie
    - testShowMovieDetails

- DirectorControllerTest
    - testListDirectors
    - testCreateDirector
    - testUpdateDirector
    - testShowDirectorDetails

### Running Tests
```
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=MovieRepositoryTest

# Run with coverage report
mvn test jacoco:report
``` 

## Setup and Installation

1. Clone the repository
``` 
git clone https://github.com/Venki1402/cinewiki
``` 

2. Configure MySQL database
```
spring.datasource.url=jdbc:mysql://localhost:3306/cinewiki_db
spring.datasource.username=root 
spring.datasource.password=root
``` 

3. Build the project
```
mvn clean install
``` 

4. Run the application
```
mvn spring-boot:run
``` 

5. Access the application at `http://localhost:8080`

