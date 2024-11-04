public class TooSmallText extends Exception{
    public TooSmallText(String message) {
        super("TooSmallText: Only found " + message + " words.");
    }
}
