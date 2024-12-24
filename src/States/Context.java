package States;

import Interfaces.IObservable;
import Interfaces.IObserver;
import Interfaces.IAfisaj_microunde;

import java.util.ArrayList;
import java.util.List;

public class Context implements IObservable {
    private Stare stareCurenta;
    private IAfisaj_microunde afisaj;
    private int timer;
    private final List<IObserver> observers; // List of observers

    private boolean gateste;
    private boolean usaDeschisa;

    public Context(IAfisaj_microunde afisaj) {
        this.afisaj = afisaj;
        this.stareCurenta = Stare_usa_inchisa.getInstance();
        this.timer = 6;
        this.observers = new ArrayList<>();
        this.gateste = false;
        this.usaDeschisa = false;
    }

    public void setStare(Stare stare) {
        this.stareCurenta = stare;
        notifyObservers();
    }

    public Stare getStareCurenta() {
        return stareCurenta;
    }

    public IAfisaj_microunde getAfisaj() {
        return afisaj;
    }

    public int getTimer() {
        return timer;
    }

    public void decrementTimer() {
        timer--;
    }

    public void startTimer() {
        new Thread(() -> {
            while (timer > 0 && gateste) {
                try {
                    Thread.sleep(1000);
                    stareCurenta.tickCeas(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public boolean isGateste() {
        return gateste;
    }

    public void setGateste(boolean gateste) {
        this.gateste = gateste;
    }

    public boolean isUsaDeschisa() {
        return usaDeschisa;
    }

    public void setUsaDeschisa(boolean usaDeschisa) {
        this.usaDeschisa = usaDeschisa;
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

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(this);
        }
    }
}
