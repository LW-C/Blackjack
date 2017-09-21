import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        /*
        Rename as BlackJack.java
         */
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Boolean playAgain = true;
        int playerCardValue = 0;
        int numGames = 0;
        int playerHand = 0;
        int dealerHand = 0;
        int playerWins = 0;
        int dealerWins = 0;
        int choice = 0;

        //Print card value and assign the number value to the playerHand total
        while (playAgain)
        {
            System.out.println("START GAME #" + ++numGames);
            System.out.println();
            playerCardValue = random.nextInt(13) + 1;
            //System.out.println(playerCardValue);
            if (playerCardValue == 1)
            {
                System.out.println("Your card is an ACE!");
                playerHand += 1;
            }
            else if (playerCardValue == 2)
            {
                System.out.println("Your card is a 2!");
                playerHand +=2;
            }
            else if (playerCardValue == 3)
            {
                System.out.println("Your card is a 3!");
                playerHand +=3;
            }
            else if (playerCardValue == 4)
            {
                System.out.println("Your card is a 4!");
                playerHand +=4;
            }
            else if (playerCardValue == 5)
            {
                System.out.println("Your card is a 5!");
                playerHand +=5;
            }
            else if (playerCardValue == 6)
            {
                System.out.println("Your card is a 6!");
                playerHand +=6;
            }
            else if (playerCardValue == 7)
            {
                System.out.println("Your card is a 7!");
                playerHand +=7;
            }
            else if (playerCardValue == 8)
            {
                System.out.println("Your card is a 8!");
                playerHand +=8;
            }
            else if (playerCardValue == 9)
            {
                System.out.println("Your card is a 9!");
                playerHand +=9;
            }
            else if (playerCardValue == 10)
            {
                System.out.println("Your card is a 10!");
                playerHand +=10;
            }
            else
            {
                if (playerCardValue == 11)
                    System.out.println("Your card is a JACK!");
                else if (playerCardValue == 12)
                    System.out.println("Your card is a QUEEN!");
                else if (playerCardValue ==13)
                    System.out.println("Your card is a KING!");

                playerHand += 10;
            }

            //Print value of  player hand
            System.out.println("Your hand is: " + playerHand);
            System.out.println();

            //Print options to user
            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");

            //Assign choice to int choice & use notes from 9/14 to add the error message
            /*
            try
            {
                choice = Integer.parseInt(scanner.next());
            }
            */

            //What to do based on user's choice
            if (choice == 1)
            {
                playAgain = true;
            }

            //needs to be put in an if statement
            playerHand = 0;
            dealerHand = 0;
            playAgain = false;
        }

        scanner.close();
        return;
    }
}
