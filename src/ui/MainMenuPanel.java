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
        Seasonality.buttons.add(new MButton("Play Seasonality", this));
        Seasonality.placeX.add(0.5);
        Seasonality.placeY.add(0.45);
        Seasonality.sizeX.add(0.2);
        Seasonality.sizeY.add(0.1);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);

        Seasonality.buttons.add(new MButton("Learn", this));
        Seasonality.placeX.add(0.5);
        Seasonality.placeY.add(0.55);
        Seasonality.sizeX.add(0.2);
        Seasonality.sizeY.add(0.1);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);
        
        Seasonality.buttons.add(new MButton("Edit Settings", this));
        Seasonality.placeX.add(0.5);
        Seasonality.placeY.add(0.65);
        Seasonality.sizeX.add(0.2);
        Seasonality.sizeY.add(0.1);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);
    }

    public BufferedImage mmb;

    public void render(Graphics g) {
        if (mmb == null) {
            mmb = new assets.LoadArt().createBufferedImage("MMB.jpg", Seasonality.s.getWidth(), Seasonality.s.getHeight());
        }
        g.drawImage(mmb, 0, 0, this);
    }

}
