
# --- ETAPA 1: Construcción (Build) ---
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos primero el pom.xml y descargamos las dependencias
# (Esto optimiza el caché de Docker y hace que los futuros despliegues sean más rápidos)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente y compilamos el proyecto
COPY src ./src
# Usamos -DskipTests para que no corra los tests y el despliegue sea más rápido
# RUN mvn clean package -DskipTests

# --- ETAPA 2: Ejecución (Run) ---
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Exponemos el puerto
EXPOSE 8080

# Copiamos ÚNICAMENTE el .jar generado en la Etapa 1 a esta nueva imagen limpia
COPY --from=build /app/target/*.jar app.jar

# Ejecutamos la aplicación con los límites de memoria para el plan gratuito
ENTRYPOINT ["java", "-Xmx350m", "-Xms350m", "-jar", "app.jar"]