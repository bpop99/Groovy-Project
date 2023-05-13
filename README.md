* Names: Ben Poplin, Erick Arcos
* Course/Semester: CS343/SPR23 
* Assignment: CSC343 Language Project
* Sources consulted: Stack Overflow, ScrapingBee.com (Project inspiration) link: https://www.scrapingbee.com/blog/web-scraping-with-groovy/
To use the program navigate to the directory containing the classes and enter "groovy Main.groovy" in the terminal. This project includes a groovy Scraper class which makes a request to a website, parses and stores the data into an Article object, and adds the entry to a Stories object. The Stories Java class uses a map to store the articles. It includes a method add() to add articles to the map, search() to search for articles by topic and returns a list of articles with that mention the topic in the title. The goal was to use the Article class inside of the Stories Java class but there is an unsolved import bug currently. One of the main features we wanted to demonstrate was Java's compatibility with Groovy.