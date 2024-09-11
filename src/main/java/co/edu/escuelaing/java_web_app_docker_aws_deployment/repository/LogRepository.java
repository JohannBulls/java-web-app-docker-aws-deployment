package co.edu.escuelaing.java_web_app_docker_aws_deployment.repository;

import co.edu.escuelaing.java_web_app_docker_aws_deployment.model.LogEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogRepository extends MongoRepository<LogEntry, String> {
    List<LogEntry> findTop10ByOrderByTimestampDesc();
}
