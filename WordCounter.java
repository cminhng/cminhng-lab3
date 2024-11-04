import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.*;
import java.io.*;


public class WordCounter {
    static boolean containsStopword = false;

    static public int processText(StringBuffer text, String stopword) throws TooSmallText, InvalidStopwordException{
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

    static public StringBuffer processFile(String path) throws IOException, EmptyFileException{
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        boolean readSuccessful = false;
        String line;

        while(!readSuccessful){
            try{
                reader = new BufferedReader(new FileReader(path));
                line = "";
                while((line = reader.readLine()) != null){
                    sb.append(line).append(" ");
                }
                
                readSuccessful = true;
            } catch (IOException e){
                System.out.println("File not found: " + e.getMessage() + ". Please enter a valid filename:");
                path = new java.util.Scanner(System.in).nextLine();
            }
        }
        reader.close();

        if(sb.toString().trim().isEmpty()){
            throw new EmptyFileException(path);
        }

        return sb;
    }
    public static void main(String[] args) {
        StringBuffer text = null;
        String stopword = null;

        stopword = args.length > 1 ? args[1] : null;

        text = new StringBuffer(args[0]);

        try{
            int wc = processText(text, stopword);
            //System.out.println("Word count: " + wc);
        }catch(InvalidStopwordException e){
            System.out.println(e.getMessage());
        }catch(TooSmallText e){
            System.out.println(e.getMessage());

        }
        // try{
        //     if(args.length < 2){
        //         System.out.println("For option 1, input in the following format: '1 [filename] [optional stopward]'\nFor option 2: '2 [text]'");
        //         return;
        //     }
            
        //     String option = args[0];
        //     if(option.equals("1")){
        //         String path = args[1];
        //         stopword = args.length > 2 ? args[2] : null;
        //         text = processFile(path);
        //     }else if(option.equals("2")){
        //         text = new StringBuffer(args[1]);
        //     }else{
        //         System.out.println("Please specify a valid option, 1 or 2.");
        //         return;
        //     }
        //     try{
        //         int wc = processText(text, stopword);
        //         System.out.println("Word count: " + wc);
        //     }catch(InvalidStopwordException e){
        //         System.out.println(e.getMessage());
        //     }catch(TooSmallText e){
        //         System.out.println(e.getMessage());

        //     }
            
              
        // }catch(EmptyFileException e){
        //     System.out.println(e.getMessage());
        // }catch(IOException e){
        //     System.out.println(e.getMessage());
        // }

    }


}

