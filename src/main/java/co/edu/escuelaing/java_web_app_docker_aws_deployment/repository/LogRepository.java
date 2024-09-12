package co.edu.escuelaing.java_web_app_docker_aws_deployment.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.escuelaing.java_web_app_docker_aws_deployment.model.LogEntry;

/**
 * LogRepository is a MongoDB repository for managing {@link LogEntry} objects.
 * It provides methods for performing CRUD operations on log entries and 
 * includes a custom query to retrieve the 10 most recent log entries.
 * 
 * @version 1.0
 * @since 2024-09-11
 */
public interface LogRepository extends MongoRepository<LogEntry, String> {

    /**
     * Finds the top 10 most recent log entries, ordered by their timestamp in 
     * descending order.
     * 
     * @return A list of the 10 most recent {@link LogEntry} objects.
     */
    List<LogEntry> findTop10ByOrderByTimestampDesc();
}
