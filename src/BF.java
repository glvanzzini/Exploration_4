import java.io.*;

/**
 * Created by Giampiero on 10/30/2016.
 */
public class BF {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("sm.txt")); //new bufferedReader
        int count = 0;
        char[] pattern = in.readLine().toCharArray();
        //System.out.println(Arrays.toString(pattern));
        while(in.ready()){ //while loop reads in characters and counts the total number
            in.read();
            count++;
        }
        in.close();
        BufferedReader ch = new BufferedReader(new FileReader("sm.txt"));
        char[] chars = new char[count];
        ch.readLine();
        while(ch.ready()){ //reads in characters again and this time places them in an array
            ch.read(chars);
        }
        ch.close();
//       for(int i = 0; i < chars.length; i++){
//           System.out.print(chars[i] + " ");
//       }
//       System.out.println();
        long Start = System.nanoTime();
        System.out.println(StringMatch(chars, pattern) + "\nTotal Time: " + (System.nanoTime() - Start));

    }

    private static int StringMatch(char[] message, char[] pattern){
        for(int i = 0; i <= (message.length - pattern.length); i++){
            int j = 0;
            while(j < pattern.length && pattern[j] == message[i + j]){
                j = j + 1;
            }
            if(j == pattern.length){
                return i;
            }
        }
        return -1;
    }

}
