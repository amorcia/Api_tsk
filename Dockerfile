# Le dice a Docker que use una imagen base que ya tenga Java 21
FROM eclipse-temurin:21-jre-jammy

# Copia tu JAR (que debe estar en esta misma carpeta)
COPY apiDatos-1.0.jar app.jar

# Expone el puerto que usa tu API
EXPOSE 8081

# El comando para arrancar tu API cuando el contenedor inicie
ENTRYPOINT ["java", "-jar", "/app.jar"]