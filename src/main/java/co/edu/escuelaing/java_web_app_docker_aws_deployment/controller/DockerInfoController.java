package co.edu.escuelaing.java_web_app_docker_aws_deployment.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/docker-info")
public class DockerInfoController {

    @PostMapping
    public Map<String, String> getDockerInfo(@RequestBody Map<String, String> request) {
        String topic = request.get("topic");
        
        // Simula la respuesta basada en el "topic" ingresado
        Map<String, String> response = new HashMap<>();
        response.put("response", "Information about Docker topic: " + topic);
        
        return response;
    }
}
