# Usar una imagen base con JDK 11 y Maven
FROM maven:3.8.4-eclipse-temurin-17 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al directorio de trabajo
COPY . /app

# Ejecutar Maven para construir el proyecto
RUN mvn clean package -DskipTests

# Crear una nueva imagen basada en OpenJDK 11
FROM eclipse-temurin:17-jre

# Exponer el puerto que utilizará la aplicación
EXPOSE 1020

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build /app/target/institucion-0.0.1-SNAPSHOT.jar /app/historiaca.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/historiaca.jar"]