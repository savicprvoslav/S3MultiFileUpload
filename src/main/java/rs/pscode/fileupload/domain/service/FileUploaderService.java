package rs.pscode.fileupload.domain.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploaderService {

    void upload(MultipartFile document);
}
