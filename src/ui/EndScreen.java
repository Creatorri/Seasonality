package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import seasonality.Crops;
import static seasonality.Seasonality.pointTaken;
import seasonality.Seasonality;

/**
 *
 * @author Creatorri
 */
public class EndScreen extends JPanel {

    public void render(Graphics g) {
        g.drawImage(new assets.LoadArt().createBufferedImage("MMB.jpg", Seasonality.s.getWidth(), Seasonality.s.getHeight()), 0, 0, this);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, (int) (Seasonality.s.getHeight() * (50.0 / 1080.0))));

        int j = 0;
        int k = 0;

        for (int i = 0; i < pointTaken.length; i++) {
            if (pointTaken[i]) {
                if (40 + (int) (Seasonality.s.getHeight() * j * (50.0 / 1080.0)) < Seasonality.s.getHeight()) {
                    g.drawString(Crops.values()[i].toString(), 60, 40 + (int) (Seasonality.s.getHeight() * j * (50.0 / 1080.0)));
                    j++;
                } else if (40 + (int) (Seasonality.s.getHeight() * k * (50.0 / 1080.0)) > Seasonality.s.getHeight()) {
                    g.drawString(Crops.values()[i].toString(), 800, 40 + (int) (Seasonality.s.getHeight() * j * (50.0 / 1080.0)));
                    k++;
                }
            }
        }
    }

}
