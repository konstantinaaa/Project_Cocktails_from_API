package observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<ICocktailObserver> observers = new ArrayList<>();

    public void addObserver(ICocktailObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(ICocktailObserver observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers() {
        for (ICocktailObserver observer : observers) {
            observer.update();
        }
    }

}
