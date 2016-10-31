import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jacobmurillo on 10/31/16.
 */

public class HM {

    private static HashMap<Character, Integer> shiftTable = new HashMap<>();

    public static void main(String[] args) throws IOException{

        Scanner input = new Scanner(new File("sm.dat"));
        char[] pattern = input.nextLine().toCharArray();
        input.useDelimiter("\\Z");
        char[] text = input.next().toCharArray();

        long Start = System.nanoTime();
        System.out.println("Index: " + HorspoolMatching(pattern, text) +
                "\nTotal Time: " + (System.nanoTime() - Start));
    }

    //Implements Horspool's algorithm for string matching
    //Input: Pattern P[0..m-1] and text T[0..n-1]
    //Output: The index of the left end of the first matching substring
    //        or -1 if there are no matches
    private static int HorspoolMatching(char[] P, char T[]){

        ShiftTable(P, T);

        int m = P.length;
        int n = T.length;
        int i = m - 1;

        while (i <= n - 1){
            int k = 0;

            while(k <= m-1 && P[m-1-k] == T[i-k]){
                k = k + 1;
            }

            if(k==m){
                return i - m + 1;
            }
            else{
                i = i + shiftTable.get(T[i]);
            }
        }
        return -1;
    }

    //Fills the shift table used by the Horspool's algorithm
    private static void ShiftTable(char[] P, char[] T){
        for (char letter : T)
            shiftTable.put(letter, P.length);

        for( int i = P.length - 2; i >= 0; i--)
            shiftTable.put(P[i], P.length - 1 -i);
    }
}
