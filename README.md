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
- R4: Release date has to be before today

**Natural Order:** By score and budget

**Other operations** 
- getExpensePerMinute(): Gives the money spent per minute of the film
- getNumberActors(): Gives the number of cast members
- addGenre(String hm) / addGenres(List lhm): Adds genre(s) to the list of genres
- addActor(String hm) / addActors(List lhm): Adds actor(s) to the list of cast
- getMainCharacter(): Gets protagonist of the movie
- getMainGenre(): Gets main genre of the movie

### Enum Type - HMLanguage
Languages the movies are:
CHINESE, ENGLISH, FILIPINO, FRENCH, GERMAN, HINDI, ITALIAN, JAPANESE, KOREAN, PORTUGUESE, RUSSIAN, SPANISH, TURKISH, OTHER.

### Record - Movie Nights
Represents days where movies have been premiered in certain countries

### Factory - HMovieFactory
- List<HMovie> readHMoviesList (String fileName): Creates an list of movies from a file
- HMovies readHMovies(String fileName): Creates an object HMovies from a list of movies
- HMovie parseLine (String line): Creates an object of type HMovie from each line of a file
- LocalDate parseDate(String date): Parses the dates of the movies
- List<String> parseCast (String cast): Parses the list of actors and genres to an appropiate format
- HMLanguage getUpperCaseName(String lang): Capitalises the language names

### Container Type - HMovies
It can creates an empty collection, an object of type HMovies from the following parameter: Collection<HMovie> or an object of type HMovies.
Equality Criterion: Two HMovies are equal if they contain the same movies.

**Operations**
- Integer getNumberHMovies(): Returns the number of movies
- addHMovie (HMovie h) / addHMovies(Collection): Adds a movie(s) to the collection
- removeHMovie(HMovie h): Removes a movie from the collection

Implemented both with loops and streams (stream operations are denoted with an ST at the end of the name): 
- List<HMovie> filterByVar: Filters various variables (year, month, day, actor, genre, language and country)
- Boolean doMoviesContain(String a): Checks if any titles contain the parameter
- Boolean containsMoviewithActor(String actor): True if there is a movie with that actor.
- Boolean areMoviesGreaterThanScore(Double score): True if all movies have a score higher than the given one
- Integer countHMoviesFromCountry(String country): Counter of movies per country
- Integer sumBudgetMovies(): Sums the budget of all movies of a certain genre
- Double computeAverageScore(): Computes the average score of all movies
- List getHMoviesOfGenre(String genre): Filters the movies by the given genre
- Map<HMLanguage, Set<String>> getCountriesByLanguage(): Returns a map where the keys are languages and the keys are a list of movies of that language
- Map<String, Long> getNMoviesbyCountry(): Returns a map where the keys are countries and the keys are the number of movies of that country
  
Other operations:
- String getTitleOfMostExpensiveMovieOfCountry (String country): Returns the most expensive movie of a given country
- List<HMovie> bestMoviesFromActorInAYear(String actor, Integer year): Gets the best movies from a given actor in a given year
- Map<String, List<String>> getCheapestMovieOfActorOfEveryMainGenre(): Gives the cheapest movie of every main genre
- Map<HMLanguage, String> getBestMoviesForLanguages(): Gives the best movie of each language
- HMLanguage languageWithBestMovie(): Gives the language with the highest scored movie
- Map<String, List<String>> getMovieOfEveryMainGenreOrdered(): Gives a map with ordered movies assigned to every genre
- Map<String, List<String>> SortedMap<Integer, List<HMovie>> getMoviesByYearOrderedByScore(Integer n): Gives a ordered map with movies by year ordered by score
