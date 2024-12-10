package UI;

import Interfaces.IAfisaj_microunde;

public class Microunde {
    private enum Stare {
        INACTIV_USA_INCHISA,
        INACTIV_USA_DESCHISA,
        ACTIV_GATESTI
    }

    private Stare stareCurenta = Stare.INACTIV_USA_INCHISA;
    private IAfisaj_microunde afisaj;
    private int timer = 6;

    public Microunde(IAfisaj_microunde afisaj) {
        this.afisaj = afisaj;
    }

    public void deschideUsa() {
        switch (stareCurenta) {
            case INACTIV_USA_INCHISA:
                stareCurenta = Stare.INACTIV_USA_DESCHISA;
                afisaj.setUsaDeschisa();
                break;
            case ACTIV_GATESTI:
                System.out.println("Functioneaza deja!");
                break;
            default:
                System.out.println("Usa deschisa.");
                break;
        }
    }

    public void inchideUsa() {
        switch (stareCurenta) {
            case INACTIV_USA_DESCHISA:
                stareCurenta = Stare.INACTIV_USA_INCHISA;
                afisaj.setUsaInchisa();
                break;
            default:
                System.out.println("Usa inchisa.");
                break;
        }
    }

    public void gateste() {
        switch (stareCurenta) {
            case INACTIV_USA_INCHISA:
                stareCurenta = Stare.ACTIV_GATESTI;
                afisaj.setGatesteON();
                startTimer();
                break;
            case INACTIV_USA_DESCHISA:
                System.out.println("Inchide usa!");
                break;
            default:
                System.out.println("Cuptorul gateste.");
                break;
        }
    }

    public void tickCeas() {
        if (stareCurenta == Stare.ACTIV_GATESTI) {
            timer--;
            afisaj.updateTimer(timer);
            if (timer == 0) {
                stareCurenta = Stare.INACTIV_USA_INCHISA;
                afisaj.setGatesteOFF();
                afisaj.setUsaInchisa();
            }
        }
    }

    private void startTimer() {
        new Thread(() -> {
            while (timer > 0 && stareCurenta == Stare.ACTIV_GATESTI) {
                try {
                    Thread.sleep(1000);
                    tickCeas();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
