package co.edu.escuelaing.java_web_app_docker_aws_deployment;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RestServiceApplication is the entry point for the Spring Boot application.
 * It configures and starts the application, setting the server port based on 
 * an environment variable or a default value of 4567.
 * 
 * @version 1.0
 * @since 2024-09-11
 */
@SpringBootApplication
public class RestServiceApplication {

    /**
     * Main method that configures and runs the Spring Boot application.
     * 
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RestServiceApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
        app.run(args);
    }

    /**
     * Retrieves the port for the server. It first checks if the "PORT" environment
     * variable is set. If not, it defaults to port 4567.
     * 
     * @return The port number on which the server will run.
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
