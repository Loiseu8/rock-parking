# rock-parking
# RockParking

RockParking is a Java-based parking lot project that I am setting up to practice all my learning progress. This project follows the principles of Test-Driven Development (TDD), ensuring that only the necessary code is written.

## Table of Contents

- [About RockParking](#about-rockparking)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Changelog](#changelog)
- [Contributing](#contributing)
- [License](#license)
- [Contact Information](#contact-information)

## About RockParking

RockParking is a Java parking lot project that I am setting up to practice all my learning progress. 

### Criteria: Test Driven Development

- Only code what's needed

### Breakdown of Activity Diagram

**Entry into RockParking:**

- A camera captures the car's entry, time, and plate number.
- **1st Test Case:** Has the car entered? Yes or No?
  - If No, terminate.
  - If Yes, proceed to:
    - Is the car entry registered in the database? Yes or No?
      - If Yes, great, terminate.
      - If No, register the entry in the database.
    - Have the car details been registered in the database? (e.g., car plate number and time of entry) Yes or No?
      - If Yes, terminate.
      - If No, register the details in the database.

**When Car is Leaving:**

- A camera captures the time of departure.
- **Conditions to Assess:**
  - Is the car already registered? Yes or No?
  - How long has the car stayed in the park?
  - Has the car stayed for more than one hour?
    - If more than an hour, then did they buy a ticket?

### Important Things to Note to Self

- I will need to create code for all of the bullet points above.
- Write tests for each point first.
- Document as comments when coding.

**Scenarios:**

- **If no ticket but spent under an hour:** No penalty.
- **If no ticket and stayed past an hour:** Issue a penalty.
  - ```java
    System.out.println("Penalty issued.");
    ```
- **If a ticket was bought:** Validate their ticket.
  - Ensure the ticket matches the duration of the stay.
  - If no overstay, no action is required.
  - If overstayed, issue a penalty.


### Designing the Parking Lot System

**Core Entities (Classes) and Their Responsibilities:**

- **Car:** Represents a car entering or leaving the parking lot.
- **ParkingLot:** Manages the overall parking lot operations.
- **Ticket:** Represents a parking ticket issued when a car enters the lot.

**Single Responsibility Principle:** Each class will have a single responsibility, making it easier to manage and test.

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.6.0 or higher

### Steps

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/rockparking.git
    ```
2. Navigate to the project directory:
    ```sh
    cd rockparking
    ```
3. Build the project using Maven:
    ```sh
    mvn clean install
    ```

## Usage

To run the application, use the following command after building it:
```sh
mvn spring-boot:run
