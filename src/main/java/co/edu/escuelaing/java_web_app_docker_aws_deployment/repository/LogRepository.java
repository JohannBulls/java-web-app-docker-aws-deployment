package co.edu.escuelaing.java_web_app_docker_aws_deployment.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.escuelaing.java_web_app_docker_aws_deployment.model.LogEntry;

public interface LogRepository extends MongoRepository<LogEntry, String> {
    List<LogEntry> findTop10ByOrderByTimestampDesc();
}