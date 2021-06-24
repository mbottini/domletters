.PHONY: all
all: 
	mvn package ${QUIET_FLAG}

.PHONY: run
run: 
	java -jar target/domletters-0.1.0.jar

.PHONY: clean
clean:
	mvn clean
