package co.edu.escuelaing.java_web_app_docker_aws_deployment.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/roundrobin")
public class RoundRobinController {

    private final String[] logServices = {
        "http://logservice1:8080/logservice/logs",
        "http://logservice2:8080/logservice/logs",
        "http://logservice3:8080/logservice/logs"
    };

    private int currentIndex = 0;

    @PostMapping("/logs")
    public String delegateRequest(@RequestBody String message) {
        RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = logServices[currentIndex];
        currentIndex = (currentIndex + 1) % logServices.length;
        return restTemplate.postForObject(serviceUrl, message, String.class);
    }
}
