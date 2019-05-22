package rs.pscode.fileupload.domain.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import rs.pscode.fileupload.domain.event.UploadDocument;
import rs.pscode.fileupload.domain.service.FileUploaderService;


@Component
public class UploadDocumentListener implements ApplicationListener<UploadDocument> {

    private final FileUploaderService fileUploaderService;

    @Autowired
    public UploadDocumentListener(FileUploaderService fileUploaderService) {
        this.fileUploaderService = fileUploaderService;
    }

    @Override
    public void onApplicationEvent(UploadDocument event) {
        fileUploaderService.upload(event.getDocument());
    }
}
