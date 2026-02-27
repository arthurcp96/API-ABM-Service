
# 1. Usamos java 17
FROM eclipse-temurin:17-jre-alpine

# 2. Creamos un directorio de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiamos el archivo .jar generado en el paso 1 al contenedor
# NOTA: Ajusta la ruta si usas Gradle (ej: build/libs/*.jar)
COPY target/*.jar app.jar

# 4. Exponemos el puerto 8080 (donde corre Spring Boot por defecto)
EXPOSE 8080

# 5. Comando para iniciar la aplicación
# IMPORTANTE: Los flags -Xmx y -Xms limitan la RAM para que no te expulsen del plan gratuito.
# Aquí limitamos a ~350MB, dejando espacio para el sistema operativo del contenedor (total < 512MB).
ENTRYPOINT ["java", "-Xmx350m", "-Xms350m", "-jar", "app.jar"]