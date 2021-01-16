# ubisoft

To run the application you need to follow below step:

1. move to webapp directotry

2. run below maven cmd to generate the application jar file:
	mvn clean install -DskipTests
	
3. run below command to create docker image for webapp:
	docker build  -t webapp:v1 .
	
4. move to webservice directotry

5. run below maven cmd to generate the application jar file:
	mvn clean install -DskipTests
	
6. run below command to create docker image for webapp:
	docker build  -t webservice:v1 .
	
7. move to root directotry and run below cmd to start all services 
	docker-compose up -d