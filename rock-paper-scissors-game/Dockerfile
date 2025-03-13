# Use Gradle image to build the project
FROM gradle:7.6.0-jdk17 AS build

WORKDIR /app

# Copy project files
COPY . .

# Ensure Gradle Wrapper has execute permissions
RUN chmod +x ./gradlew

# Build the project using Gradle
RUN ./gradlew clean build

# Use a lightweight OpenJDK image for the final container
FROM openjdk:17-jdk-slim

WORKDIR /app

# Install dependencies
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Manually download and install ttyd (latest version)
RUN curl -L https://github.com/tsl0922/ttyd/releases/download/1.6.3/ttyd.x86_64 -o /usr/local/bin/ttyd \
    && chmod +x /usr/local/bin/ttyd

# Copy the built JAR from the previous stage
COPY --from=build /app/build/libs/*.jar app.jar

# ✅ Copy the output directory and text file to the container
RUN mkdir -p /app/src/output
COPY src/output/rockPaperScissorsResult.txt /app/src/output/rockPaperScissorsResult.txt

# Expose port for the web-based terminal
EXPOSE 10000

# Run ttyd to serve the Java app as a web-based terminal
CMD ["/usr/local/bin/ttyd", "-p", "10000", "java", "-jar", "app.jar"]
