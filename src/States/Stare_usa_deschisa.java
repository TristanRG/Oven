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
        context.setStare(Stare_usa_inchisa.getInstance());
        context.setUsaDeschisa(false);
        context.getAfisaj().setUsaInchisa();
    }

    @Override
    public void gateste(Context context) {
        System.out.println("Inchide usa mai intai!");
    }

    @Override
    public void tickCeas(Context context) {
        System.out.println("Timerul nu este activ.");
    }
}
