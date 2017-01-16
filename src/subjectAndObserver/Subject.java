package subjectAndObserver;

/**
 * Host subject that communicates data to the observer(s).
 */
public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyAllObservers();
}
