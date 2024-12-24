package Interfaces;

import java.util.Observer;

public interface IObservable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}
