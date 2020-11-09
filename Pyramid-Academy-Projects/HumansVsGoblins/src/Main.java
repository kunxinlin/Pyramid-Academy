/*
1.	Everything must be objects: land/goblins/humans
2.	You must override the toString method to represent each of the object
3.	Create a grid for the game world
4.	Use UTF characters for the players and goblins and the land
5.	Game is turn based move: n/s/e/w
6.	Once a human and goblin collide combat is initiated
7.	Combat uses math.random
8.	Extras:
    a.	human has inventory system
    b.	goblins have drops
    c.	stats can be modified by equipment
    d.	map gen random treasure chest after each round of combat
    e.	goblins pursue player

 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Human human = new Human();
        Goblin goblin = new Goblin();


        Board.setPosition(human.position, new int[] {2,4}, human.human);
        Board.setPosition(goblin.position, new int[] {0,0}, goblin.goblin);
        //Board.checkCollision();
        gameBoard.printBoard();

        System.out.println("Use W/A/S/D to move");

        //Board.setPosition(human.position, new int[]{1,4}, human.human);
        //gameBoard.printBoard();

        startGame(gameBoard);

    }

    public static void startGame(Board gameBoard)
    {
       boolean collide = false;

       while(collide == false)
       {
           boolean outBound = true;

           System.out.println("Goblins Turn: ");
           Scanner scanner = new Scanner(System.in);
           while(outBound == true)
           {
               String input = scanner.nextLine().toUpperCase();

               while(!input.equals("W") && !input.equals("A") && !input.equals("S") && !input.equals("D"))
               {
                   System.out.println("Invalid input, please enter only W/A/S/D");
                   input = scanner.nextLine().toUpperCase();
               }

               outBound = gameBoard.move(input, Goblin.goblin, Goblin.position);
               gameBoard.printBoard();
           }

           outBound = true;

           collide = Board.checkCollision();

           if(collide)
           {
               break;
           }

           System.out.println("Human's Turn: ");
           while(outBound == true)
           {
               String input = scanner.nextLine().toUpperCase();

               System.out.println(input);
               while(!input.equals("W") && !input.equals("A") && !input.equals("S") && !input.equals("D"))
               {
                   System.out.println("Invalid input, please enter only W/A/S/D");
                   input = scanner.nextLine().toUpperCase();
               }

               outBound = gameBoard.move(input, Human.human, Human.position);
               gameBoard.printBoard();
           }
           collide = Board.checkCollision();
       }

       int GoblinAtk = (int)(Math.random() * 99);
       int HumanAtk = (int)(Math.random() * 99);

       System.out.println("The Goblin rolled a " + GoblinAtk + " on their ATK");
       System.out.println("The Human rolled a " + HumanAtk + " on their ATK");

       if(GoblinAtk == HumanAtk)
       {
           System.out.println("The Battle was a DRAW");
       }
       else if(GoblinAtk > HumanAtk)
       {
           System.out.println("The Goblin was stronger, Goblin Wins");
       }
       else
       {
           System.out.println("The Human was stronger, Human Wins");
       }
    }
}
