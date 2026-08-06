FROM gcr.io/distroless/java:8
ENV JAVA_TOOL_OPTIONS=-XX:+ExitOnOutOfMemoryError
WORKDIR /app
COPY build/deps/external/*.jar /app/
COPY build/deps/fint/*.jar /app/
COPY build/libs/fint-geointegrasjon-adapter-*.jar /app/fint-geointegrasjon-adapter.jar
CMD ["/app/fint-geointegrasjon-adapter.jar"]
