import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException; 

public class WordCounter {
    static boolean containsStopword;

    // public WordCounter(){
    //     containsStopword = false;
    // }

    static public int processText(StringBuffer text, String stopword){
        Pattern regex = Pattern.compile("\\b\\w+\\b");
        Matcher regexMatcher = regex.matcher(text);
        int wc = 0;

        while (regexMatcher.find()) {
            //System.out.println("I just found the word: " + regexMatcher.group());
            wc++;
            if(regexMatcher.group().equals(stopword)){
                containsStopword = true;
                break;
            }
        } 

        if(wc < 5){
            throw new TooSmallText(""+wc);
        }

        if(stopword != null && containsStopword == false){
            throw new InvalidStopwordException(stopword);
        }

        return wc;
    }

    static public StringBuffer processFile(String path) throws EmptyFileException{
        StringBuffer sb = new StringBuffer();
        return sb;
    }
    public static void main(String[] args) {
        //ask for method 1 or 2
            //1: ask for text file
        if(args.length < 1){
            System.out.println("Choose how you'd like your text to be processed: 1 (file) or 2 (text).");
            return;
        }
        String option = args[0];
        String path = "";

        try {
            //process file

            processFile(path);

            } catch(EmptyFileException e) {
                EmptyFileException help = new EmptyFileException(path + " was empty");
                System.out.println(help);
            }
              


    }


}

