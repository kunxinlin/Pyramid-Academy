import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> playerPos = new ArrayList<>(); //global
    static ArrayList<Integer> computerPos = new ArrayList<>();

    public static void main(String[] args) {
        //1-9 space


        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Do you want to be X or O");
        //String temp = scanner.next().toUpperCase();

        Scanner scanner = new Scanner(System.in);

        boolean gameOver = false;
        while (gameOver == false) {

            char[][] gameBoard = {
                    {' ', '|', ' ', '|', ' '},
                    {'-', '-', '-', '-', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '-', '-', '-', '-'},
                    {' ', '|', ' ', '|', ' '}};

            System.out.println("Do you want to be X or O");
            String temp = scanner.next().toUpperCase();

            char playerXO = chooseXO(temp);
            char computerXO;

            if (playerXO == 'X') {
                computerXO = 'O';
            } else {
                computerXO = 'X';
            }

            System.out.println("player is: " + playerXO);
            System.out.println("computer is: " + computerXO);

            System.out.println("Computer goes first");

            while (gameOver == false){

                System.out.println("Computer's Turn");
            Random rand = new Random();
            int pos = rand.nextInt(9) + 1;

            while (computerPos.contains(pos) || playerPos.contains(pos)) {
                //System.out.println("Position already marked! Enter a empty position");
                pos = rand.nextInt(9) + 1;
            }
            computerPos.add(pos);

            placeXO(gameBoard, pos, computerXO);

            printGameBoard(gameBoard);
            gameOver = checkWin();

            if (gameOver == true) {
                System.out.println("Press Y to play again");
                String tempString = scanner.next();
                if (tempString.equals("Y")|| tempString.equals("y")) {
                    gameOver = false;
                    break;
                } else {
                    break;
                }
            }

            System.out.println("Enter your move (1-9)");
            pos = scanner.nextInt();

            while (computerPos.contains(pos) || playerPos.contains(pos)) {
                System.out.println("Position already marked! Enter a empty position");
                pos = scanner.nextInt();
            }

            playerPos.add(pos);
            placeXO(gameBoard, pos, playerXO);

            printGameBoard(gameBoard);
                System.out.println();
            gameOver = checkWin();

            if (gameOver == true) {
                System.out.println("Press Y to play again");
                String tempString = scanner.next();

                if (tempString.equals("Y")|| tempString.equals("y")) {
                    gameOver = false;
                    break;
                } else {
                    break;
                }
            }
        }
    } }

    public static void printGameBoard(char[][] gameBoard){
        for (char[] row : gameBoard) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static char chooseXO(String temp){
        Scanner scanner = new Scanner(System.in);
        char tempChar;

        do {
            if (temp.equals("X"))
            {
                tempChar = 'X';
                return tempChar;
            }
            else if (temp.equals("O"))
            {
                tempChar = 'O';
                return tempChar;
            }
            else
            {
                System.out.println("Please enter only X or O");
                temp = scanner.next().toUpperCase();
            }
        } while (true);
    }

    public static void placeXO(char[][] gameBoard, int pos, char xo)
    {
        switch(pos)
        {
            case 1:
                gameBoard[0][0] = xo;
                break;
            case 2:
                gameBoard[0][2] = xo;
                break;
            case 3:
                gameBoard[0][4] = xo;
                break;
            case 4:
                gameBoard[2][0] = xo;
                break;
            case 5:
                gameBoard[2][2] = xo;
                break;
            case 6:
                gameBoard[2][4] = xo;
                break;
            case 7:
                gameBoard[4][0] = xo;
                break;
            case 8:
                gameBoard[4][2] = xo;
                break;
            case 9:
                gameBoard[4][4] = xo;
                break;
            default:
                break;
        }

    }

    public static boolean checkWin(){
        if((playerPos.contains(1) && playerPos.contains(2) && playerPos.contains(3)) ||
                (playerPos.contains(4) && playerPos.contains(5) && playerPos.contains(6)) ||
                (playerPos.contains(7) && playerPos.contains(8) && playerPos.contains(9)) ||
                (playerPos.contains(1) && playerPos.contains(4) && playerPos.contains(7)) ||
                (playerPos.contains(2) && playerPos.contains(5) && playerPos.contains(8)) ||
                (playerPos.contains(3) && playerPos.contains(6) && playerPos.contains(9)) ||
                (playerPos.contains(1) && playerPos.contains(5) && playerPos.contains(9)) ||
                (playerPos.contains(3) && playerPos.contains(5) && playerPos.contains(7)))
        {
            System.out.println("You Win!");
            playerPos.clear();
            computerPos.clear();

            return true;
        }
        else if((computerPos.contains(1) && computerPos.contains(2) && computerPos.contains(3)) ||
                (computerPos.contains(4) && computerPos.contains(5) && computerPos.contains(6)) ||
                (computerPos.contains(7) && computerPos.contains(8) && computerPos.contains(9)) ||
                (computerPos.contains(1) && computerPos.contains(4) && computerPos.contains(7)) ||
                (computerPos.contains(2) && computerPos.contains(5) && computerPos.contains(8)) ||
                (computerPos.contains(3) && computerPos.contains(6) && computerPos.contains(9)) ||
                (computerPos.contains(1) && computerPos.contains(5) && computerPos.contains(9)) ||
                (computerPos.contains(3) && computerPos.contains(5) && computerPos.contains(7)))
        {
            System.out.println("Computer Wins");
            playerPos.clear();
            computerPos.clear();
            return true;
        }
        else if(playerPos.size() + computerPos.size() == 9)
        {
            System.out.println("Game Tied");
            playerPos.clear();
            computerPos.clear();
            return true;
        }

        return false;
    }
}
