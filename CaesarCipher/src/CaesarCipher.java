import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CaesarCipher {
    //65(A) - 90(Z), 97(a)-122(z)
    static Path path = Paths.get("message.txt");

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt a message?");
        while(true)
        {
            String temp = scanner.nextLine();
            if(temp.toUpperCase().equals("ENCRYPT"))
            {
                encryptMessage();
                break;
            }
            else if(temp.toUpperCase().equals("DECRYPT"))
            {
                decryptMessage();
                break;
            }
            else
            {
                System.out.println("Invalid input, enter encrypt or decrypt");
            }
        }
    }

    public static void encryptMessage () throws IOException {
        Scanner scanner = new Scanner(System.in);
        String message = "";
        int shift = 0;

        System.out.println("Enter a message: \n");
        message = scanner.nextLine();

        do{
            try {
                System.out.println("Enter a key (1-26)");
                shift = Integer.parseInt(scanner.nextLine());
                if(shift < 1 || shift >26)
                {
                    //NumberFormatException ne = new NumberFormatException();  //like an object, have to instantiate an exception if wanna throw
                    //throw ne;
                    throw new NumberFormatException();
                }
            }
            catch(NumberFormatException e) {
                System.out.println("Invalid Input, enter only Integer 1-26");
            }
        }while((shift < 1) || shift > 26);

        String encryptedMsg = encrypt(message, shift);
        Files.write(path, encryptedMsg.getBytes());
        System.out.println("Encrypted Message written to file message.txt");
    }

    public static void decryptMessage() throws IOException { //didnt work without try catch
        Scanner scanner = new Scanner(System.in);
        int shift = 0;

        do {
            try {
                System.out.println("Enter a key (1-26)");
                shift = Integer.parseInt(scanner.nextLine());
                if (shift < 1 || shift > 26) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input, enter only Integer 1-26");
            }
        }while(shift < 1 || shift > 26);

        System.out.println("Decrypting message from " + path);

        try{
            List<String> temp = Files.readAllLines(path);
            String result = "";

            for(var i: temp)
            {
                result += i;
            }

            System.out.println(decrypt(result, shift));
        }catch (NoSuchFileException e)
        {
            System.out.println(e.getMessage() + " does not exist");
            //e.printStackTrace();
        }

    }

    public static String encrypt(String string, int shift) {
        String result = "";

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isLetter(ch))
            {
                if (Character.isUpperCase(ch)) {
                    ch = (char) ((ch + shift - 'A') % 26 + 'A');
                    result += ch;
                } else {
                    ch = (char) ((ch + shift - 'a') % 26 + 'a');
                    result += ch;
                }
            }
            else
            {
                result += ch;
            }
        }

        return result;
    }

    public static String decrypt(String string, int shift)
    {
        return encrypt(string, 26-shift);
    }

    public static boolean isAlpha(String s) //using regex
    {
        //check for if string is null, and string is empty, then if only letters
        return (s != null) && (!s.equals("")) && s.matches("^[a-zA-Z]*$");
    }

    public static boolean isAlpha2(String s) //using lamda expression
    {
        return (s != null) && (!s.equals("")) && s.chars().allMatch(Character::isLetter); //chars() return IntStream
    }
}
