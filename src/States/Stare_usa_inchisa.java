package States;

import UI.Context;

public class Stare_usa_inchisa extends Stare {
    private static Stare_usa_inchisa instance = new Stare_usa_inchisa();

    private Stare_usa_inchisa() {}

    public static Stare_usa_inchisa getInstance() {
        return instance;
    }

    @Override
    public void deschideUsa(Context context) {
        context.setStare(Stare_usa_deschisa.getInstance());
        context.getAfisaj().setUsaDeschisa();
    }

    @Override
    public void inchideUsa(Context context) {
        System.out.println("Usa este inchisa.");
    }

    @Override
    public void gateste(Context context) {
        context.setStare(Stare_gateste_ON.getInstance());
        context.getAfisaj().setGatesteON();
        context.startTimer();
    }

    @Override
    public void tickCeas(Context context) {
        System.out.println("Timerul nu este activ.");
    }
}
