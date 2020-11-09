import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        Path path = Paths.get(System.getProperty("user.dir"), "src");
        List<String> input = new ArrayList<>(Files.readAllLines(Paths.get(path.toString(), "Input2.txt")));

        PrintOutput(input, 3);
    }

    public static void PrintOutput(List input, int numOfCols){
        int numOfString = input.size();
        int rows = numOfString/numOfCols;
        if(numOfString%numOfCols != 0){
            rows++;
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0, x = 0; j < numOfCols; j++, x+=rows){
                if(i+x < 25)
                {
                    System.out.printf("%-25s", input.get(i+x));
                }
            }
            System.out.println();
        }

    }
}
