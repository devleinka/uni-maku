# uni-maku
A backend solution to manage Cars and Customers for a Car Rental service.


# Table of Contents
* Technologies used 
* Features
* Project Overview

# Technologies used
* Java
* Spring Boot


###  Customers Service
Performs customer CRUD actions and stores rentals history of customers. 
Method	| Path	| Description	|
------------- | ------------------------- | ------------- | ---------
POST | /customers/{id} | Add new Customer |
PUT | /customers/{id} | Update Customer |
GET	| /customers	| Get All Customers |
GET	| /customers/{id}	| Get Customer by id |
DELETE | cars/{id} | Delete Customer by id |
 
### Cars Service
Used for renting cars and maintaining records of cars in stock and their respective current status. 

Method	| Path	| Description	|
------------- | ------------------------- | ------------- | ------------
GET | /cars | Get all Cars |
GET | /cars/{id} | Get Car by id |
POST	| /cars| Add new Car |
PUT	| /cars/{id}| Update Car by id |
DELETE | cars/{id} | Delete Car by id |
