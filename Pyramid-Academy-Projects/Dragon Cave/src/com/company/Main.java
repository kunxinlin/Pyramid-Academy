package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("Choose a dragon cave to enter (1) or (2)");
	if(getInput() == 1)
    {
        System.out.println("You got eaten!");
    }
	else
    {
        System.out.println("You got treasure!");
    }

    }

    public static int getInput()
    {
        return new Scanner(System.in).nextInt();
    }
}
