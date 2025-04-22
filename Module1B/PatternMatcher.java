import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PatternMatcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileNameString = "";

        System.out.print("Enter a file name to search in : ");
        fileNameString = scanner.next();
        try {
            ArrayList<String> wordList = getWordList(fileNameString);
            // dummy scanner
            scanner.nextLine();

            System.out.println("File read successfully, initiating pattern matcher...");

            String pattern = "";


            System.out.print("Enter a pattern to match (or press Enter to exit): ");
            pattern = scanner.nextLine();
            while (pattern.length() > 0) {

                System.out.println(getMatches(wordList, pattern));
                System.out.print("Enter a pattern to match (or press Enter to exit): ");
                pattern = scanner.nextLine();
        }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found, exiting...");
            return;
        }
        System.out.println("Exiting...");
    }

    public static ArrayList<String> getWordList(String fileName) throws FileNotFoundException{
        ArrayList<String> Words = new ArrayList<String>();
        FileInputStream file = new FileInputStream(fileName);
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNext()) {
            String newWord = fileScanner.next();
            Words.add(newWord);
        }
        fileScanner.close();
        return Words;
    }

    public static boolean isMatchAtIndex(String word, String pattern, int index) {
        
        if(word.length() - 1 < index || pattern.length() -1 < index || index < 0) {
            return false;
        }

        if(pattern.charAt(index) == '_' || pattern.charAt(index) == word.charAt(index)) {
            return true;
        }

        return false;
    }

    public static boolean isMatch(String word, String pattern) {
        
        if(word.length() != pattern.length()) {
            return false;
        }

        for(int i=0; i<word.length(); i++) {
            if(!isMatchAtIndex(word, pattern, i)) {
                return false;
            }
        }
        
        return true;
    }

    public static ArrayList<String> getMatches(ArrayList<String> wordList, String pattern) {
        ArrayList<String>matches = new ArrayList<String>();

        for(String word : wordList) {
            if(isMatch(word, pattern)) {
                matches.add(word);
            }
        }

        return matches;
    }

}
