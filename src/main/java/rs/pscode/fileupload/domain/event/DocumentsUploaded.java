package rs.pscode.fileupload.domain.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.multipart.MultipartFile;

public class DocumentsUploaded extends ApplicationEvent {
    private final MultipartFile[] documents;

    public DocumentsUploaded(Object source, MultipartFile[] documents) {
        super(source);
        this.documents = documents;
    }

    public MultipartFile[] getDocuments() {
        return documents;
    }
}
