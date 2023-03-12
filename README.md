# Java Term Project: Fundamentals of Programming (22-23)

## **Author:** Pablo Ferrería Hijón / **UVUS:** QSM2043

This project works with a dataset that takes the ranking of Horror Movies created from 2012 till today.
The dataset used is [this one](https://www.kaggle.com/datasets/PromptCloudHQ/imdb-horror-movie-dataset). It has been slightly edited to meet the parameters of this project.

## Structure of the project

- /src Folder: Contains all the modules with the functions and tests:
  - fp:
    - types: Contains the types
      - test: Contains test functions
- /data Folder:
  - IMDBHorrorMovies.csv: This archive is the dataset containing all the information

## Implemented types

### Base Type - HMovie
Represents a movie. Properties (self-explanatory by their names):
- title: String
- genres: String
- relDate (release date): LocalDate
- country: String
- rated (whether this movie has been rated for cinema or not): String
- score: Double
- duration: Integer
- cast: List
- language: HMLanguage
- budget (rounded, in thousand dollars): Integer

**Constructors**
- C1: Contains all the properties
- C2: Contains: title, relDate, country, duration, budget

**Constraints**
- R1: Title cannot be empty
- R2: Budget cannot be 0 nor negative
- R3: Duration cannot be 0 nor negative

**Natural Order:** By score and budget

**Other operations** 
- getExpensePerMinute(): Gives the money spent per minute of the film.

### Enum Type - HMLanguage
Languages the movies are:
CHINESE, ENGLISH, FILIPINO, FRENCH, GERMAN, HINDI, ITALIAN, JAPANESE, KOREAN, PORTUGUESE, RUSSIAN, SPANISH, TURKISH, OTHER.

### Record - Movie Nights
Represents the nights each country has for movies
