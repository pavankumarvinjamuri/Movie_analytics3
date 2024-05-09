# Use a base image with a compatible Java runtime environment
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY /Users/pavansravya/IdeaProjects/Simple_kafka_zoo_single_doc/out/artifacts/Simple_kafka_zoo_single_doc_jar/Simple_kafka_zoo_single_doc.jar /app/

# Command to run your producer code
CMD ["java", "-jar", "Simple_kafka_zoo_single_doc.jar"]