package hangman;/*    Reimplement hangman.

Limitations/differences from before:
-No loops are allowed except for the main game loop, which is a single while loop. All looping must be subsumed through map, filter, and reduce.
-The art for hangman should be read from a file, this art connotates the state of the game.
-The user should be able to enter their name, where their name and score will be recorded to a file after each game.
-The game will tell the user if they have the high score or not.
- no exceptions are allowed, all exceptions must be caught by the program.*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException{
        GameBoard game = new GameBoard();
        Player player = new Player(getPlayerName());
        System.out.println(player.getName());
        String temp = "";

        while(player.getScore()!=0){
            start(game, player);

            temp = String.join("", game.wordGuessedSoFar);
            if(temp.equals(game.word))
            {
                System.out.println("The word was: " + game.word);
                System.out.println("You Win!");
                int highScore = PlayerCRUD.getHighScoreFromDatabase();
                PlayerCRUD.createRecord(player);

                if(player.getScore() >= highScore)
                {
                    System.out.println("Congratz, you got the high score of " + player.getScore() + " lives remaining");
                }
                else
                {
                    System.out.println("You did not beat the high score of " + highScore + " lives remaining");
                }
                //writeToFile(player);
                break;
            }
        }
    }

    public static void start(GameBoard game, Player player) throws IOException{

        GameBoard.printGameStage(player.getScore()); //get player's live
        printLetterGuessed(game.lettersGuessed);
        printWordGuessed(game.wordGuessedSoFar);
        String guess = getGuessRecursive(game);
        game.lettersGuessed.add(guess);
        game.sortList();
        game.wordGuessedSoFar = setGuess(game, guess);
        boolean correctGuess = checkGuess(game, guess);

        if(correctGuess == false)
        {
            player.decLives();
            if(player.getScore() == 0) {
                GameBoard.printGameStage(0);
                System.out.println("You Lose");
                writeToFile(player);
            }
        }
    }

    public static String getGuess(GameBoard game) {
        String guess = "";
        boolean valid = false;

        while (!valid) {
            System.out.println("Guess a letter:");
            Scanner scanner = new Scanner(System.in);
            guess = scanner.nextLine().toUpperCase();

            if (guess.length() > 1) {
                System.out.println("only enter a single letter");
                continue;
            } else if (!Character.isLetter(guess.charAt(0))) {
                System.out.println("only letters are allowed");
                continue;
            } else if (game.lettersGuessed.contains(guess)) {
                System.out.println("you already guessed that letter");
                continue;
            } else {
                valid = true;
            }
        }
        return guess;
    }

    public static String getGuessRecursive(GameBoard game){
        String guess = "";
        System.out.println("Guess a letter:");
        Scanner scanner = new Scanner(System.in);
        guess = scanner.nextLine().toUpperCase();

        if (guess.length() > 1) {
            System.out.println("only enter a single letter");
            return getGuessRecursive(game);
        } else if (!Character.isLetter(guess.charAt(0))) {
            System.out.println("only letters are allowed");
            return getGuessRecursive(game);
        } else if (game.lettersGuessed.contains(guess)) {
            System.out.println("you already guessed that letter");
            return getGuessRecursive(game);
        } else {
            return guess;
        }
    }

    public static List<String> setGuess(GameBoard game, String guess)
    {
        //use intstream as a sub for, forloop. then map an obj to each int.
        return IntStream.range(0, game.word.length())
                .mapToObj(i->{
                    if(game.wordGuessedSoFar.get(i).equals("_") && game.word.charAt(i) == guess.charAt(0))
                    {
                        return guess;
                    }
                    else
                    {
                        return game.wordGuessedSoFar.get(i);
                    }
                }).collect(Collectors.toList());
    }

    public static boolean checkGuess(GameBoard game, String guess)
    {
        return Arrays.stream(game.word.split("")).anyMatch(x-> x.equals(guess));
    }

    public static void printLetterGuessed(List<String> lettersGuessed){
        System.out.println("Letter Guessed: " + lettersGuessed);
    }

    public static void printWordGuessed(List<String> wordGuessed){
        System.out.println("Word: ");
        wordGuessed.stream().map(x -> x+" ").forEach(System.out::print);
        System.out.println();
    }

    public static String getPlayerName()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        return scanner.nextLine();
    }

    public static void writeToFile(Player player) {
        try{
            Files.writeString(Paths.get("Record.txt"), player.getName() + "," + player.getScore(), StandardOpenOption.CREATE, StandardOpenOption.APPEND );
        }catch(IOException io)
        {
            io.printStackTrace();
        }
    }

    public static int readHighScoreFromFile()
    {
        int highScore = -1;
        //get the number from each line and then reduce using max, and finally get the element.
        try{
             highScore = Files.lines(Paths.get("Record.txt"))
                .map(x->{
                    String[] temp = x.split(",");
                    return Integer.parseInt(temp[1]);
                }).reduce(Integer::max).get();
        }
        catch(FileNotFoundException e) {
            System.out.println("Record.txt Not Found");
        }
        catch(IOException io) {
            io.printStackTrace();
        }

        return highScore;
    }

}
