package co.edu.escuelaing.java_web_app_docker_aws_deployment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private RestTemplate restTemplate;

    private final String[] instances = {
            "http://logservice1:6000/log",
            "http://logservice2:6000/log",
            "http://logservice3:6000/log"
    };
    private int currentInstance = 0;

    @PostMapping("/submit")
    public String sendToLogService(@RequestBody String message) {
        if (message == null || message.trim().isEmpty()) {
            return "Message cannot be null or empty";
        }

        String targetUrl = instances[currentInstance];
        String response = restTemplate.postForObject(targetUrl, message, String.class);
        currentInstance = (currentInstance + 1) % instances.length;
        return response;
    }
}

