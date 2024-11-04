public class TooSmallText extends Exception{
    public TooSmallText(String message) {
        super("Only found " + message + " words.");
    }
}
