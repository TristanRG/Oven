package States;

public class Stare_usa_inchisa extends Stare {
    private static final Stare_usa_inchisa instance = new Stare_usa_inchisa();

    private Stare_usa_inchisa() {}

    public static Stare_usa_inchisa getInstance() {
        return instance;
    }

    @Override
    public void deschideUsa(Context context) {
        context.setUsaDeschisa(true);
        context.setStare(Stare_usa_deschisa.getInstance());
        System.out.println("Usa este deschisa.");
    }

    @Override
    public void inchideUsa(Context context) {
        System.out.println("Usa este inchisa.");
    }

    @Override
    public void gateste(Context context) {
        if (!context.isUsaDeschisa()) {
            context.setGateste(true);
            context.setStare(Stare_gateste_ON.getInstance());
            context.startTimer();
            System.out.println("Gatitul a inceput.");
        } else {
            System.out.println("Inchide usa mai intai!");
        }
    }

    @Override
    public void tickCeas(Context context) {
        System.out.println("Timerul nu este activ.");
    }
}
