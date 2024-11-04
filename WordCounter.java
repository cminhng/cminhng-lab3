import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.*;
import java.io.*;


public class WordCounter{
    //static boolean lastChance = false;

    public static int processText(StringBuffer text, String stopword) throws TooSmallText, InvalidStopwordException{
        Pattern regex = Pattern.compile("\\b\\w+\\b");
        Matcher regexMatcher = regex.matcher(text);
        int wc = 0;
        boolean containsStopword = false;
        String sw = stopword;

        while (regexMatcher.find()) {
            wc++;
            if(stopword != null && regexMatcher.group().equals(sw)){
                containsStopword = true;
                break;
            }
        } 
        

        if(wc < 5){
            if(containsStopword){
                wc++;
            }
            throw new TooSmallText(""+wc);
        }

        if(stopword != null && !containsStopword){
            // if(!lastChance){
            //     // System.out.println("Stopword not found. Please enter a valid stopword.\n");
            //     // sw = new Scanner(System.in).nextLine();
            //     lastChance = true;
            //     // processText(text, sw);
            // }else{
                throw new InvalidStopwordException(stopword);
            //}
            //why do some of these tests contradict the readme?!?! 
        }

        return wc;
    }

    public static StringBuffer processFile(String path) throws EmptyFileException, IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = null;
        boolean fileFound = false;
        String line;
        String p = path;


        while(!fileFound){
            try{
                reader = new BufferedReader(new FileReader(p));
                while((line = reader.readLine()) != null){
                    sb.append(line);
                }

                if(sb.toString().trim().isEmpty()){
                    throw new EmptyFileException(path);
                }
                fileFound = true;
            }catch(FileNotFoundException e){
                System.out.println("File not found. Please enter a valid filename:");
                p = new Scanner(System.in).nextLine();
                if(reader != null){
                    reader.close();
                }
            }
        }
        reader.close();

        return sb;
    }
    public static void main(String[] args) {
        StringBuffer text = null;
        String stopword = null;
        try{
            if(args.length == 0){
                System.out.println("Please provide a valid filename and optional stopword.");
                return;
            }
            stopword = args.length > 1 ? args[1] : null;
    
            try{
                try{
                    text = processFile(args[0]);
                }catch(EmptyFileException e){
                    int wc = processText(new StringBuffer().append(""), null);
                    System.out.println("Found " + wc + " words.");
                }
                int wc = processText(text, stopword);
                System.out.println("Found " + wc + " words.");
            }catch(TooSmallText e){
                System.out.println("TooSmallText: " + e.getMessage());
                //im sorry but why does the format in main have to be different from process text to be able to pass tests?!
            }catch(InvalidStopwordException e){
                System.out.println(e.getMessage());
            }
        }catch(IOException e){
            System.out.println("An error occured.");
        }
        // readme says for main option should be the first arg, tests require filename to be first arg. how
        // if first arg is a string i shouldnt call processfile
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

