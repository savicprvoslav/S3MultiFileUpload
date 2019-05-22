package rs.pscode.fileupload.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileUploadFailedException extends RuntimeException {
    public FileUploadFailedException(Throwable th) {
        super("FileUploadFailedException", th);
    }
}
