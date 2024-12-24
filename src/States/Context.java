package States;

import Interfaces.IObservable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Context implements IObservable {
    private Stare stareCurenta;
    private final List<Observer> observers;

    private boolean usaDeschisa = false;
    private boolean gatesteON = false;

    public Context() {
        this.observers = new ArrayList<>();
        this.stareCurenta = new Stare_usa_inchisa(this);
    }

    public void setStare(Stare stareNoua) {
        this.stareCurenta = stareNoua;
        notifyObservers();
    }

    public void deschideUsa() {
        if (!usaDeschisa) {
            stareCurenta.deschideUsa();
            usaDeschisa = true;
            notifyObservers();
        }
    }

    public void inchideUsa() {
        if (usaDeschisa) {
            stareCurenta.inchideUsa();
            usaDeschisa = false;
            notifyObservers();
        }
    }

    public void gateste() {
        if (!gatesteON) {
            stareCurenta.gateste();
            gatesteON = true;
            notifyObservers();
        }
    }

    public void oprireGateste() {
        if (gatesteON) {
            gatesteON = false;
            notifyObservers();
        }
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(null, this);
        }
    }

    public boolean isUsaDeschisa() {
        return usaDeschisa;
    }

    public boolean isGatesteON() {
        return gatesteON;
    }
}
