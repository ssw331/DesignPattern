package amusementpark.workers;

import java.util.ArrayList;
import java.util.List;


/**
 * @author WWWsy
 */
public class Facility {
    private final List<Observer> observers = new ArrayList<>();
    private final String name;
    private String status;

    public Facility(String name) {
        this.name = name;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(name, status);
        }
    }
}
