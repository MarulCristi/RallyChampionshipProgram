This program makes use of the SOLID principles, like Open/Close Principle (RallyCar and its subclasses handle car  functionality), Liskov Substitution Principle (AsphaltCar & GravelCar can be used wherever RallyCar is required), Interface Segregation (RaceResult defines only methods) and Dependency Inversion. It also uses Singleton (ChampionshipManager), to ensure a single championship instance.

How this Project is structured:
Driver.java: Represents a driver with name, country, points, and car
RallyCar.java: Abstract base class for all rally cars
AsphaltCar.java: Concrete implementation for asphalt cars, with their own calculatePerformance
GravelCar.java: Concrete implementation for gravel cars, with their own calculatePerformance
RaceResult.java: Interface for race result functionality
RallyRaceResult.java: Implementation of the race result interface
ChampionshipManager.java: Singleton class managing championship data
ChampionshipStatistics.java: Static utility class for championship statistics
RallyChampionship.java: Main class demonstrating the system
