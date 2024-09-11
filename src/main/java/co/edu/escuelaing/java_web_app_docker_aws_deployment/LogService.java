package co.edu.escuelaing.java_web_app_docker_aws_deployment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void saveLog(String message) {
        LogEntry logEntry = new LogEntry(message, LocalDateTime.now());
        logRepository.save(logEntry);
    }

    public List<LogEntry> getLastTenLogs() {
        return logRepository.findTop10ByOrderByTimestampDesc();
    }
}
