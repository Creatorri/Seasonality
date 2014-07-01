package input;

import java.awt.Component;
import java.util.Calendar;
import seasonality.Crops;
import seasonality.Seasonality;

/**
 * listener for MButtons
 *
 * @author Torri
 */
public class MButtonInput {

    public String lastCommand;

    public void clicked(String command, Component parent) throws Exception {
        if (lastCommand == null ? command == null : lastCommand.equals(command)) {
            return;
        }
        System.out.println("MBUTTON:" + command);
        lastCommand = command;
        if (parent == Seasonality.mmp) {
            if (command.equalsIgnoreCase("Play Normal Mode")) {
                Seasonality.mode = Seasonality.NORMAL_MODE;
                Seasonality.mmp.setVisible(false);
                Seasonality.gp.setVisible(true);
                Seasonality.gp.startGame(1);
                Seasonality.resetPaint = true;
                Seasonality.score = 0;
                Seasonality.s.render();
                return;
            }
            if (command.equalsIgnoreCase("Play Easy Mode")) {
                Seasonality.mode = Seasonality.EASY_MODE;
                Seasonality.mmp.setVisible(false);
                Seasonality.gp.setVisible(true);
                Seasonality.gp.startGame(3);
                Seasonality.resetPaint = true;
                Seasonality.score = 0;
                Seasonality.s.render();
                return;
            }
            if (command.equalsIgnoreCase("Quit")) {
                Seasonality.s.dispose();
                System.exit(0);
                return;
            }
        }
        if (parent == Seasonality.gp) {
            if (command.equalsIgnoreCase("Back To Menu")) {
                Seasonality.gp.stopGame();
                Seasonality.s.render();
                return;
            }
            if (command.equalsIgnoreCase("put back")) {
                Seasonality.pickedup = 0;
                Seasonality.resetPaint = true;
                return;
            }
            if (command.equalsIgnoreCase("Pick up")) {
                for (int i = 0; i < Seasonality.clicked.length; i++) {
                    if (Seasonality.clicked[i]) {
//                        Seasonality.clicked[i] = false;
//                        Seasonality.pointTaken[i] = true;
                        Seasonality.pickedup = i;
                        if (Crops.values()[i].inSeason((double) Calendar.getInstance().get(Calendar.MONTH))) {
                            Seasonality.score++;
                        } else {
                            Seasonality.score--;
                        }
                        break;
                    }
                }
                Seasonality.resetPaint = true;
                return;
            }
            for (int i = 0; i < Crops.values().length; i++) {
                if (Seasonality.pointTaken[i]) {
                    continue;
                }
                if (command.equalsIgnoreCase(Crops.values()[i].toString())) {
                    Seasonality.update = true;
                    if (Seasonality.mode == Seasonality.NORMAL_MODE) {
                        Seasonality.pickedup = i;
                        break;
                    }
                    for (MButton m : Seasonality.buttons) {
                        if (m.name.equalsIgnoreCase("Pick Up") || m.name.equalsIgnoreCase("Put Back")) {
                            m.setVisible(true);
                        }
                    }
                    break;
                }
            }
            return;
        }
        System.err.println("And this method (clicked(String)) was called for what reason?\n Non fatal error in MButtonInput.class: No corresponding action to button press \"" + command + "\"");
    }
}
