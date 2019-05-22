package rs.pscode.fileupload.domain.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import rs.pscode.fileupload.domain.event.DocumentsUploaded;
import rs.pscode.fileupload.domain.event.UploadDocument;
import rs.pscode.fileupload.domain.service.EventPublisher;

import java.util.Arrays;

@Component
public class DocumentsUploadedListener implements ApplicationListener<DocumentsUploaded> {

    private final EventPublisher eventPublisher;

    @Autowired
    public DocumentsUploadedListener(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void onApplicationEvent(DocumentsUploaded event) {
        Arrays.stream(event.getDocuments()).forEach(document -> eventPublisher.publish(new UploadDocument(this, document)));
    }
}
