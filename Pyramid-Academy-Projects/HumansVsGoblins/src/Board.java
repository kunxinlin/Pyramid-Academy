import java.lang.reflect.Array;
import java.util.Arrays;

public class Board {
    public static String[][] spaces = new String [3][5];
    public static char[] underScore = {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'};

    public Board()
    {
        for(int i = 0; i <3; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                spaces[i][j] = " ";
            }
        }
    }

    public static void printBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.print('|');
            for(int j = 0; j < 5; j++)
            {
                System.out.print(spaces[i][j]);
                System.out.print('|');
            }
            System.out.println();
            System.out.println(underScore);
        }
    }

    public static boolean move(String input, String humanGob, int[] pos)
    {
        int[] next = new int[]{pos[0], pos[1]};

        switch (input)
        {
            case "W":
                next[0] = pos[0] - 1;
                if(OutOfBound(next))
                {
                    return true;
                }
                setPosition(pos, next, humanGob);
                break;
            case "A":
                next[1] = pos[1] - 1;
                if(OutOfBound(next))
                {
                    return true;
                }
                setPosition(pos, next, humanGob);
                break;
            case "S":
                next[0] = pos[0] + 1;
                if(OutOfBound(next))
                {
                    return true;
                }
                setPosition(pos, next, humanGob);
                break;
            case "D":
                next[1] = pos[1] + 1;
                if(OutOfBound(next))
                {
                    return true;
                }
                setPosition(pos, next, humanGob);
                break;

        }
        return false;
    }

    public static void setPosition(int[] currPos, int[] nextPos, String humanGob)
    {
        spaces[currPos[0]] [currPos[1]] = " ";
        spaces[nextPos[0]] [nextPos[1]] = humanGob;

        if(humanGob == Human.human)
        {
            Human.position[0] = nextPos[0];
            Human.position[1] = nextPos[1];

            //System.out.println(Arrays.toString(Human.position));
        }
        else
        {
            Goblin.position[0] = nextPos[0];
            Goblin.position[1] = nextPos[1];
            //System.out.println(Arrays.toString(Goblin.position));
        }
    }

    public static boolean OutOfBound(int[] next)
    {
        if(next[0] < 0 || next[0] > 2 || next[1] < 0 || next[1] > 4)
        {
            System.out.println("Can't move in that direction");
            return true;
        }
        return false;
    }

    public static boolean checkCollision()
    {
        if(Human.position[0] == Goblin.position[0])
        {
            if(Math.abs(Goblin.position[1]-Human.position[1]) == 1 || Math.abs(Human.position[1]-Goblin.position[1]) == 1)
            {
                return true;
            }
        }
        else if(Human.position[1] == Goblin.position[1])
        {
            if(Math.abs(Goblin.position[0]-Human.position[0]) == 1 || Math.abs(Human.position[0]-Goblin.position[0]) == 1)
            {
                return true;
            }
        }
        return false;
    }
}
