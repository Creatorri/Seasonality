package ui;

import input.MButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;
import seasonality.Crops;
import seasonality.Seasonality;

/**
 *
 * @author Creatorri
 */
public class EndScreen extends JPanel {
    
    public EndScreen(){
        setVisible(false);
        Seasonality.buttons.add(new MButton("Back To Menu", this));
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
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 50));
        FontMetrics fm = g.getFontMetrics();
        
        g.fillRect(60, 200 + 10, fm.stringWidth("Game Over! You scored: " + Seasonality.score + " Points"), 2 * 50);
        g.setColor(Color.WHITE);
        g.drawString("Game Over! You scored: " + Seasonality.score + " Points", 60, 250);
        g.drawString("out of a maximum of " + Crops.maxScore(), 60, 300);
    }

}
