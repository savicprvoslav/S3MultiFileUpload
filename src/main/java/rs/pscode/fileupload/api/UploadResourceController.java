package rs.pscode.fileupload.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rs.pscode.fileupload.domain.event.DocumentsUploaded;
import rs.pscode.fileupload.domain.service.EventPublisher;

@RestController
public class UploadResourceController {
    private final EventPublisher eventPublisher;

    @Autowired
    public UploadResourceController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data", produces = {"application/json"})
    public void upload(@RequestParam(name = "files") MultipartFile[] files) {
        if (isEmpty(files)) {
            throw new IllegalArgumentException("Files missing");
        }

        eventPublisher.publish(new DocumentsUploaded(this, files));
    }

    private boolean isEmpty(@RequestParam(name = "files") MultipartFile[] files) {
        return files == null || files.length == 0;
    }
}
