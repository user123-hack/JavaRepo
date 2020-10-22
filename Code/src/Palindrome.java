import java.util.Scanner;
public class Palindrome {

        public static boolean isStringPalindrome(String input) {
            int start=0, end=input.length()-1;
            boolean a=isStringPalindrome(input,start,end);
            return a;


        }
        public static boolean isStringPalindrome(String input, int start, int end)
        {
            char s=input.charAt(start), e=input.charAt(end);
            boolean b=true;
            if(start>end)
                return b;
            b=isStringPalindrome(input,start+1,end-1);
            if(s!=e)
                b=false;
            return b;

        }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(Palindrome.isStringPalindrome(input));
    }
    }


