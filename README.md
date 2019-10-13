# Reddit News Reader

Show top 15 news from reddit and store them on a database.

## Prerequisites

 * JDK 1.8+ must be installed and configured on your system. If not installed you can follow the instructions on the following link: https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t
 * To use dockerized version, docker along with docker compose must be installed and configured on your system. Detailed instructions can be found on the official documentation https://docs.docker.com/

## Build and run

Depending on your operating system open a shell or the command prompt and enter in the project directory `cd ./news-reader-be`

 * Unix systems
   * build: `./gradlew build`
   * run: `java -jar build/libs/news-reader-0.0.1-SNAPSHOT.jar`
 * Windows systems
   * build: `gradlew.bat build`
   * run: `java -jar build/libs/news-reader-0.0.1-SNAPSHOT.jar`

## Docker Build and Run
Depending on your operating system open a shell or the command prompt and enter in the docker directory `cd ./docker`

 * Build the image with `docker-compose build`
 * Run the image with `docker-compose up`
