package ui;

import input.MButton;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import seasonality.Seasonality;
import static seasonality.Seasonality.aa;
import static seasonality.Seasonality.aaX;
import static seasonality.Seasonality.aaY;
import static seasonality.Seasonality.aasX;
import static seasonality.Seasonality.aasY;
import static seasonality.Seasonality.buttons;
import static seasonality.Seasonality.placeX;
import static seasonality.Seasonality.placeY;
import static seasonality.Seasonality.sizeX;
import static seasonality.Seasonality.sizeY;
import static seasonality.Seasonality.xMult;
import static seasonality.Seasonality.yMult;

/**
 *
 * @author Torri
 */
public class MainMenuPanel extends JPanel {

    public MainMenuPanel() {
        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Play Normal Mode", this));
        Seasonality.placeX.add(0.5);
        Seasonality.placeY.add(0.45);
        Seasonality.sizeX.add(0.2);
        Seasonality.sizeY.add(0.1);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);

//        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Play Easy Mode", this));
//        Seasonality.placeX.add(0.5);
//        Seasonality.placeY.add(0.55);
//        Seasonality.sizeX.add(0.2);
//        Seasonality.sizeY.add(0.1);
//        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
//        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);
        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Quit", this));
        Seasonality.placeX.add(0.5);
        Seasonality.placeY.add(0.65);
        Seasonality.sizeX.add(0.2);
        Seasonality.sizeY.add(0.1);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);
    }

    BufferedImage mmb;

    public void render(Graphics g) {
        if (mmb == null) {
            mmb = new assets.LoadArt().createBufferedImage("MMB.jpg", Seasonality.s.getWidth(), Seasonality.s.getHeight());
        }
        g.drawImage(mmb, 0, 0, this);
        if (Seasonality.renders < 3) {
            for (int i = 0; i < aa.size(); i++) {
                aa.get(i).setPos((int) (aaX.get(i) * xMult), (int) (aaY.get(i) * yMult), (int) (aasX.get(i) * xMult), (int) (aasY.get(i) * yMult));
                aa.get(i).data.resizeImage((int) (aasX.get(i) * xMult), (int) (aasY.get(i) * yMult));
            }
            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).setPos((int) ((placeX.get(i) * Seasonality.s.getWidth()) - (0.5 * sizeX.get(i) * Seasonality.s.getWidth())), (int) ((placeY.get(i) * Seasonality.s.getHeight()) - (0.5 * sizeY.get(i) * Seasonality.s.getHeight())), (int) (sizeX.get(i) * Seasonality.s.getWidth()), (int) (sizeY.get(i) * Seasonality.s.getHeight()));
            }
        }
    }

}
