package co.edu.escuelaing.java_web_app_docker_aws_deployment;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
public class RestServiceApplication {
 
	public static void main(String[] args) {
                SpringApplication app = new SpringApplication(RestServiceApplication.class); 
                app.setDefaultProperties(Collections.singletonMap("server.port", "5000"));
                app.run(args);
	}
 
}