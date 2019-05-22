package rs.pscode.fileupload.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;
import rs.pscode.fileupload.domain.service.EventPublisher;

@Service
public class EventPublisherImpl implements EventPublisher {

    private final ApplicationContext context;

    @Autowired
    public EventPublisherImpl(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void publish(ApplicationEvent event) {
        context.publishEvent(event);
    }
}
