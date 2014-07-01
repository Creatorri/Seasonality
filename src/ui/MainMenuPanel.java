package ui;

import input.MButton;
import javax.swing.JPanel;
import seasonality.Seasonality;

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

        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Play Easy Mode", this));
        Seasonality.placeX.add(0.5);
        Seasonality.placeY.add(0.55);
        Seasonality.sizeX.add(0.2);
        Seasonality.sizeY.add(0.1);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);

        Seasonality.buttons.add(new MButton(750 / 2, 10, 100, 50, "Quit", this));
        Seasonality.placeX.add(0.5);
        Seasonality.placeY.add(0.65);
        Seasonality.sizeX.add(0.2);
        Seasonality.sizeY.add(0.1);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).setVisible(true);
        Seasonality.buttons.get(Seasonality.buttons.size() - 1).addListener(Seasonality.mbi);
    }

}
