package Exceptions;

public class ApplicationStorageException extends RuntimeException {
    public ApplicationStorageException(String message) {
        super(message);
    }

    public ApplicationStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
