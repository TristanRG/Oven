package States;

public class Stare_usa_deschisa extends Stare {
    private static final Stare_usa_deschisa instance = new Stare_usa_deschisa();

    private Stare_usa_deschisa() {}

    public static Stare_usa_deschisa getInstance() {
        return instance;
    }

    @Override
    public void deschideUsa(Context context) {
        System.out.println("Usa este deja deschisa.");
    }

    @Override
    public void inchideUsa(Context context) {
        if (context.isUsaDeschisa()) {
            context.setUsaDeschisa(false);
            context.setStare(Stare_usa_inchisa.getInstance());
            System.out.println("Usa a fost inchisa.");
        }
    }

    @Override
    public void gateste(Context context) {
        if (!context.isUsaDeschisa() && !context.isGatesteON()) {
            context.setGateste(true);
            context.setStare(Stare_gateste_ON.getInstance());
            context.startTimer();
        } else {
            System.out.println("Nu se poate incepe gatitul cu usa deschisa.");
        }
    }

    @Override
    public void tickCeas(Context context) {
        System.out.println("Timerul nu poate fi activ in acest mod.");
    }
}
