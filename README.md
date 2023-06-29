# Bilal Haider - Ticketmaster Tech Test

Welcome to my Technical Assessment for the Ticketmaster role of Senior Android Engineer.

The challenge was to use the Discover API endpoint for searching for events.

The code contains the following
    * MVVM architecture
    * Domain layer separated into separate module for Networking and Local requests
    * Room for Database local storage
    * KTOR for API calls
    * MockK for mocking frameworks
    * JUnit for testing
    * Jetpack Compose for UI layers
    * Hilt for Dependency Injection
    * Coroutines for Multithreading
    * Flows for observables
    * Kover for code coverage statistics
    * Repository pattern for retrieving data from the viewModel

This project will compile without any necessary extras

The code has a test coverage of roughly 51% - due to time constraints I was not able to write tests for my ViewModels

NOTE: Only happy paths were tested due to time constraints and no espresso testing was done

The app populates a list of search results where the user can add them to a saved list. Once added they can tap "Display saved events" and the list will repopulate with items from db
