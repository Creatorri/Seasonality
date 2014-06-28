package input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import seasonality.Seasonality;

/**
 *
 * @author Torri
 */
public class ButtonInput implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
//        System.out.println("JBUTTON:" + command);
        if (command.equalsIgnoreCase("Done/Continue To Game")) {
            Seasonality.o.setVisible(false);
            Seasonality.mmp.setVisible(true);
            Seasonality.s.setResizable(true);
            Seasonality.s.fullScreen();
            Seasonality.s.repaint();
        }
    }
}
