import java.util.Scanner;
import java.util.Random;

public class Main {

    public static int printCardValue(int cardValue)
    {
        int roundPlayerHand = 0;

        if (cardValue == 1)
        {
            System.out.println("Your card is an ACE!");
            roundPlayerHand += 1;
        }
        else if (cardValue == 2)
        {
            System.out.println("Your card is a 2!");
            roundPlayerHand +=2;
        }
        else if (cardValue == 3)
        {
            System.out.println("Your card is a 3!");
            roundPlayerHand +=3;
        }
        else if (cardValue == 4)
        {
            System.out.println("Your card is a 4!");
            roundPlayerHand +=4;
        }
        else if (cardValue == 5)
        {
            System.out.println("Your card is a 5!");
            roundPlayerHand +=5;
        }
        else if (cardValue == 6)
        {
            System.out.println("Your card is a 6!");
            roundPlayerHand +=6;
        }
        else if (cardValue == 7)
        {
            System.out.println("Your card is a 7!");
            roundPlayerHand +=7;
        }
        else if (cardValue == 8)
        {
            System.out.println("Your card is a 8!");
            roundPlayerHand +=8;
        }
        else if (cardValue == 9)
        {
            System.out.println("Your card is a 9!");
            roundPlayerHand +=9;
        }
        else if (cardValue == 10)
        {
            System.out.println("Your card is a 10!");
            roundPlayerHand +=10;
        }
        else
        {
            if (cardValue == 11)
                System.out.println("Your card is a JACK!");
            else if (cardValue == 12)
                System.out.println("Your card is a QUEEN!");
            else if (cardValue ==13)
                System.out.println("Your card is a KING!");

            roundPlayerHand += 10;
        }
        return roundPlayerHand;
    }

    public static void main(String[] args)
    {
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
            playerCardValue += printCardValue(playerCardValue);

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
