.PHONY: all
all: 
	mvn package

.PHONY: run
run: 
	java -jar target/domletters-0.1.0.jar
