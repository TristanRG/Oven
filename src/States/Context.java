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
    private int timer = 0;

    public Context() {
        this.observers = new ArrayList<>();
        this.stareCurenta = Stare_usa_inchisa.getInstance();
    }

    public void setStare(Stare stareNoua) {
        this.stareCurenta = stareNoua;
        notifyObservers();
    }

    public void deschideUsa() {
        stareCurenta.deschideUsa(this);
    }

    public void inchideUsa() {
        stareCurenta.inchideUsa(this);
    }

    public void gateste() {
        stareCurenta.gateste(this);
    }

    public void tickCeas() {
        stareCurenta.tickCeas(this);
    }

    public void setUsaDeschisa(boolean usaDeschisa) {
        this.usaDeschisa = usaDeschisa;
        notifyObservers();
    }

    public boolean isUsaDeschisa() {
        return usaDeschisa;
    }

    public void setGateste(boolean gatesteON) {
        this.gatesteON = gatesteON;
        notifyObservers();
    }

    public boolean isGatesteON() {
        return gatesteON;
    }

    public void startTimer() {
        timer = 10;
    }

    public void decrementTimer() {
        if (timer > 0) {
            timer--;
        }
    }

    public int getTimer() {
        return timer;
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
}
