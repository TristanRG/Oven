package States;

public class Stare_usa_deschisa extends Stare {
    private static final Stare_usa_deschisa instance = new Stare_usa_deschisa();

    private Stare_usa_deschisa() {}

    public static Stare_usa_deschisa getInstance() {
        return instance;
    }

    @Override
    public void deschideUsa(Context context) {
        System.out.println("Usa este deschisa.");
    }

    @Override
    public void inchideUsa(Context context) {
        context.setUsaDeschisa(false);
        context.setStare(Stare_usa_inchisa.getInstance());
        System.out.println("Usa este inchisa.");
    }

    @Override
    public void gateste(Context context) {
        System.out.println("Inchide usa!");
    }

    @Override
    public void tickCeas(Context context) {
        System.out.println("Timerul nu este activ.");
    }
}
