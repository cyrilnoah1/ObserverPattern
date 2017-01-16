import observerClasses.Cat;
import observerClasses.Dog;
import observerClasses.Duck;
import observerClasses.Mouse;
import subjectData.CoinData;

import java.util.Scanner;

/**
 * Class containing the main method.
 */
public class MainClass {
    private static Scanner scan = new Scanner(System.in);

    /**
     * Main method.
     *
     * @param args String arguments.
     */
    public static void main(String args[]) {
        CoinData coinData = new CoinData();

        // Setting up the subscribers.
        Cat cat = new Cat();
        Dog dog = new Dog();
        Duck duck = new Duck();
        Mouse mouse = new Mouse();

        // Registering the subscribers.
        coinData.registerObserver(cat);
        coinData.registerObserver(dog);
        coinData.registerObserver(duck);
        coinData.registerObserver(mouse);

        // Setting up the data.
        dataSetup(coinData);
    }

    /**
     * Setting up all the data for the action.
     */
    private static void dataSetup(CoinData coinData) {
        // Broadcasting the coin value to the observers.
        System.out.println("Enter the number of coins to be granted: ");
        int coins = scan.nextInt();
        coinData.setCoins(coins);

        // Further interaction with user.
        userChoice(coinData);
    }

    /**
     * Giving user the choice of further processing.
     */
    private static void userChoice(CoinData coinData) {
        System.out.println("\n\n");
        System.out.println("What would you like to do?");
        System.out.println("1) Check total coins of a subscriber.");
        System.out.println("2) Broadcast more coins.");
        System.out.println("3) Exit.");
        System.out.println("Enter choice : ");

        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                checkTotalCoinsOfObserver(coinData);
                break;

            case 2:
                System.out.println("\n\n");
                dataSetup(coinData);
                break;

            case 3:
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice, please try again.");
                userChoice(coinData);
                break;
        }
    }

    /**
     * Check the total coins available with an observer.
     */
    private static void checkTotalCoinsOfObserver(CoinData coinData) {
        System.out.println("Check total coins of...");
        System.out.println("1) Cat.");
        System.out.println("2) Dog.");
        System.out.println("3) Duck.");
        System.out.println("4) Mouse.");
        System.out.println("Enter choice : ");

        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Total coins of "
                        + Cat.class.getSimpleName() + ": " + Cat.getTotalCoins());
                break;

            case 2:
                System.out.println("Total coins of "
                        + Dog.class.getSimpleName() + ": " + Dog.getTotalCoins());
                break;

            case 3:
                System.out.println("Total coins of "
                        + Duck.class.getSimpleName() + ": " + Duck.getTotalCoins());
                break;

            case 4:
                System.out.println("Total coins of "
                        + Mouse.class.getSimpleName() + ": " + Mouse.getTotalCoins());
                break;

            default:
                System.out.println("Invalid choice, please try again.\n\n");
                checkTotalCoinsOfObserver(coinData);
                break;
        }

        userChoice(coinData);
    }
}
