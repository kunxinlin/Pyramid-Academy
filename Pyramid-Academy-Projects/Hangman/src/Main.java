import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner getInput = new Scanner(System.in);
        String theString = "Apple".toUpperCase();
        char[] theWord = theString.toCharArray();

        int stage = 0;
        ArrayList<Character> wordGuessedSoFar = new ArrayList<>();
        ArrayList<Character> lettersGuessed = new ArrayList<>();
        char letter;

        for(int i = 0; i < theString.length(); i++)
        {
            wordGuessedSoFar.add('_');
        }

        //System.out.print(wordGuessedSoFar);

        boolean playAgain = false;

        do
        {
            printGameStage(stage);
            printLetterGuessed(lettersGuessed);
            printWord(wordGuessedSoFar);

            System.out.println("\nGuess a letter");

            letter = getInput.nextLine().charAt(0);
            letter = Character.toUpperCase(letter);

            System.out.println("Letter is: " + letter);

            boolean correct = false;

            if(!lettersGuessed.contains(letter)) {
                for (int i = 0; i < theString.length(); i++) {

                    if (letter == theString.charAt(i)) {
                        wordGuessedSoFar.set(i, letter);
                        correct = true;
                    }
                }

                lettersGuessed.add(Character.toUpperCase(letter));
            }
            else
            {
                System.out.println("Letter already guessed");
                continue;
            }

            char[] temp = new char[theWord.length];
            for(int i = 0; i < theWord.length; i++)
            {
                temp[i] = wordGuessedSoFar.get(i);
            }


            if(correct == false){
            stage++;

            if(stage == 6)
            {
                printGameStage(stage);
                System.out.println("Do you want to play again? Y/N");

                char tempChar = getInput.nextLine().charAt(0);
                if(tempChar == 'Y' || tempChar =='y')
                {
                    playAgain = true;
                    //int size = wordGuessedSoFar.size();
                    //int size2 = lettersGuessed.size();

                    wordGuessedSoFar.clear();
                    for(int i = 0; i < theWord.length; i++)
                    {
                        wordGuessedSoFar.add('_');
                    }

                    lettersGuessed.clear();

                    stage = 0;

                }
                else
                {
                    return;
                }
            }}

            if(Arrays.equals(temp, theWord))
            {
                System.out.println("You guessed the word! Good job!");
                System.out.println("Do you want to play again? Y/N");

                char tempChar = getInput.nextLine().charAt(0);
                if(tempChar == 'Y' || tempChar =='y')
                {
                    playAgain = true;

                    //int size = wordGuessedSoFar.size();
                    //int size2 = lettersGuessed.size();

                    wordGuessedSoFar.clear();
                    for(int i = 0; i < theWord.length; i++)
                    {
                        wordGuessedSoFar.add('_');
                    }

                    lettersGuessed.clear();

                    stage = 0;
                }
                else
                {
                    return;
                }
            }


        }while(stage < 6 || playAgain == true);
    }

    public static void printGameStage(int stage)
    {
        switch(stage){

            case 0:
                System.out.println ("  H A N G M A N  \n");
                System.out.println ("     +-----+     \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |           \n");
                System.out.println ("     |           \n");
                System.out.println ("     |           \n");
                System.out.println ("     |           \n");
                System.out.println ("     |           \n");
                System.out.println ("  -------        \n");
                break;

            case 1:
                System.out.println ("                 \n");
                System.out.println ("     +-----+     \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |     O     \n");
                System.out.println ("     |           \n");
                System.out.println ("     |           \n");
                System.out.println ("     |           \n");
                System.out.println ("     |           \n");
                System.out.println ("  -------        \n");
                break;

            case 2:
                System.out.println ("                 \n");
                System.out.println ("     +-----+     \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |     O     \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |           \n");
                System.out.println ("     |           \n");
                System.out.println ("  -------        \n");
                break;

            case 3:
                System.out.println ("                 \n");
                System.out.println ("     +-----+     \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |     O     \n");
                System.out.println ("     |    /|     \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |           \n");
                System.out.println ("     |           \n");
                System.out.println ("  -------        \n");
                break;

            case 4:
                System.out.println ("                 \n");
                System.out.println ("     +-----+     \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |     O     \n");
                System.out.println ("     |    /|\\   \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |           \n");
                System.out.println ("     |           \n");
                System.out.println ("  -------        \n");
                break;

            case 5:
                System.out.println ("                 \n");
                System.out.println ("     +-----+     \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |     O     \n");
                System.out.println ("     |    /|\\   \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |    /      \n");
                System.out.println ("     |           \n");
                System.out.println ("  -------        \n");
                break;

            case 6:
                System.out.println ("                 \n");
                System.out.println ("     +-----+     \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |     O     \n");
                System.out.println ("     |    /|\\   \n");
                System.out.println ("     |     |     \n");
                System.out.println ("     |    / \\   \n");
                System.out.println ("     |           \n");
                System.out.println ("  -------        \n");
                System.out.println ("     YOU LOSE    \n");
                break;
        }
    }

    public static void printWord(ArrayList word)
    {
        System.out.println("\nWord: ");
        for(int i = 0; i < word.size(); i++)
        {
            System.out.print(word.get(i) + " ");
        }
    }

    public static void printLetterGuessed(ArrayList word)
    {
        System.out.print("\n\nLetters Guessed: ");
        for(int i = 0; i < word.size(); i++)
        {
            System.out.print(word.get(i) + " ");
        }
    }
}
