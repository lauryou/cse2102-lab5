# cse2102-lab5
In this lab, Spring Boot and Thymleaf are used to create an application that has three functions. It first asks for a login (email and password), and checks the validity of that email ("@" character) and password (length) upon submission. Once the user is "logged in", they are directed to a "Welcome" page, from which they can click to take the quiz.

The quiz is composed of 5 questions on nature-related things (sea, global warming, Earth). Each question can be answered via the "True" and "False" buttons below -- only one can be clicked. The user's score is tracked, and for each correct answer, the score is increased by 20. If all questions are answered correctly, the score will be a 100. The user's score is presented following the last question under the "Congrats!". 

## Description of Endpoints

Here are the REST endpoints, which can be found in HomeController.java.
1. **"/"**

At this endpoint (via GET), the login.html file is displayed as the view. A new instance of the Login class is added to the model as an attribute. This instance's email and password variables will hold the information that is submitted in the displayed form. 

2. **"/welcome"**

The login.html's form will POST to this endpoint, which will show a different view depending on the inputted information. If the email does not contain the "@" character, bad_email.html will be the view. If the password length is less than 10, bad_password.html will be the view. For both of these views, the user can click to go to the login form ("/" endpoint) to try again. If the entered information meets both criteria, welcome.html file will be the view. This endpoint makes use of the Login class's getEmail() and getPassword() methods.

3. **"/quiz"**

For the first access of this endpoint (GET), a new instance of the Count, Question, and Quiz classes are added to the model. The Count class's count variable is incremented (so that the first question shows as Question 1), and the Question class's question and answer variables are set.

The user's choice of answer (True/False) will POST to this endpoint. The user's answer is pulled via the the Quiz class's getAnswer() method and checked against the correct answer from the Question class. If the answer matches, the user's score is increased by 20 via the Quiz class's setScore() method. A new question and answer are then set once the count increments. After all 5 questions have been shown, done.html becomes the view.

## Unit Tests
There are 5 unit tests. Here are their purposes:
1. **contextLoads()**

This test checks that the Spring application context starts succesfully.

2. **loginTest()**

This test checks that the get and set methods for the Login class's private email and password variables work correctly.

3. **questionTest()**

This test checks that the Count class's static variable count can be incremented successfully so that the Question class's getQuestion() and getAnswer() methods can access the correct question and answer. The test also checks that the private variables question and answer can be set correctly.

4. **quizScoreTest()**

This test checks that the get and set methods for the Quiz class's private score variable work correctly.

5. **quizAnswerTest()**

This test checks that the get and set methods for the Quiz class's private answer variable work correctly.

## Instructions
The below instructions assume that your version of Java has been updated to 17 and that you are in the same directory as the pom.xml file. 
1. `mvn clean compile`
2. `mvn spring-boot:run`. Take the quiz by opening the link that the application is running on. 
3. To run the unit tests: `mvn test`.

## Source
The questions for the quiz were pulled from 3 of NASA's quizzes (https://www.nasa.gov/).

