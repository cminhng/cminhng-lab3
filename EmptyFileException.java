import java.io.*;

public class EmptyFileException extends IOException{
    public EmptyFileException(String message) {
        super(message + "was empty.");
    }
}
