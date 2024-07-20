# Integrated Flask and Spring Boot Project
This project combines a Python Flask app with a Java Spring Boot app. The Flask app predicts seed types, and the Spring Boot app handles user authentication.

## Flask Application
The Flask app predicts seed types using a pre-trained model.

1.	Install Flask: 
pip install flask
2.	Run the app:
python iad_app.py
3.	Open the browser and go to http://127.0.0.1:5000/.


•	Home Page (/): - a form where you can enter seed features (numbers describing the seeds).


•	Predict Page (/predict): - the app shows a message telling  the type of seed and a description.

  
Routes

•	/: Home page -  accepts POST requests with seed features and returns the predicted seed type.

# Spring Boot Application
The Spring Boot app manages user authentication with features like registration and login.

1.	Install Java and Maven.
2.	Navigate to spring-boot-auth-service directory and run:  mvn clean install
3.	Run the app: mvn spring-boot:run
4.	Access the app at http://localhost:8080/.

## Endpoints
•	/users/register: Register a new user.

•	/users/{username}: Get user by username.

•	/users/update: Update user password.

•	/users/delete/{userId}: Delete user by ID.

