FROM gradle:8.4-jdk17 as builder
ARG VERSION=1.0.0-SNAPSHOT
ARG FILE_NAME=watcher-${VERSION}.jar
ENV VERSION=${VERSION}

# build
COPY . /opt/app/sources
WORKDIR /opt/app/sources

RUN echo "version=${VERSION}" >> gradle.properties
RUN bootJar

# extract
WORKDIR /opt/app/output
RUN java -Djarmode=layertools -jar /opt/app/sources/build/libs/${FILE_NAME} extract

FROM eclipse-temurin:17-jre-jammy

WORKDIR application

COPY --from=builder /opt/app/output/dependencies/ ./
COPY --from=builder /opt/app/output/spring-boot-loader/ ./
COPY --from=builder /opt/app/output/snapshot-dependencies/ ./
COPY --from=builder /opt/app/output/application/ ./

EXPOSE 8080

CMD ["java", "org.springframework.boot.loader.JarLauncher"]
