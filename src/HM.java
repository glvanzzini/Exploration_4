import java.io.*;
import java.util.HashMap;

/**
 * Created by jacobmurillo on 10/31/16.
 */

public class HM {

    private static HashMap<Character, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException{

        BufferedReader input = new BufferedReader(new FileReader("sm.txt"));
        char[] pattern = input.readLine().toCharArray();


    }

    // comments are stupid
    private static void CreateHorspoolTable(){
        for(char letter : "abcdefghijklmnopqrtuvwxyz".toCharArray()) {
           hashMap.put(letter, 0);
        }
    }

    private int HorspoolMatching(){

        return 0;
    }

    private char[] ShiftTable(char[] P){
        int m = P.length;
        int size = 0;




        for (int i = 0; i < m; i++){

            for(int j = 0; j < m -2; j++) {



            }
        }

        return new char[];
    }


}
