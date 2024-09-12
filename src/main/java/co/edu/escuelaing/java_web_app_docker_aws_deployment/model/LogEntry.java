package co.edu.escuelaing.java_web_app_docker_aws_deployment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

/**
 * LogEntry represents a log entry stored in the MongoDB collection "logs".
 * Each entry contains an ID, a message, and a timestamp indicating when the 
 * entry was created.
 * 
 * @version 1.0
 * @since 2024-09-11
 */
@Document(collection = "logs")
public class LogEntry {

    /**
     * The unique identifier for the log entry.
     */
    @Id
    private String id;

    /**
     * The message stored in the log entry.
     */
    private String message;

    /**
     * The timestamp when the log entry was created.
     */
    private LocalDateTime timestamp;

    /**
     * Default constructor.
     */
    public LogEntry() {
    }

    /**
     * Constructs a new LogEntry with the specified message and timestamp.
     * 
     * @param message The message for this log entry.
     * @param timestamp The timestamp when the log entry was created.
     */
    public LogEntry(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    /**
     * Returns the ID of this log entry.
     * 
     * @return The ID of the log entry.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID for this log entry.
     * 
     * @param id The new ID for the log entry.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the message of this log entry.
     * 
     * @return The message of the log entry.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message for this log entry.
     * 
     * @param message The new message for the log entry.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns the timestamp of this log entry.
     * 
     * @return The timestamp of the log entry.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp for this log entry.
     * 
     * @param timestamp The new timestamp for the log entry.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Returns a string representation of the log entry.
     * 
     * @return A string containing the log entry's ID, message, and timestamp.
     */
    @Override
    public String toString() {
        return "LogEntry{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
