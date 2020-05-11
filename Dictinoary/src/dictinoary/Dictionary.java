/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictinoary;

/**
 *
 * @author Chamodi
 */

    
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary{

    private static Object get(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
    
    static class Word {
        public String english = "";
        public String french = "";
        public String spanish = "";
        public Word(String eng,String fre,String spn){
            this.english = eng;
            this.french = fre;
            this.spanish = spn;
        }    
    }
    
    public static int hashfunc(String eng){
        int key;
        int temp = 0;
        for(char letter :eng.toCharArray())
        {
            temp = temp + (int)letter;
        }
        key = temp/100;
        return key;
    }
    
    public static int finder(int index,ArrayList<Word> dic) {
        try {
            while(true)
            {
                if(dic.get(index)!=null)
                {
                    index++;
                } 
                else{
                    return index;
                }
            }
        } catch ( IndexOutOfBoundsException e ) {
            while (dic.size() <= index)
            {
                dic.add(null);
            }
            return index;
        }
        
    }
    
    
    

    public static String simplify(String sentence) {
        String deleteWords[] = {"the ","The ","a ","A ","be ","Be ","am ","Am ","is ","Is ","are ","Are ","was ","Was ","were ","Were ","has ","Has ","have ","Have ","do ","Do ","does ","Does ","did ", "Did ","it ", " .",", "," !"," ?"};
        String simple = sentence;
        for (String deleteWord:deleteWords) {
            simple = simple.replace(deleteWord, "");
        }
        return simple;
    }

    
    

    public static int getIndex(int key,ArrayList<Word> dict,String word) {
        try{
            while(true)
            {
              if(dict.get(key).english.equals(word) || dict.get(key).english.equals(word.toLowerCase()))
              { 
                return key;
              }
              else{
                key++;
            }
         }
        }catch(IndexOutOfBoundsException e){
          return -1;
        }
    }

    

    public static String capitalize(String str){
        
        if(str == null || str.length() == 0)
            return "";
        
        if(str.length() == 1)
            return str.toUpperCase();
        
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    
    }

    
    public static ArrayList<Word> dictionaryLoader(ArrayList<Word> dic,String csvFile,String splitBy){

        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); //ignore first line
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] temp = line.split(splitBy);
                int key = hashfunc(temp[0]);
                
                int index = finder(key, dic);
                Word word = new Word(temp[0], temp[1], temp[2]);
               // System.out.println("key :"+key+"index :"+index);
                dic.set(index, word);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dic;
    }
    
    
     

    public static void translator(ArrayList<Word> dictionay,String csvFile) {
        String line = "";
        String splitBy = " ";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String simpleLine = simplify(line);
                System.out.println(simpleLine);
                String[] words = simpleLine.split(splitBy);
                for(String word: words)
                {
                    int key = hashfunc(capitalize(word));
                    int index = getIndex(key, dictionay, capitalize(word));
                    if(index!=-1)
                    {
                        System.out.print(dictionay.get(index).french+" ");
                    }
                    else{
                        System.out.print("["+word+"] ");
                    }

                }
                System.out.println("");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    
    public static void main(String[] args) {
        ArrayList<Word> dictionary = new ArrayList<Word>();
        ArrayList<Word> sentence = new ArrayList<Word>();
        
        
        String diccsvFile = "Word_dictionary_For_Q2.csv";
        String sentencecsvfile = "Sentence.csv";
        String splitBy = ",";
        dictionaryLoader(dictionary,diccsvFile,splitBy);
        translator(dictionary, sentencecsvfile);




//        System.out.println(dictionary.get(100).english);
//        System.out.println(dictionary.get(100).french);
        

        

//             System.out.println(dictionary.get(getValue("Train",dictionary)).french);   



        
    }
}

    /**
     * @param args the command line arguments
     */
    
