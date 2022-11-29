FROM gradle:7.5.1

WORKDIR /app

COPY . .

ENTRYPOINT ./gradlew clean bootRun
