package co.edu.escuelaing.java_web_app_docker_aws_deployment.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * LoadBalancerController is a REST controller that handles load balancing 
 * across multiple instances of a log service. It distributes requests in a 
 * round-robin manner to ensure that each instance is used evenly.
 * 
 * The controller exposes a POST endpoint that sends a message to one of 
 * the log service instances.
 * 
 * @version 1.0
 * @since 2024-09-11
 */
@RestController
public class LoadBalancerController {

    /**
     * A RestTemplate object to handle HTTP requests.
     */
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Array containing the URLs of the log service instances.
     */
    private final String[] instances = {
            "http://logservice1:34001/log",
            "http://logservice2:34002/log",
            "http://logservice3:34003/log"
    };

    /**
     * Tracks the current instance for round-robin load balancing.
     */
    private int currentInstance = 0;

    /**
     * Handles HTTP POST requests for the /submit endpoint.
     * Sends the provided message to one of the log service instances 
     * using round-robin load balancing.
     * 
     * @param message The message to be sent to the log service.
     * @return The response from the log service.
     */
    @PostMapping("/submit")
    public String sendToLogService(@RequestBody String message) {
        String targetUrl = instances[currentInstance];
        String response = restTemplate.postForObject(targetUrl, message, String.class);
        currentInstance = (currentInstance + 1) % instances.length;
        System.out.println(response);
        return response;
    }

}
