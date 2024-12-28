package States;

public class Stare_usa_inchisa extends Stare {
    private static final Stare_usa_inchisa instance = new Stare_usa_inchisa();

    private Stare_usa_inchisa() {}

    public static Stare_usa_inchisa getInstance() {
        return instance;
    }

    @Override
    public void deschideUsa(Context context) {
        if (!context.isUsaDeschisa() && !context.isGatesteON()) {
            context.setUsaDeschisa(true);
            context.setStare(Stare_usa_deschisa.getInstance());
        } else if (context.isGatesteON()) {
            System.out.println("Nu poti deschide usa in timp ce gatesti.");
        }
    }

    @Override
    public void inchideUsa(Context context) {
        System.out.println("Usa este deja inchisa.");
    }

    @Override
    public void gateste(Context context) {
        if (!context.isUsaDeschisa() && !context.isGatesteON()) {
            context.setGateste(true);
            context.setStare(Stare_gateste_ON.getInstance());
            context.startTimer();
        } else {
            System.out.println("Inchide usa inainte de a gati.");
        }
    }

    @Override
    public void tickCeas(Context context) {
        System.out.println("Timerul nu poate fi activ in acest mod.");
    }
}
