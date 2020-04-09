//return true if a string is a palindrome, using reduce


import java.util.Arrays;

public class Main {
    public static boolean palindrome(String s)
    {
        return Arrays.stream(s.split("")).reduce("", (acc, next) -> next + acc).matches(s);
    }

    public static void main(String[] args) {
        System.out.println(palindrome("aba"));
        System.out.println(palindrome("abc"));
    }
}
