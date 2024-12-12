package UI;

import Interfaces.IAfisaj_microunde;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends Frame implements IAfisaj_microunde {
    private Label usaLabel = new Label("Usa inchisa!");
    private Label gatesteLabel = new Label("Gateste OFF!");
    private Label timerLabel = new Label("6");

    private Context context;

    public MainWindow() {
        context = new Context(this);

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
                context.gateste(); //
            }
        });
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
        timerLabel.setText("6");
    }

    @Override
    public void updateTimer(int secunde) {
        timerLabel.setText(String.valueOf(secunde));
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
