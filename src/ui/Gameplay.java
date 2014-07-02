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
        Seasonality.placeX.add(0.1);
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

        Seasonality.aa.add(new ActionArea(1, 1, 1, 1, Crops.Apples.toString(), this));
        Seasonality.aaX.add(230.0 / 1920.0);
        Seasonality.aaY.add(20.0 / 1080.0);
        Seasonality.aasX.add((430.0 - Seasonality.aaX.get(Seasonality.aaX.size()-1)) / 1920.0);
        Seasonality.aasY.add((124.0 - Seasonality.aaY.get(Seasonality.aaY.size()-1)) / 1080.0);
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(1, 1, 1, 1, Crops.Peaches.toString(), this));
        Seasonality.aaX.add(490.0 / 1920.0);
        Seasonality.aaY.add(66.0 / 1080.0);
        Seasonality.aasX.add((710.0 - Seasonality.aaX.get(Seasonality.aaX.size()-1)) / 1920.0);
        Seasonality.aasY.add((148.0 - Seasonality.aaY.get(Seasonality.aaY.size()-1)) / 1080.0);
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);
        //fix below
        Seasonality.aa.add(new ActionArea(1, 1, 1, 1, Crops.Grapes.toString(), this));
        Seasonality.aaX.add(84.0 / 1174.0);
        Seasonality.aaY.add(98.0 / 868.0);
        Seasonality.aasX.add((180.0 - Seasonality.aaX.get(Seasonality.aaX.size()-1)) / 1174.0);
        Seasonality.aasY.add((200.0 - Seasonality.aaY.get(Seasonality.aaY.size()-1)) / 868.0);
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);
        
        Seasonality.aa.add(new ActionArea(1, 1, 1, 1, Crops.Bananas.toString(), this));
        Seasonality.aaX.add(200.0 / 1174.0);
        Seasonality.aaY.add(120.0 / 868.0);
        Seasonality.aasX.add((310.0 - Seasonality.aaX.get(Seasonality.aaX.size()-1)) / 1174.0);
        Seasonality.aasY.add((236.0 - Seasonality.aaY.get(Seasonality.aaY.size()-1)) / 868.0);
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);
        
        Seasonality.aa.add(new ActionArea(1, 1, 1, 1, Crops.Lemons.toString(), this));
        Seasonality.aaX.add(352.0 / 1174.0);
        Seasonality.aaY.add(170.0 / 868.0);
        Seasonality.aasX.add((500.0 - Seasonality.aaX.get(Seasonality.aaX.size()-1)) / 1174.0);
        Seasonality.aasY.add((252.0 - Seasonality.aaY.get(Seasonality.aaY.size()-1)) / 868.0);
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);
        
        Seasonality.aa.add(new ActionArea(1, 1, 1, 1, Crops.Oranges.toString(), this));
        Seasonality.aaX.add(10.0 / 1174.0);
        Seasonality.aaY.add(233.0 / 868.0);
        Seasonality.aasX.add((140.0 - Seasonality.aaX.get(Seasonality.aaX.size()-1)) / 1174.0);
        Seasonality.aasY.add((326.0 - Seasonality.aaY.get(Seasonality.aaY.size()-1)) / 868.0);
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);
        
        Seasonality.aa.add(new ActionArea(1, 1, 1, 1, Crops.Cherries.toString(), this));
        Seasonality.aaX.add(198.0 / 1174.0);
        Seasonality.aaY.add(280.0 / 868.0);
        Seasonality.aasX.add((270.0 - Seasonality.aaX.get(Seasonality.aaX.size()-1)) / 1174.0);
        Seasonality.aasY.add((350.0 - Seasonality.aaY.get(Seasonality.aaY.size()-1)) / 868.0);
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);
        
        Seasonality.aa.add(new ActionArea(1, 1, 1, 1, Crops.Plums.toString(), this));
        Seasonality.aaX.add(300.0 / 1174.0);
        Seasonality.aaY.add(242.0 / 868.0);
        Seasonality.aasX.add((390.0 - Seasonality.aaX.get(Seasonality.aaX.size()-1)) / 1174.0);
        Seasonality.aasY.add((334.0 - Seasonality.aaY.get(Seasonality.aaY.size()-1)) / 868.0);
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);
        
        Seasonality.aa.add(new ActionArea(1, 1, 1, 1, Crops.Grapes.toString(), this));
        Seasonality.aaX.add(84.0 / 1174.0);
        Seasonality.aaY.add(98.0 / 868.0);
        Seasonality.aasX.add((180.0 - Seasonality.aaX.get(Seasonality.aaX.size()-1)) / 1174.0);
        Seasonality.aasY.add((200.0 - Seasonality.aaY.get(Seasonality.aaY.size()-1)) / 868.0);
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
            if (s != (System.currentTimeMillis() / 1000)) {
                s = System.currentTimeMillis() / 1000;
                Seasonality.timeLeft--;
            }
            Seasonality.s.render();
        }
        Seasonality.gp.setVisible(false);
        Seasonality.mmp.setVisible(true);
        Seasonality.pickedup = -1;
        Seasonality.s.render();
    }

}
