package subjectData;

import subjectAndObserver.Observer;
import subjectAndObserver.Subject;

import java.util.ArrayList;

/**
 * Class containing the coin-data.
 */
public class CoinData implements Subject {
    // List of registered observers.
    private ArrayList<Observer> observers;
    private int coins;

    public CoinData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        // Checking whether the observer trying to unregister
        // has previously registered or not.
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObservers() {
        if (observers.size() > 0)
            for (Observer observer : observers) {
                observer.grantCoins(coins);
            }
        else
            System.out.println("No subscribers available");
    }

    /*GETTERS and SETTERS*/
    public void setCoins(int coins) {
        this.coins = coins;
        // Notifying all the observers every time
        // the coins have changed.
        notifyAllObservers();
    }
}
