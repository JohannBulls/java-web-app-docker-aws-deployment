package co.edu.escuelaing.java_web_app_docker_aws_deployment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloRestController is a REST controller that provides a greeting service.
 * The controller exposes a single GET endpoint which returns a personalized 
 * greeting message.
 * 
 * @version 1.0
 * @since 2024-09-11
 */
@RestController
public class HelloRestController {

    /**
     * Template for the greeting message.
     */
    private static final String template = "Hello, %s!";

    /**
     * Handles HTTP GET requests for the /greeting endpoint.
     * Returns a greeting message with the provided name.
     * 
     * @param name The name of the person to greet. If no name is provided, 
     *             "World" will be used as the default.
     * @return A greeting message containing the provided or default name.
     */
    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(template, name);
    }
}
