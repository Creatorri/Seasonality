package ui;

import input.ActionArea;
import input.MButton;
import javax.swing.JPanel;
import seasonality.Crops;
import seasonality.Seasonality;

/**
 *
 * @author Torri
 */
public class Gameplay extends JPanel implements Runnable {

    public Thread countDown = new Thread("Countdown");
    private boolean run = false;

    public Gameplay() {
        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Back To Menu", this));
        Seasonality.placeX.add(0.9);
        Seasonality.placeY.add(0.95);
        Seasonality.sizeX.add(0.2);
        Seasonality.sizeY.add(0.1);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);

        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Pick Up", this));
        Seasonality.placeX.add(0.30);
        Seasonality.placeY.add(0.725);
        Seasonality.sizeX.add(0.1);
        Seasonality.sizeY.add(0.05);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(false);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);

        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Put Back", this));
        Seasonality.placeX.add(0.70);
        Seasonality.placeY.add(0.725);
        Seasonality.sizeX.add(0.1);
        Seasonality.sizeY.add(0.05);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(false);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(1, 1, 1, 1, Crops.Green_Beans.toString(), this));
        Seasonality.aaX.add(.37604166666666666);
        Seasonality.aaY.add(.43148148148148147);
        Seasonality.aasX.add(.5458333333333333 - .37604166666666666);
        Seasonality.aasY.add(.6851851851851852 - .43148148148148147);
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);
    }

    public synchronized void startGame(double mins) {
        stopGame();
        run = true;
        Seasonality.mmp.setVisible(false);
        Seasonality.timeLeft = (long) (mins * 60);
        countDown = new Thread(this, "Countdown");
        countDown.start();
    }

    public synchronized void stopGame() {
        Seasonality.timeLeft = 0;
        run = false;
        for (int i = 0; i < Seasonality.pointTaken.length; i++) {
            Seasonality.pointTaken[i] = false;
            Seasonality.clicked[i] = false;
        }
        Seasonality.score = 0;
    }

    @Override
    public void run() {
        long s = System.currentTimeMillis() / 1000;
        while (Seasonality.timeLeft > 0 && run) {
            if (s == (System.currentTimeMillis() / 1000)) {
                continue;
            }
            s = System.currentTimeMillis() / 1000;
            Seasonality.timeLeft--;
            try {
                Seasonality.s.render();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        Seasonality.gp.setVisible(false);
        Seasonality.mmp.setVisible(true);
        try {
            Seasonality.s.render();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
