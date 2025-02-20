# TMDB CLI Tool

A command-line interface (CLI) tool built with Java and Spring Shell to fetch and display movie information from [The Movie Database (TMDB) API](https://www.themoviedb.org/documentation/api).

## Features

- Fetch and display movies categorized as:
    - Now Playing
    - Popular
    - Top Rated
    - Upcoming
- Handle API errors and network issues gracefully
- User-friendly CLI interface

## Prerequisites

- Java 17+
- Maven or Gradle
- TMDB API Key (Sign up at [TMDB API](https://developer.themoviedb.org/docs/getting-started) to get one)

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/ErickBrayan/TMDB-CLI-Tool.git
   cd tmdb-cli-tool
   ```

2. Configure API Key:
    - Set your API key in `application.properties` or as an environment variable.

3. Build the application:
   ```sh
   mvn clean package
   ```

## Usage

Run the CLI tool:

```sh
java -jar target/tmdb-cli-tool.jar
```

Use the following commands to fetch movies:

```sh
tmdb-app --type playing
tmdb-app --type popular
tmdb-app --type top
tmdb-app --type upcoming
```

## Example Output

```sh
$ tmdb --type popular
.___________..___  ___.  _______  .______        ______  __       __  
|           ||   \/   | |       \ |   _  \      /      ||  |     |  | 
`---|  |----`|  \  /  | |  .--.  ||  |_)  |    |  ,----'|  |     |  | 
    |  |     |  |\/|  | |  |  |  ||   _  <     |  |     |  |     |  | 
    |  |     |  |  |  | |  '--'  ||  |_)  |    |  `----.|  `----.|  | 
    |__|     |__|  |__| |_______/ |______/      \______||_______||__|
________________________________________________________________________

🎬	Flight Risk
📅	Release Date: 2025-01-22
🌍	Language:     English
⭐	Rate:         ⭐⭐½
📖	Resume:       A U.S. Marshal escorts a government witness to trial after he's accused of getting involved with a mob boss, only to discover that the pilot who is transporting them is also a hitman sent to assassinate the informant. After they subdue him, they're forced to fly together after discovering that there are others attempting to eliminate them.

-------------------------------------------------------------------------------------------
🎬	Wolf Man
📅	Release Date: 2025-01-15
🌍	Language:     English
⭐	Rate:         ⭐⭐⭐
📖	Resume:       With his marriage fraying, Blake persuades his wife Charlotte to take a break from the city and visit his remote childhood home in rural Oregon. As they arrive at the farmhouse in the dead of night, they're attacked by an unseen animal and barricade themselves inside the home as the creature prowls the perimeter. But as the night stretches on, Blake begins to behave strangely, transforming into something unrecognizable.
```

## Error Handling

- Displays meaningful error messages for API failures or network issues.
- Ensures a smooth user experience even with unexpected errors.

https://roadmap.sh/projects/tmdb-cli
