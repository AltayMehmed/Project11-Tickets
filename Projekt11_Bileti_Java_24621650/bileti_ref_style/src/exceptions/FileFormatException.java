package exceptions;

public class FileFormatException extends Exception {
    public FileFormatException(String message, Throwable cause) {
        super(message, cause);
    }
    public FileFormatException(String message) {
        super(message);
    }
}
