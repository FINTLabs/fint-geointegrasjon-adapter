FROM gradle:4.10.3-jdk8-alpine AS builder
USER root
COPY . .
RUN gradle --no-daemon build

FROM gcr.io/distroless/java:8
ENV JAVA_TOOL_OPTIONS=-XX:+ExitOnOutOfMemoryError
WORKDIR /app
COPY --from=builder /home/gradle/build/deps/external/*.jar /app/
COPY --from=builder /home/gradle/build/deps/fint/*.jar /app/
COPY --from=builder /home/gradle/build/libs/fint-geointegrasjon-adapter-*.jar /app/fint-geointegrasjon-adapter.jar
CMD ["/app/fint-geointegrasjon-adapter.jar"]
