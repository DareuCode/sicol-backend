# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR generado por el build de Maven o Gradle
COPY build/libs/sicol-1.0.0.jar app.jar
COPY .env .env

# Exponer el puerto en el que la aplicación escucha (puedes configurarlo en tu archivo `application.properties` o `application.yml`)
EXPOSE 9000

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
