package States;
import UI.Context;

public abstract class Stare {
    public abstract void deschideUsa(Context context);
    public abstract void inchideUsa(Context context);
    public abstract void gateste(Context context);
    public abstract void tickCeas(Context context);
}
