import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class WordCounter {
    boolean containsStopword;

    public WordCounter(){
        containsStopword = false;
    }
    static public int processText(StringBuffer text, String stopword){
        return 0;
    }

    static public StringBuffer processFile(String path){
        //if file cant open
        //prompt re-enter filename
        //file is empty
            //return emptyfileexception
        
        //Scanner sc1 = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("data.txt"))));
        
        // Pattern regex = Pattern.compile("your regular expression here");
        // Matcher regexMatcher = regex.matcher(text);
        // while (regexMatcher.find()) {
        //     System.out.println("I just found the word: " + regexMatcher.group());
        // } 
        //\b\w+\b
        //\\b\\w+\\b
        StringBuffer sb = new StringBuffer();

        return sb;
    }
    public static void main(String[] args) {
        //ask for method 1 or 2
            //1: ask for text file


    }


}

