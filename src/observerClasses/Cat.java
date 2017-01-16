package observerClasses;

import subjectAndObserver.Observer;

/**
 * Cat is an observer.
 */
public class Cat implements Observer {
    private static int totalCoins;

    @Override
    public void grantCoins(int coins) {
        totalCoins += coins;
        // Show appropriate message.
        showCoinsMessage(coins);
    }

    /**
     * Method to show appropriate message based on the coin values.
     *
     * @param coins Coins obtained.
     */
    private void showCoinsMessage(int coins) {
        String message;
        if (coins > 1)
            message = Cat.class.getSimpleName() + " has been granted " + coins + " coins";
        else if (coins == 1)
            message = Cat.class.getSimpleName() + " has been granted " + coins + " coin";
        else if (coins == -1)
            message = Cat.class.getSimpleName() + " has been deducted " + coins + " coin";
        else
            message = Cat.class.getSimpleName() + " has been deducted " + coins + " coins";

        System.out.println(message);
    }


    /*GETTERS and SETTERS*/
    public static int getTotalCoins() {
        return totalCoins;
    }
}
