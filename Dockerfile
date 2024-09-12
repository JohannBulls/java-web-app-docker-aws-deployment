# Usar la imagen base de OpenJDK para Java 17
FROM openjdk:17

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /usrapp/bin

# Exponer el puerto en el que correrá la aplicación (opcional)
ENV PORT 4567

# Copiar las clases compiladas y dependencias al contenedor
COPY target/classes /usrapp/bin/classes
COPY target/dependency /usrapp/bin/dependency
COPY /src/main/resources/static /usrapp/bin/classes/static

# Especificar el comando que ejecutará la aplicación Spring Boot
CMD ["java", "-cp", "./classes:./dependency/*", "co.edu.escuelaing.java_web_app_docker_aws_deployment.RestServiceApplication"]