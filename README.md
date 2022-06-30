# Message-Service
A short project displaying Restful API services. 
This application manages messages and provides details about them. Specifically, users may find out whether a given message is a palindrome or not. The application supports the following operations:

Create, retrieve, update, and delete a message.
Retrieve a list of all messages.

Architecture
This application was build in Java with the use of the Spring Boot framework following a RESTful design pattern. It can be broken down into three distinct layers; the model, the controller and the service. 

The data-model of the application is organised under the model package.

The MessageRepository class is an extension of the CrudRepository interface. The CrudRepository implements basic CRUD operations, including count, delete, deleteById, save, saveAll, findById, and findAll. Information about this Repository is also mentioned in the comments. 
Service MessageServiceClass extends the interface IMessageService in order to implement the operations. 

The controller layer interacts with the service layer to get a job done whenever it receives a request from the api layer. It binds everything together right from the moment a request is intercepted till the response is prepared and sent back. The controller layer is present in the controller package.

The exception package consists of a user-defined exception "MessageNotFoundException" which extends RunTimeException and throws error-code 404. 


Following functionalities have been initially implemented:
REST API
CREATE MESSAGE
POST: /messages/create
Path Variable(s): NA
Request Body: The message text.
Return: The id of the message if it's successfully created.

RETRIEVE 1 MESSAGE BY ID
GET: /message/{messageId}
Path Variable(s): The id of the message the user would like to retrieve.
Request Body: NA
Return: The message if found, else, a MessageNotFoundException is thrown.

UPDATE MESSAGE
PUT: /message/update/{messageId}
Path Variable(s): The id of the message the user would like to update.
Request Body: The updated message text.
Return: The updated version of the message (with the new text, new last modified time and date, etc.)

DELETE MESSAGE
DELETE: /message/delete/{messageId}
Path Variable(s): The id of the message the user would like to delete.
Request Body: NA
Return Value(s): A message indicating whether the message was successfully deleted or not.

RETRIEVE ALL MESSAGES
GET: /message/all
Path Variable(s): NA
Request Body: NA
Return Value(s): A list of all the messages stored in the database.

CHECK MESSAGE IS A PALINDROME
GET /message/check-palindrome/{messageId}
Path Variable(s): The id of the message the user would like to check.
Request Body: NA
Return Value(s): A boolean value representing whether or not the message's text is a palindrome.
