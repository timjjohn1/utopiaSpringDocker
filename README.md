# Dockerized Spring API
Spring Boot API - 
Works with publicly available Stripe API for payments.  Receives tokens from front end react. Sends back a success or failure to the front end.
Used different REST API end points to retrieve data from the database to get information for the front end.

Unit Testing - 
Uses an H2 database to build based off of the ORM built in to spring. 

Dockerized - 
In order to be deployed onto an AWS stack I copied the jar into a docker container to be run remotely from an ECR to and EC2.

