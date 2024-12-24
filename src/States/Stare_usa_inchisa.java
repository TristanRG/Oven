package States;

public class Stare_usa_inchisa extends Stare {
    private static final Stare_usa_inchisa instance = new Stare_usa_inchisa();

    private Stare_usa_inchisa() {}

    public static Stare_usa_inchisa getInstance() {
        return instance;
    }

    @Override
    public void deschideUsa(Context context) {
        context.setStare(Stare_usa_deschisa.getInstance());
        context.setUsaDeschisa(true);
        context.getAfisaj().setUsaDeschisa();
    }

    @Override
    public void inchideUsa(Context context) {
        System.out.println("Usa este deja inchisa.");
    }

    @Override
    public void gateste(Context context) {
        if (!(context.isUsaDeschisa())) {
            context.setStare(Stare_gateste_ON.getInstance());
            context.setGateste(true);
            context.getAfisaj().setGatesteON();
            context.startTimer();
        } else if (context.isUsaDeschisa()) {
            System.out.println("Inchide usa mai intai!");
        }
    }

    @Override
    public void tickCeas(Context context) {
        System.out.println("Timerul nu este activ.");
    }
}
