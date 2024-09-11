package co.edu.escuelaing.java_web_app_docker_aws_deployment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/logservice")
public class LogServiceController {

    @Autowired
    private LogService logService;

    @PostMapping("/logs")
    public List<LogEntry> addLog(@RequestBody String message) {
        logService.saveLog(message);
        return logService.getLastTenLogs();
    }
}
