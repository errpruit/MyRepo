import java.util.*;
import java.io.*;

/**
 *
 * @author Erika
 */
public class SpChecker {
    
    /**
     *
     * @param args
     */
    public static void main(String [] args){
        //Create array of 26 BinarySearchTree objects
        BinarySearchTree [] arr = new BinarySearchTree[26];
        
        //Assign the root of each tree with a value a-z
        for(int i = 0; i < arr.length; i++){
            arr[i] = new BinarySearchTree<String>();
            String str = "";
            char x = (char) ('a'+i);
            str += x;
            arr[i].insert(str);            
        }
        
        File file = new File("random_dictionary.txt");
        //Add words from random_dictionary.txt to binary search trees
        try{
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                String word = input.next();
                word = word.toLowerCase();
                char ch = word.charAt(0);
                arr[ch - 97].insert(word);                
            }
        }catch(IOException e){
            System.out.println(e);
        }
        
        //create counters
        long wordsFound = 0;
        long wordsNotFound = 0;
        long compsFound = 0;
        long compsNotFound = 0;
        int counter = 0;
        int [] count = new int[1];
        
        File oliver = new File("oliver.txt");
        try{
            //read in words form oliver.txt
            Scanner finput = new Scanner(oliver);
            while(finput.hasNext()){
                String str = finput.next();
                
                //replace special characters
                str = str.replaceAll("[^a-zA-Z0-9]", "");
                str = str.toLowerCase();
                
                //compare words form oliver.txt to those in the dictionary
                if(!str.isEmpty()){
                    char c = str.charAt(0);
                    
                    if(c - 97 >= 0){
                        if(arr[c-97].search(str, count)){
                            wordsFound++;
                            compsFound += count[0];
                        } else {
                            wordsNotFound++;
                            compsNotFound += count[0];
                        }
                    } else{
                        wordsNotFound++;
                        compsNotFound++;
                    }
                }
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        //print results
        System.out.println("Words Found: "+wordsFound);
        System.out.println("Words Not Found: "+wordsNotFound);
        System.out.println("Average Comparisons for Words Found: "+compsFound/wordsFound);
        System.out.println("Average Comparisons for Words Not Found: "+compsNotFound/wordsNotFound);
        
    }
}
