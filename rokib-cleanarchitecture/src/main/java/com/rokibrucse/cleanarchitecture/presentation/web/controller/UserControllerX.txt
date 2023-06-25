// Each class in the web package should define methods for handling specific HTTP requests and returning a response to the client. 
// For example, a UserController class might have methods for handling requests to create a new user, update an existing user, 
// or retrieve a list of users. The controller class should delegate to the appropriate handler or service in the application layer 
// to carry out the requested action and return the result to the client.It's important to note that the classes in the web 
// package should not contain any business logic. Their role is to handle the details of receiving and responding to HTTP requests, 
// and to delegate to the appropriate component in the application layer to perform the requested action. 
// This separation of concerns allows the business logic to remain independent of the infrastructure.