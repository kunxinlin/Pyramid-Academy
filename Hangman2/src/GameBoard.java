import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {

    List<String> wordbank;
    String word;
    List<String> theWord;
    List<String> wordGuessedSoFar;
    List<String> lettersGuessed;

    public GameBoard() throws IOException {
        wordbank = Files.readAllLines(Paths.get("wordbank.txt"));
        //word = "APPLE";
        word = wordbank.get((int)(Math.random() * (wordbank.size()))).toUpperCase();
        theWord = Arrays.asList(word.split(""));
        wordGuessedSoFar = getUnderscore(word);
        lettersGuessed = new ArrayList<>();
    }


    static List<String> getUnderscore(String ls){
        return Arrays.stream((ls.split(""))).map(x -> x = "_").collect(Collectors.toList());
    }


    public static void printGameStage (int stage) throws IOException {
        switch(stage)
        {
            case 6:
                Files.lines(Paths.get("HangmanArt.txt")).limit(9).forEach(System.out::println);
                break;
            case 5:
                Files.lines(Paths.get("HangmanArt.txt")).skip(9).limit(9).forEach(System.out::println);
                break;
            case 4:
                Files.lines(Paths.get("HangmanArt.txt")).skip(18).limit(9).forEach(System.out::println);
                break;
            case 3:
                Files.lines(Paths.get("HangmanArt.txt")).skip(27).limit(9).forEach(System.out::println);
                break;
            case 2:
                Files.lines(Paths.get("HangmanArt.txt")).skip(36).limit(9).forEach(System.out::println);
                break;
            case 1:
                Files.lines(Paths.get("HangmanArt.txt")).skip(45).limit(9).forEach(System.out::println);
                break;
            case 0:
                Files.lines(Paths.get("HangmanArt.txt")).skip(54).limit(9).forEach(System.out::println);
                break;
        }
    }

}
