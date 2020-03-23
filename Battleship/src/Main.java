import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame()
    {
        Player player1 = new Player();
        Player player2 = new Player();
        getPlayerName(player1, player2);

        GameBoard gb1 = new GameBoard();
        GameBoard gb2 = new GameBoard();
        GameBoard playBoard1 = new GameBoard();
        GameBoard playBoard2 = new GameBoard();

        playGame(player1, player2, gb1, gb2, playBoard1, playBoard2);

    }

    public static void getPlayerName(Player p1, Player p2)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Battleship Multiplayer");

        System.out.print("Enter Player 1 Name: ");
        p1.setName(scanner.nextLine());

        System.out.print("Enter Player 2 Name: ");
        p2.setName(scanner.nextLine());
    }

    public static void playGame(Player p1, Player p2, GameBoard gb1, GameBoard gb2, GameBoard playBoard1, GameBoard playBoard2)
    {
        System.out.println(p1.getName() + " please enter the coordinates for your ships as: row,col");
        Carrier carrier1 = new Carrier();
        gb1.placeShip(carrier1);
        gb1.printBoard();

        Battleship battleship1 = new Battleship();
        gb1.placeShip(battleship1);
        gb1.printBoard();

        Destoryer destoryer1 = new Destoryer();
        gb1.placeShip(destoryer1);
        gb1.printBoard();

        Submarine submarine1 = new Submarine() ;
        gb1.placeShip(submarine1);
        gb1.printBoard();

        PatrolBoat patrol1 = new PatrolBoat();
        gb1.placeShip(patrol1);
        gb1.printBoard();

        System.out.println(p2.getName() + " please enter the coordinates for your ships as: row,col");
        Carrier carrier2 = new Carrier();
        gb2.placeShip(carrier2);
        gb2.printBoard();

        Battleship battleship2 = new Battleship();
        gb2.placeShip(battleship2);
        gb2.printBoard();

        Destoryer destoryer2 = new Destoryer();
        gb2.placeShip(destoryer2);
        gb2.printBoard();

        Submarine submarine2 = new Submarine() ;
        gb2.placeShip(submarine2);
        gb2.printBoard();

        PatrolBoat patrol2 = new PatrolBoat();
        gb2.placeShip(patrol2);
        gb2.printBoard();

        boolean gameOver = false;

        while(!gameOver)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println(p1.getName() + ", enter a coordinate to strike");
            String input = scanner.nextLine();
            int tempRow = Character.getNumericValue(input.charAt(0));
            int tempCol = Character.getNumericValue(input.charAt(2));

            while(playBoard2.alreadyMarked(tempRow, tempCol))
            {
                System.out.println(p1.getName() + ", enter a different coordinate to strike");
                input = scanner.nextLine();
                tempRow = Character.getNumericValue(input.charAt(0));
                tempCol = Character.getNumericValue(input.charAt(2));
            }

            if(playBoard2.strike(tempRow, tempCol, gb2))
            {
                incrementShipHitCount(gb2.ocean[tempRow][tempCol], carrier2, battleship2, destoryer2, submarine2, patrol2);
            }

            playBoard2.printBoard();

            gameOver = checkGameOver(p1, carrier2, battleship2, destoryer2, submarine2, patrol2);
            if(gameOver)
            {
                break;
            }

            System.out.println(p2.getName() + ", enter a coordinate to strike");
            input = scanner.nextLine();
            tempRow = Character.getNumericValue(input.charAt(0));
            tempCol = Character.getNumericValue(input.charAt(2));

            while(playBoard1.alreadyMarked(tempRow, tempCol))
            {
                System.out.println(p2.getName() + ", enter a different coordinate to strike");
                input = scanner.nextLine();
                tempRow = Character.getNumericValue(input.charAt(0));
                tempCol = Character.getNumericValue(input.charAt(2));
            }

            if(playBoard1.strike(tempRow, tempCol, gb1))
            {
                incrementShipHitCount(gb1.ocean[tempRow][tempCol], carrier1, battleship1, destoryer1, submarine1, patrol1);
            }

            playBoard1.printBoard();

            gameOver = checkGameOver(p2, carrier1, battleship1, destoryer1, submarine1, patrol1);
        }
    }

    public static void incrementShipHitCount(char ch, Carrier c, Battleship b, Destoryer d, Submarine s, PatrolBoat p)
    {
        switch (ch){
            case 'C':
                c.hitCount++;
                if(c.isSunk() == true)
                {
                    System.out.println("Carrier has been sunk");
                }
                break;
            case 'B':
                b.hitCount++;
                if(b.isSunk() == true)
                {
                    System.out.println("Battleship has been sunk");
                }
                break;
            case 'D':
                d.hitCount++;
                if(d.isSunk() == true)
                {
                    System.out.println("Destory has been sunk");
                }
                break;
            case 'S':
                s.hitCount++;
                if(s.isSunk() == true)
                {
                    System.out.println("Submarine has been sunk");
                }
                break;
            case 'P':
                p.hitCount++;
                if(p.isSunk() == true)
                {
                    System.out.println("Patrol Boat has been sunk");
                }
                break;
        }
    }

    public static boolean checkGameOver(Player player, Carrier c, Battleship b, Destoryer d, Submarine s, PatrolBoat p)
    {
        if(c.isSunk() == true && b.isSunk() == true && d.isSunk() == true && s.isSunk() == true && p.isSunk() == true)
        {
            System.out.println(player.getName() + ", Wins");
            return true;
        }
        else
        {
            return false;
        }
    }
}
