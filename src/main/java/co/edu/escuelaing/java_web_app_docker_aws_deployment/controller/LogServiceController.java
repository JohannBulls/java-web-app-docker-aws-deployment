package co.edu.escuelaing.java_web_app_docker_aws_deployment.controller;

import co.edu.escuelaing.java_web_app_docker_aws_deployment.model.LogEntry;
import co.edu.escuelaing.java_web_app_docker_aws_deployment.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logservice")
public class LogServiceController {

    @Autowired
    private LogRepository logRepository;

    @PostMapping("/log")
    public List<LogEntry> logMessage(@RequestBody String message) {
        LogEntry logEntry = new LogEntry(message, LocalDateTime.now());
        logRepository.save(logEntry); 

        return logRepository.findTop10ByOrderByTimestampDesc();
    }
}
