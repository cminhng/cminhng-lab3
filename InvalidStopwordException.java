public class InvalidStopwordException extends Exception{
    public InvalidStopwordException(String message) {
        super("Couldn't find stopword: " + message);
    }
}
