FROM gradle:8.5.0-jdk17

ARG BRANCH

ARG PORT

RUN echo "VALUE OF BRANCH: ${BRANCH}"

RUN echo "VALUE OF PORT: ${PORT}"

WORKDIR /app

COPY build.gradle settings.gradle gradle gradlew gradlew.bat /app/

COPY src /app/src

RUN gradle clean build --no-daemon

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "/app/build/libs/exec-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=core,${BRANCH}"]