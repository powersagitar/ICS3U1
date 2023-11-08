FROM openjdk:21-jdk as development
WORKDIR /app
COPY . .
RUN javac Main.java
CMD ["java", "Main"]
