package States;

import Interfaces.IAfisaj_microunde;

public class Context {
    private Stare stareCurenta;
    private IAfisaj_microunde afisaj;
    private int timer;

    public Context(IAfisaj_microunde afisaj) {
        this.afisaj = afisaj;
        this.stareCurenta = Stare_usa_inchisa.getInstance();
        this.timer = 6; // Default timer value
    }

    public void setStare(Stare stare) {
        this.stareCurenta = stare;
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
            while (timer > 0 && stareCurenta instanceof Stare_gateste_ON) {
                try {
                    Thread.sleep(1000);
                    stareCurenta.tickCeas(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
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
}
