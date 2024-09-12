package co.edu.escuelaing.java_web_app_docker_aws_deployment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.edu.escuelaing.java_web_app_docker_aws_deployment.model.LogEntry;
import co.edu.escuelaing.java_web_app_docker_aws_deployment.repository.LogRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * LogServiceController is a REST controller that handles the storage and retrieval 
 * of log entries. The controller exposes a POST endpoint to log messages and 
 * returns the 10 most recent log entries.
 * 
 * @version 1.0
 * @since 2024-09-11
 */
@RestController
public class LogServiceController {

    /**
     * The repository for storing and retrieving log entries.
     */
    @Autowired
    private LogRepository logRepository;

    /**
     * Handles HTTP POST requests for the /log endpoint.
     * Stores the provided message as a log entry with a timestamp 
     * and returns the 10 most recent log entries.
     * 
     * @param message The message to be logged.
     * @return A list of the 10 most recent log entries, ordered by timestamp in descending order.
     */
    @PostMapping("/log")
    public List<LogEntry> logMessage(@RequestBody String message) {
        LogEntry logEntry = new LogEntry();
        logEntry.setMessage(message);
        logEntry.setTimestamp(LocalDateTime.now());
        logRepository.save(logEntry);

        return logRepository.findTop10ByOrderByTimestampDesc();
    }
}
