import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class Login {
    HashMap<String,String>users=new HashMap<>();
    static String email="";
    static String password="";
    static Scanner in = new Scanner(System.in);
    public void printLoginScreen()
    {
       users.put("edward123@gmail.com","pass123");
        while (!users.containsKey(email)||!users.containsValue(password)){

                System.out.print("Username: ");
                email=in.next();
                System.out.print("Password: ");
                password=in.next();

                if(users.containsKey(email))
                {
                    if(users.containsValue(password))
                    {
                        System.out.println("Accepted");
                    }
                    else
                    {
                        System.out.println("Password wrong but username found");
                    }
                }
                else
                {
                    System.out.println("Username not found");
                }
            System.out.println();
        }

//        System.out.println(String.format("""
//                """));
    }

}
