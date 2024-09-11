package co.edu.escuelaing.java_web_app_docker_aws_deployment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "logs")
public class LogEntry {

    @Id
    private String id;
    private String message;
    private LocalDateTime timestamp;

    public LogEntry(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters y Setters
}
