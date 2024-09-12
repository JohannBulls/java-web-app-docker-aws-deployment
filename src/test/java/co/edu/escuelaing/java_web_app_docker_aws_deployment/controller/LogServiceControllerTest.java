package co.edu.escuelaing.java_web_app_docker_aws_deployment.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import co.edu.escuelaing.java_web_app_docker_aws_deployment.model.LogEntry;
import co.edu.escuelaing.java_web_app_docker_aws_deployment.repository.LogRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class LogServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogRepository logRepository;

    @Test
    public void testLogMessage() throws Exception {
        LogEntry logEntry = new LogEntry("Test message", LocalDateTime.now());
        List<LogEntry> logEntries = Arrays.asList(logEntry);

        when(logRepository.findTop10ByOrderByTimestampDesc()).thenReturn(logEntries);

        this.mockMvc.perform(post("/log").content("Test message"))
            .andExpect(status().isOk());
        
        verify(logRepository, times(1)).save(any(LogEntry.class));
        verify(logRepository, times(1)).findTop10ByOrderByTimestampDesc();
    }
}
