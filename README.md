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
![image2](https://github.com/user-attachments/assets/da20ca67-7ca9-4c21-8656-49c3d2e16e78)


### Movie Management
- **Create Movie**
![image4](https://github.com/user-attachments/assets/10ff0962-ee27-44e2-a56a-c814f4170cc7)

- **List Movies**
![image8](https://github.com/user-attachments/assets/99dd002e-3efa-4ce5-9692-0f0145a09eca)

- **Detail View**
![image6](https://github.com/user-attachments/assets/393c998d-6cdf-4ad5-ab3c-94036729b1b6)

- **Edit Movie**
<img width="1552" alt="image9" src="https://github.com/user-attachments/assets/20d7eb5d-31a7-4143-a40e-2efd846077eb" />


### Director Management
- **Create Director**
![image1](https://github.com/user-attachments/assets/b1de0216-6e54-494b-84f0-2f992a1cb0e3)

- **List Directors**
![image7](https://github.com/user-attachments/assets/6eab2a81-bc20-4026-b08c-4c094431a42e)

- **Detail View**
![image5](https://github.com/user-attachments/assets/cfcece7b-89ad-45b2-b570-7845ec3530c9)

- **Edit Director**
<img width="1552" alt="image10" src="https://github.com/user-attachments/assets/10db0d5e-ad47-43f1-88dc-0b1fc42d846d" />



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

