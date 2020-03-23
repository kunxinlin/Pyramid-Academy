import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    public char[][] ocean = new char [10][10];
    //private Scanner scanner = new Scanner(System.in);

    public GameBoard()
    {
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0 ; j < 10; j++)
            {
                ocean[i][j] = '~';
            }
        }
    }

    public void printBoard()
    {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for(int i = 0; i < 10; i++)
        {
            System.out.print(i + " ");
            for(int j = 0; j < 10; j++)
            {
                System.out.print(ocean[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean placeDirection(String d)
    {
        if(d.equals("H") || d.equals("h"))
        {
            return true;
        }

        if(d.equals("V") || d.equals("v"))
        {
            return false;
        }
        return false;
    }

    public boolean canPlaceHere(int row, int col, int length, boolean direction)
    {
        if(direction)
        {
            if(col + length > 9)
            {
                System.out.println("Can't place there, ship will be out of bound");
                return false;
            }

            for(int i = 0; i < length; i++)
            {
                if(ocean[row][col+i] != '~')
                {
                    System.out.println("Can't overlap another ship, please enter another coordinate");
                    return false;
                }
            }
        }

        if(!direction)
        {
            if(row + length > 9)
            {
                System.out.println("Can't place there, ship will be out of bound");
                return false;
            }

            for(int i = 0; i < length; i++)
            {
                if(ocean[row+i][col] != '~')
                {
                    System.out.println("Can't overlap another ship, please enter another coordinate");
                    return false;
                }
            }
        }

        return true;
    }

    public void placeShip(Ship ship)
    {
        int tempRow;
        int tempCol;
        boolean direction;
        boolean canPlace = false;
        do {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the coordinates for your " + ship.name + ": ");

            String input = scanner.nextLine();
            tempRow = Character.getNumericValue(input.charAt(0));
            tempCol = Character.getNumericValue(input.charAt(2));

            System.out.println("input was: " + tempRow + "," + tempCol); //testing
            System.out.println("Place horizontally or vertically? (h or v): ");
            direction = placeDirection(scanner.next());

            canPlace = canPlaceHere(tempRow, tempCol, ship.length, direction);
        }while(canPlace == false);

        ship.setRow(tempRow);
        ship.setCol(tempCol);
        ship.setDirection(direction);

        for(int i = 0; i < ship.length; i++)
        {
            if(direction)
            {
                ocean[ship.row][ship.col+i] = ship.character;
            }
            else
            {
                ocean[ship.row+i][ship.col] = ship.character;
            }
        }
    }

    public boolean strike(int row, int col, GameBoard gb2)
    {
        if(gb2.ocean[row][col] == '~')
        {
            System.out.println("Missed");
            this.ocean[row][col] = 'M';
            return false;
        }
        else
        {
            System.out.println("It's a Hit");
            this.ocean[row][col] = 'X';
            return true;
        }
    }

    public boolean alreadyMarked(int row, int col)
    {
        if(ocean[row][col] != '~')
        {
            System.out.println("location already marked, please enter another coordinate");
            return true;
        }

        return false;
    }
}
