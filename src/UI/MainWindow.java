package UI;

import Interfaces.IAfisaj_microunde;
import States.Context;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Observable;
import java.util.Observer;

public class MainWindow extends Frame implements IAfisaj_microunde, Observer {
    private Label usaLabel = new Label("Usa inchisa!");
    private Label gatesteLabel = new Label("Gateste OFF!");
    private Label timerLabel = new Label("10");

    private Context context;
    private Timer tickTimer;
    private TimerTask tickTask;

    public MainWindow() {
        context = new Context();
        context.subscribe(this);

        Button inchide = new Button("Inchide usa");
        Button deschide = new Button("Deschide usa");
        Button porneste = new Button("Pornit");

        inchide.setBounds(300, 200, 80, 40);
        deschide.setBounds(300, 300, 80, 40);
        porneste.setBounds(300, 400, 80, 40);

        usaLabel.setBounds(150, 200, 150, 60);
        gatesteLabel.setBounds(150, 300, 150, 60);
        timerLabel.setBounds(150, 400, 150, 60);

        add(inchide);
        add(deschide);
        add(porneste);
        add(usaLabel);
        add(gatesteLabel);
        add(timerLabel);

        setSize(500, 500);
        setTitle("Controller pentru microunde");
        setLayout(null);
        setVisible(true);

        inchide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                context.inchideUsa();
            }
        });

        deschide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                context.deschideUsa();
            }
        });

        porneste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                context.gateste();
            }
        });

        tickTimer = new Timer();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Context) {
            Context updatedContext = (Context) arg;

            if (updatedContext.isUsaDeschisa()) {
                setUsaDeschisa();
            } else {
                setUsaInchisa();
            }

            if (updatedContext.isGatesteON()) {
                setGatesteON();
                startTickTimer(updatedContext);
            } else {
                setGatesteOFF();
                stopTickTimer();

                if (!updatedContext.isUsaDeschisa() && !updatedContext.isGatesteON()) {
                    updateTimer(10);
                }
            }

            updateTimer(updatedContext.getTimer());
        }
    }

    @Override
    public void setUsaDeschisa() {
        usaLabel.setText("Usa deschisa!");
    }

    @Override
    public void setUsaInchisa() {
        usaLabel.setText("Usa inchisa!");
    }

    @Override
    public void setGatesteON() {
        gatesteLabel.setText("Gateste ON!");
    }

    @Override
    public void setGatesteOFF() {
        gatesteLabel.setText("Gateste OFF!");
    }

    @Override
    public void updateTimer(int secunde) {
        timerLabel.setText(String.valueOf(secunde));
    }

    private void startTickTimer(Context context) {
        stopTickTimer();

        tickTask = new TimerTask() {
            @Override
            public void run() {
                if (context.isGatesteON()) {
                    context.tickCeas();
                }
            }
        };

        tickTimer.scheduleAtFixedRate(tickTask, 1000, 1000);
    }

    private void stopTickTimer() {
        if (tickTask != null) {
            tickTask.cancel();
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
