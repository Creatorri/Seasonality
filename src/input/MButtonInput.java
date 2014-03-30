
package input;

import java.awt.Component;
import seasonality.Crops;
import seasonality.Seasonality;

/**
 * listener for MButtons
 * @author Torri
 */
public class MButtonInput {
//    public boolean backtogame;
    public void clicked(String command,Component parent){
//        System.out.println("MBUTTON:"+command);
        if(parent==Seasonality.mmp){
            if(command.equalsIgnoreCase("Start Game")){
                Seasonality.mmp.setVisible(false);
                Seasonality.gp.setVisible(true);
                Seasonality.gp.startGame(5);
                Seasonality.resetPaint=true;
                Seasonality.score=0;
                Seasonality.w=0;
                Seasonality.h=0;
                Seasonality.s.repaint();
            }
            if(command.equalsIgnoreCase("Quit")){
                Seasonality.s.dispose();
            }
        }
        if(parent==Seasonality.gp){
            if(command.equalsIgnoreCase("Back To Menu")){
                Seasonality.timeLeft=0;
                Seasonality.gp.countDown.interrupt();
                try {Seasonality.gp.countDown.join();} catch (InterruptedException ex) {}
                Seasonality.mmp.setVisible(true);
                Seasonality.gp.setVisible(false);
                Seasonality.w=0;
                Seasonality.h=0;
                Seasonality.s.repaint();
            }
            for(int i=0;i<Crops.values().length;i++){
                if(command.equalsIgnoreCase(Crops.values()[i].toString())){
                    Seasonality.clicked[i]=true;
                    Seasonality.update=true;
                    for(MButton m : Seasonality.buttons){
                        if(m.name.equalsIgnoreCase("Pick Up") | m.name.equalsIgnoreCase("Put Back")) m.setVisible(true);
                    }
                    Seasonality.w=0;
                    Seasonality.h=0;
                    Seasonality.s.repaint();
                }
            }
        }
    }
}
