import java.util.*;

/*Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Note : The order of strings are not important.*/

public class keypad {

    // Return a string array that contains all the possible strings

    public static String[] keypad(int n){
        if(n==0)
        {
            String output[]={""};
            return output;
        }
        String ans[]=keypad(n/10);
        String alpha=helper(n%10);
        String ans2[]=new String[ans.length*alpha.length()];
        int m=0;
        for(int i=0; i<alpha.length(); i++)
        {

            for(int j=0; j<ans.length; j++)
            {
                ans2[m]=ans[j]+alpha.charAt(i);
                m++;
            }
        }
        return ans2;


        // Write your code here

    }
    public static String helper(int n)
    {
        String chars[]={"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return chars[n];
    }



        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int input = s.nextInt();
            String output[] = keypad.keypad(input);
            for(int i = 0; i < output.length; i++) {
                System.out.println(output[i]);
            }
        }


}

