# JPA_Project
This repository contains the implementation of the JAVA project of Database 2 course, from Politecnico di Milano, in which you have to implement a web interface, that allows the end user to interact with a MySQL Database through the JPA API.
In this repository you can find also some text documents whcih contains: Java code of the WEB part(presentation layer), Java code of the EJB part(business layer), DDL SQL for creating the DB(data layer), Triggers implemented in the DB, HTML templates written in Thymeleaf.


# SPECIFICATIONS

An application deals with gamified consumer data collection. A user registers with a username, a password and an email. A registered user logs in and accesses a HOME PAGE where a “Questionnaire of the day” is published. 
The HOME PAGE displays the name and the image of the “product of the day” and the product reviews by other users.
The HOME PAGE comprises a link to access a QUESTIONNAIRE PAGE with a questionnaire divided in two sections: a section with a variable number of marketing questions about the product of the day (e.g., Q1: “Do you know the product?” Q2: Have you purchased the product before?” and Q3 “Would you recommend the product to a friend?”) and a section with fixed inputs for collecting statistical data about the user: age, sex, expertise level (low, medium high). 
The user fills in the marketing section, then accesses (with a next button) the statistical section where she can complete the questionnaire and submit it (with a submit button), cancel it (with a cancel button), or go back to the previous section and change the answers (with a previous button).
All inputs of the marketing section are mandatory. All inputs of the statistical section are optional. 
After successfully submitting the questionnaire, the user is routed to a page with a thanks and greetings message. 
The database contains a table of offensive words. If any response of the user contains a word listed in the table, the transaction is rolled back, no data are recorded in the database, and the user’s account is blocked so that no questionnaires can be filled in by such account in the future. 
When the user submits the questionnaire one or more trigger compute the gamification points to assign to the user for the specific questionnaire, according to the following rule: 
1. One point is assigned for every answered question of section 1 (remember that the number of questions can vary in different questionnaires). 
2. Two points are assigned for every answered optional question of section 2. 
When the user cancels the questionnaire, no responses are stored in the database. However, the database retains the information that the user X has logged in at a given date and time. 
The user can access a LEADERBOARD page, which shows a list of the usernames and points of all the users who filled in the questionnaire of the day, ordered by the number of points (descending). 

The administrator can access a dedicated application on the same database, which features the following pages 
A CREATION page for inserting the product of the day for the current date or for a posterior date and for creating a variable number of marketing questions about such product. 
An INSPECTION page for accessing the data of a past questionnaire. The visualized data for a given questionnaire include 
	o List of users who submitted the questionnaire. 
	o List of users who cancelled the questionnaire. 
	o Questionnaire answers of each user. 
A DELETION page for ERASING the questionnaire data and the related responses and points of all users who filled in the questionnaire. 
![image](https://user-images.githubusercontent.com/72922439/185754976-730a8c5e-a84c-4b4c-a2a6-0685eea2238a.png)
