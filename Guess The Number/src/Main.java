import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame(){


        Scanner getInput = new Scanner(System.in);
        System.out.println("Hello!, What is your name?");

        String name = getInput.nextLine();

        int random = (int)(Math.random() * 20) + 1; //20 is the range, 1 is the min i hard codded instead of using a variable

        System.out.println ("the number was " + random);

        int numOfGuesses = 1;
        while(numOfGuesses < 7)
        {
            System.out.println( name + " Choose a integer from 1 - 20");
            int guess = getInput.nextInt();

            if(guess == random)
            {
                System.out.println("Good Job!, You Guessed the correct number in " + numOfGuesses + " tries");
                System.out.println("\n would you like to play again? Y/N");

                char playAgain = getInput.next().charAt(0);
                if(playAgain == 'Y' || playAgain == 'y') {
                    playGame();
                    return;
                }
                else
                {
                    return;
                }
            }
            else if (guess > random)
            {
                System.out.println("The number you guessed was too high \n Guess again");
            }
            else
            {
                System.out.println("The number you guessed was too low \n Guess again");
            }
            numOfGuesses++;
        }


        System.out.println ("You lose! \n");
        System.out.println ("the number was " + random);
    }
}
