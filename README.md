# ubisoft

To run the application you need to follow below steps:

1. move to webapp directory

2. run below maven cmd to generate the application jar file:

	mvn clean install -DskipTests
	
3. run below command to create docker image for webapp:

	docker build  -t webapp:v1 .
	
4. move to webservice directory

5. run below maven cmd to generate the application jar file:

	mvn clean install -DskipTests
	
6. run below command to create docker image for webservice:

	docker build  -t webservice:v1 .
	
7. move to root directory and run below cmd to start all services 

	docker-compose up -d

8. To test webservice you can use postman or curl:

	curl http://localhost:8080/TestDevWebService/services/user/cecilia
	
9. To test webapp you can access it from below link:
	
	http://localhost:8081
