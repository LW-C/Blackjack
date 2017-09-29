import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class Main {

    //Deals a card to the player and prints the value to the screen.
    //Returns the value of the card to the main method to add to the player's hand.
    public static int playerTurn()
    {
        Random random = new Random();
        int roundPlayerHand = 0;
        int cardValue = random.nextInt(13) + 1;

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

    //Prints options for the player to the screen and catches input errors
    //Returns the player's choice to the main method
    public static int printOptionsAndCatchErrors()
    {
        int playerChoice = 0;
        Boolean error = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.println();

        System.out.print("Choose an option: ");

        while (error)
        {
            try
            {
                playerChoice = scanner.nextInt();

                if (playerChoice < 1)
                {
                    System.out.println("\nInvalid input!\nPlease enter an integer value between 1 and 4.");
                }
                else if (playerChoice > 4)
                {
                    System.out.println("\nInvalid input!\nPlease enter an integer value between 1 and 4.");
                }
                else
                {
                    error = false;
                    return playerChoice;
                }
            }
            catch (InputMismatchException notAnInt)
            {
                System.out.println("\nInvalid input!\nPlease enter an integer value between 1 and 4.");
            }
            catch (Exception except)
            {
                System.out.println("\nInvalid input!\nPlease enter an integer value between 1 and 4.");
            }


            scanner.nextLine();

            System.out.println();
            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");
            System.out.println();

            System.out.print("Choose an option: ");
        }
            return playerChoice;

    }

    //The dealer takes it's turn
    public static int dealerTurn()
    {
        Random random = new Random();
        int cardValue;
        cardValue = random.nextInt(11) + 16;
        return cardValue;
    }

    //Prints the statistics of all the games played
    public static void statistics(int playerWins, int dealerWins, int numTies, int numGames)
    {
        numGames -= 1;
        double percentPlayerWins = 100 * (((double)playerWins) / ((double)numGames));
        String percentWins = Double.toString(percentPlayerWins);

        if (numGames == 0)
        {
            System.out.println("The first game is being played, there are no statistics.");
            System.out.println();
        }
        else
        {
            percentWins = percentWins.substring(0);

            System.out.println("Number of Player wins: " + playerWins);
            System.out.println("Number of Dealer wins: " + dealerWins);
            System.out.println("Number of tie games: " + numTies);
            System.out.println("Total # of games played is: " + numGames);
            System.out.println("Percentage of Player wins: " + percentWins + "%");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Boolean playAgain = true;
        int numGames = 0;
        int playerHand = 0;
        int dealerHand = 0;
        int playerWins = 0;
        int dealerWins = 0;
        int numTies = 0;
        int choice = 1;
        Boolean gameNotDone = true;

        //Print card value and assign the number value to the playerHand total
        while (playAgain)
        {
            System.out.println("START GAME #" + ++numGames);
            System.out.println();

            while (gameNotDone)
            {
                //What to do based on user's choice
                if (choice == 1)
                {
                    //The player takes a turn
                    playerHand += playerTurn();

                    //Print value of  player hand
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println();

                    //Print options to user if hand is under 21
                    if (playerHand >= 21)
                    {
                        gameNotDone = false;
                        //playAgain = false;
                    }
                    else
                    {
                        choice = printOptionsAndCatchErrors();
                    }
                }
                else if (choice == 2)
                {
                    //dealer's hand gets played
                    dealerHand = dealerTurn();
                    //System.out.println(dealerHand);
                    //return;
                    gameNotDone = false;
                }
                else if (choice == 3)
                {
                    //print statistics
                    statistics(playerWins, dealerWins, numTies, numGames);
                    choice = printOptionsAndCatchErrors();
                }
                else if (choice == 4)
                {
                    //exit game
                    return;
                }

            }

            //Determine who won the round
            if (playerHand == 21)
            {
                //Player wins
                System.out.println("BLACKJACK! You win!");
                System.out.println();
                playerWins++;
            }
            else if (playerHand > 21)
            {
                //Dealer wins
                System.out.println("You exceeded 21! You lose!");
                System.out.println();
                dealerWins++;
            }
            else if (dealerHand > 21)
            {
                //Player wins
                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + playerHand);
                System.out.println();
                System.out.println("You win!");
                System.out.println();
                playerWins++;
            }
            else if (playerHand == dealerHand)
            {
                //Tied game
                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + playerHand);
                System.out.println();
                System.out.println("It's a tie! No one wins!");
                System.out.println();
                numTies++;
            }
            else if (playerHand > dealerHand)
            {
                //Player wins
                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + playerHand);
                System.out.println();
                System.out.println("You win!");
                System.out.println();
                playerWins++;
            }
            else if (dealerHand > playerHand)
            {
                //Dealer wins
                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + playerHand);
                System.out.println();
                System.out.println("Dealer wins!");
                System.out.println();
                dealerWins++;
            }

            playerHand = 0;
            dealerHand = 0;
            choice = 1;
            gameNotDone = true;

        }

        return;
    }
}
