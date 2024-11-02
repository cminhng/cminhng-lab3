public class InvalidStopwordException extends Exception{
    public InvalidStopwordException(String message) {
        super(message);
    }

    public String toString() {
        return "InvalidStopwordException: " + getMessage();
    }
}
