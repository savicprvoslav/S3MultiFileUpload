package rs.pscode.fileupload.domain.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rs.pscode.fileupload.domain.exceptions.FileUploadFailedException;
import rs.pscode.fileupload.domain.service.FileUploaderService;

import java.io.File;

@Service
@ConditionalOnProperty(
        name = "uploadServiceType",
        havingValue = "local")
public class LocalFileUploaderServiceImpl implements FileUploaderService {

    @Value("${fileUploader.path}")
    private String uploadPath;

    @Override
    public void upload(MultipartFile document) {
        File file = new File(getFileName(document));

        try {
            document.transferTo(file);
        } catch (Exception e) {
            throw new FileUploadFailedException(e);
        }
    }

    private String getFileName(MultipartFile document) {
        return uploadPath + document.getOriginalFilename();
    }
}
