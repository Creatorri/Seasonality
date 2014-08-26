package ui;

import input.ActionArea;
import input.MButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import seasonality.Crops;
import seasonality.Seasonality;
import static seasonality.Seasonality.score;
import static seasonality.Seasonality.timeLeft;

/**
 *
 * @author Torri
 */
public class Gameplay extends JPanel implements Runnable {

    public Thread countDown = new Thread("Countdown");
    private boolean run = false;

    public Gameplay() {
        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Back To Menu", this));
        Seasonality.placeX.add(0.05);
        Seasonality.placeY.add(0.975);
        Seasonality.sizeX.add(0.1);
        Seasonality.sizeY.add(0.05);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);

        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Back", this));
        Seasonality.placeX.add(0.70);
        Seasonality.placeY.add(0.725);
        Seasonality.sizeX.add(0.1);
        Seasonality.sizeY.add(0.05);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(false);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Apples, this));
        Seasonality.aaX.add(140);
        Seasonality.aaY.add(12);
        Seasonality.aasX.add((260 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((100 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Peaches, this));
        Seasonality.aaX.add(300);
        Seasonality.aaY.add(52);
        Seasonality.aasX.add((436 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((120 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Grapes, this));
        Seasonality.aaX.add(84);
        Seasonality.aaY.add(98);
        Seasonality.aasX.add((180 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((200 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Bananas, this));
        Seasonality.aaX.add(200);
        Seasonality.aaY.add(120);
        Seasonality.aasX.add((310 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((236 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Lemons, this));
        Seasonality.aaX.add(352);
        Seasonality.aaY.add(170);
        Seasonality.aasX.add((500 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((252 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Oranges, this));
        Seasonality.aaX.add(10);
        Seasonality.aaY.add(233);
        Seasonality.aasX.add((140 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((326 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Cherries, this));
        Seasonality.aaX.add(198);
        Seasonality.aaY.add(280);
        Seasonality.aasX.add((270 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((350 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Plums, this));
        Seasonality.aaX.add(300);
        Seasonality.aaY.add(242);
        Seasonality.aasX.add((390 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((334 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Avocado, this));
        Seasonality.aaX.add(475);
        Seasonality.aaY.add(266);
        Seasonality.aasX.add((586 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((366 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Mushrooms, this));
        Seasonality.aaX.add(5);
        Seasonality.aaY.add(375);
        Seasonality.aasX.add((144 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((434 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Sweet_Peppers, this));
        Seasonality.aaX.add(104);
        Seasonality.aaY.add(455);
        Seasonality.aasX.add((220 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((530 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Cantelopes, this));
        Seasonality.aaX.add(295);
        Seasonality.aaY.add(382);
        Seasonality.aasX.add((440 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((455 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Peas, this));
        Seasonality.aaX.add(247);
        Seasonality.aaY.add(488);
        Seasonality.aasX.add((395 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((560 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Zucchinis, this));
        Seasonality.aaX.add(478);
        Seasonality.aaY.add(408);
        Seasonality.aasX.add((623 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((498 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Lettuce, this));
        Seasonality.aaX.add(715);
        Seasonality.aaY.add(311);
        Seasonality.aasX.add((840 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((418 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Garlic, this));
        Seasonality.aaX.add(750);
        Seasonality.aaY.add(426);
        Seasonality.aasX.add((872 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((501 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Watermelons, this));
        Seasonality.aaX.add(895);
        Seasonality.aaY.add(360);
        Seasonality.aasX.add((1040 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((466 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Onions, this));
        Seasonality.aaX.add(1094);
        Seasonality.aaY.add(365);
        Seasonality.aasX.add((1174 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((441 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Pineapples, this));
        Seasonality.aaX.add(1070);
        Seasonality.aaY.add(81);
        Seasonality.aasX.add((1136 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((226 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Blueberries, this));
        Seasonality.aaX.add(953);
        Seasonality.aaY.add(200);
        Seasonality.aasX.add((1050 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((255 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Raspberries, this));
        Seasonality.aaX.add(1046);
        Seasonality.aaY.add(260);
        Seasonality.aasX.add((1160 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((327 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Carrots, this));
        Seasonality.aaX.add(0);
        Seasonality.aaY.add(572);
        Seasonality.aasX.add((128 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((663 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Pumpkins, this));
        Seasonality.aaX.add(220);
        Seasonality.aaY.add(588);
        Seasonality.aasX.add((313 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((685 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Radishes, this));
        Seasonality.aaX.add(476);
        Seasonality.aaY.add(502);
        Seasonality.aasX.add((650 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((640 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Strawberries, this));
        Seasonality.aaX.add(821);
        Seasonality.aaY.add(520);
        Seasonality.aasX.add((896 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((618 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Eggplant, this));
        Seasonality.aaX.add(1012);
        Seasonality.aaY.add(492);
        Seasonality.aasX.add((1121 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((600 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Tomatoes, this));
        Seasonality.aaX.add(153);
        Seasonality.aaY.add(749);
        Seasonality.aasX.add((240 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((820 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Sweet_Potatoes, this));
        Seasonality.aaX.add(476);
        Seasonality.aaY.add(665);
        Seasonality.aasX.add((605 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((757 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Asparagus, this));
        Seasonality.aaX.add(468);
        Seasonality.aaY.add(772);
        Seasonality.aasX.add((611 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((868 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Corn, this));
        Seasonality.aaX.add(820);
        Seasonality.aaY.add(650);
        Seasonality.aasX.add((963 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((744 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);

        Seasonality.aa.add(new ActionArea(Crops.Swiss_Chard, this));
        Seasonality.aaX.add(865);
        Seasonality.aaY.add(741);
        Seasonality.aasX.add((960 - Seasonality.aaX.get(Seasonality.aaX.size() - 1)));
        Seasonality.aasY.add((860 - Seasonality.aaY.get(Seasonality.aaY.size() - 1)));
        Seasonality.aa.get(Seasonality.aa.size() - 1).addListener(Seasonality.mbi);
    }

    public synchronized void startGame(double mins) {
        stopGame();
        if(mins!=0){
            run = true;
            Seasonality.timeLeft = (long) (mins * 60);
            countDown = new Thread(this, "Countdown");
            countDown.start();
        }
        Seasonality.mmp.setVisible(false);
    }

    public synchronized void stopGame() {
        Seasonality.timeLeft = 0;
        run = false;
        for (int i = 0; i < Seasonality.pointTaken.length; i++) {
            Seasonality.pointTaken[i] = false;
            Seasonality.clicked[i] = false;
        }
        Seasonality.score = 0;
        Seasonality.es.setVisible(false);
        Seasonality.mmp.setVisible(true);
        Seasonality.s.render();
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
        System.out.println("Game Ended");
        Seasonality.gp.setVisible(false);
        Seasonality.es.setVisible(true);
        Seasonality.pickedup = -1;
        Seasonality.s.render();
    }

    BufferedImage stand;

    public void render(Graphics g) {

        if (stand == null) {
            stand = new assets.LoadArt().createBufferedImage("stand.jpg", Seasonality.s.getWidth(), Seasonality.s.getHeight());
        }

        g.drawImage(stand, 0, 0, this);

        g.setColor(Color.BLACK);
        g.fillRect((int) (Seasonality.s.getHeight() * (30.0 / 1080.0)), (int) (Seasonality.s.getHeight() * (15.0 / 1080.0)), (int) (Seasonality.s.getHeight() * (100.0 / 1080.0)), (int) (Seasonality.s.getHeight() * (50.0 / 1080.0)));
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, (int) (Seasonality.s.getHeight() * (50.0 / 1080.0))));
        if ((timeLeft - ((timeLeft / 60) * 60)) >= 10) {
            g.drawString((timeLeft / 60) + ":" + (timeLeft - ((timeLeft / 60) * 60)), (int) (Seasonality.s.getHeight() * (30.0 / 1080.0)), (int) (Seasonality.s.getHeight() * (60.0 / 1080.0)));
        } else {
            g.drawString((timeLeft / 60) + ":0" + (timeLeft - ((timeLeft / 60) * 60)), (int) (Seasonality.s.getHeight() * (30.0 / 1080.0)), (int) (Seasonality.s.getHeight() * (60.0 / 1080.0)));
        }

        g.setColor(Color.BLACK);
        g.fillRect((int) (Seasonality.s.getHeight() * (30.0 / 1080.0)), (int) (Seasonality.s.getHeight() * (75.0 / 1080.0)), g.getFontMetrics().stringWidth("Score: " + score), (int) (Seasonality.s.getHeight() * (52.0 / 1080.0)));
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, (int) (Seasonality.s.getHeight() * (30.0 / 1080.0)), (int) (Seasonality.s.getHeight() * (120.0 / 1080.0)));
    }

}
