package States;

public class Stare_gateste_ON extends Stare {
    private static final Stare_gateste_ON instance = new Stare_gateste_ON();

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
        System.out.println("Usa este deja inchisa.");
    }

    @Override
    public void gateste(Context context) {
        System.out.println("Cuptorul este deja in functiune.");
    }

    @Override
    public void tickCeas(Context context) {
        if (context.getTimer() > 0) {
            context.decrementTimer();
        }
        if (context.getTimer() == 0) {
            context.setGateste(false);
            context.setStare(Stare_usa_inchisa.getInstance());
            context.startTimer();
        }
    }
}
