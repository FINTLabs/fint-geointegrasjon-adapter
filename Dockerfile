FROM gradle:4.10.3-jdk8-alpine as builder
USER root
COPY . .
RUN gradle --no-daemon build

FROM gcr.io/distroless/java:8
ENV JAVA_TOOL_OPTIONS -XX:+ExitOnOutOfMemoryError
COPY --from=builder /home/gradle/build/deps/external/*.jar /data/
COPY --from=builder /home/gradle/build/deps/fint/*.jar /data/
COPY --from=builder /home/gradle/build/libs/fint-geointegrasjon-adapter-*.jar /data/fint-geointegrasjon-adapter.jar
CMD ["/data/fint-geointegrasjon-adapter.jar"]
