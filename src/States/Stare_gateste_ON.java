package States;

public class Stare_gateste_ON extends Stare {
    private static Stare_gateste_ON instance = new Stare_gateste_ON();

    private Stare_gateste_ON() {}

    public static Stare_gateste_ON getInstance() {
        return instance;
    }

    @Override
    public void deschideUsa(Context context) {
        System.out.println("Nu poti deschide usa.");
    }

    @Override
    public void inchideUsa(Context context) {
        System.out.println("Usa este inchisa.");
    }

    @Override
    public void gateste(Context context) {
        System.out.println("Cuptorul gateste.");
    }

    @Override
    public void tickCeas(Context context) {
        context.decrementTimer();
        context.getAfisaj().updateTimer(context.getTimer());
        if (context.getTimer() == 0) {
            context.setStare(Stare_usa_inchisa.getInstance());
            context.getAfisaj().setGatesteOFF();
            context.getAfisaj().setUsaInchisa();
        }
    }
}
