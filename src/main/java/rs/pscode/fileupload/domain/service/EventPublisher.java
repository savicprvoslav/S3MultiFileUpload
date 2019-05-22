package rs.pscode.fileupload.domain.service;

import org.springframework.context.ApplicationEvent;

public interface EventPublisher {
    void publish(ApplicationEvent event);
}
