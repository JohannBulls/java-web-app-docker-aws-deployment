package co.edu.escuelaing.java_web_app_docker_aws_deployment.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class LogEntryTest {

    @Test
    public void testLogEntryCreation() {
        LocalDateTime now = LocalDateTime.now();
        LogEntry logEntry = new LogEntry("Test message", now);

        assertEquals("Test message", logEntry.getMessage());
        assertEquals(now, logEntry.getTimestamp());
    }

    @Test
    public void testToString() {
        LocalDateTime now = LocalDateTime.now();
        LogEntry logEntry = new LogEntry("Test message", now);
        String expected = "LogEntry{id='null', message='Test message', timestamp=" + now + "}";
        assertEquals(expected, logEntry.toString());
    }
}
