# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Install dependencies
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Manually download and install ttyd (latest version)
RUN curl -L https://github.com/tsl0922/ttyd/releases/download/1.6.3/ttyd.x86_64 -o /usr/local/bin/ttyd \
    && chmod +x /usr/local/bin/ttyd

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY RockPaperScissorsGame.jar app.jar

# Expose port for the web-based terminal
EXPOSE 10000

# Run ttyd to serve the Java app as a web-based terminal
CMD ["/usr/local/bin/ttyd", "-p", "10000", "java", "-jar", "app.jar"]
