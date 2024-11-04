public class InvalidStopwordException extends Exception{
    public InvalidStopwordException(String message) {
        super("InvalidStopwordException: Couldn't find stopword: " + message);
    }
}
