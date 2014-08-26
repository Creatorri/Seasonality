package ui;

import input.MButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;
import seasonality.Crops;
import seasonality.Seasonality;
import static seasonality.Seasonality.pointTaken;

/**
 *
 * @author Creatorri
 */
public class EndScreen extends JPanel {
    
    public EndScreen(){
        setVisible(false);
        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Back To Menu", this));
        Seasonality.placeX.add(0.5);
        Seasonality.placeY.add(0.9);
        Seasonality.sizeX.add(0.2);
        Seasonality.sizeY.add(0.1);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);
    }

    public void render(Graphics g) {
        g.drawImage(Seasonality.mmp.mmb, 0, 0, this);

        g.setColor(Color.BLUE);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, (int) (Seasonality.s.getHeight() * (50.0 / 1080.0))));
        FontMetrics fm = g.getFontMetrics();
        
        g.fillRect(60, 40 - (int) (Seasonality.s.getHeight() * (50.0 / 1080.0)), fm.stringWidth("Game Over! You Clicked:"), (int) (Seasonality.s.getHeight() * (50.0 / 1080.0)));
        g.setColor(Color.WHITE);
        g.drawString("Game Over! You Clicked:", 60, 40);

        int j = 0;
        int k = 0;

        for (int i = 0; i < pointTaken.length; i++) {
            if (pointTaken[i]) {
                g.setColor(Color.BLACK);
                if (40 + (int) (Seasonality.s.getHeight() * j * (50.0 / 1080.0)) < Seasonality.s.getHeight() - 40) {
                    g.fillRect(60, 40 + (int) (Seasonality.s.getHeight() * (50.0 / 1080.0)) + (int) (Seasonality.s.getHeight() * j * (50.0 / 1080.0)) - (int) (Seasonality.s.getHeight() * (50.0 / 1080.0)), fm.stringWidth(Crops.values()[i].toString()), (int) (Seasonality.s.getHeight() * (50.0 / 1080.0)));
                    g.setColor(Color.WHITE);
                    g.drawString(Crops.values()[i].toString(), 60, 40 + (int) (Seasonality.s.getHeight() * (50.0 / 1080.0)) + (int) (Seasonality.s.getHeight() * j * (50.0 / 1080.0)));
                    j++;
                } else if (40 + (int) (Seasonality.s.getHeight() * k * (50.0 / 1080.0)) < Seasonality.s.getHeight() - 40) {
                    g.fillRect(800, 40 + (int) (Seasonality.s.getHeight() * k * (50.0 / 1080.0)) - (int) (Seasonality.s.getHeight() * (50.0 / 1080.0)), fm.stringWidth(Crops.values()[i].toString()), (int) (Seasonality.s.getHeight() * (50.0 / 1080.0)));
                    g.setColor(Color.WHITE);
                    g.drawString(Crops.values()[i].toString(), 800, 40 + (int) (Seasonality.s.getHeight() * k * (50.0 / 1080.0)));
                    k++;
                }
            }
        }
    }

}
