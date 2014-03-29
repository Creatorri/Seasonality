
package ui;

import input.ActionArea;
import input.MButton;
import javax.swing.JPanel;
import seasonality.Crops;
import seasonality.Seasonality;

/**
 *
 * @author Torri
 */
public class Gameplay extends JPanel{
    public Thread countDown = new Thread("Countdown"){
        public void run(){
            while(Seasonality.timeLeft>0){
                Seasonality.timeLeft--;
                Seasonality.s.repaint();
                try {sleep(1);} catch (InterruptedException ex) {}
            }
            Seasonality.gp.setVisible(false);
            Seasonality.mmp.setVisible(true);
            Seasonality.w=0;
            Seasonality.h=0;
            Seasonality.s.repaint();
        }
    };
    public Gameplay(){
        Seasonality.buttons.add(new MButton(750/2,10,100,50,"Back To Menu",this));
        Seasonality.placeX.add(0.9);
        Seasonality.placeY.add(0.95);
        Seasonality.sizeX.add(0.2);
        Seasonality.sizeY.add(0.1);
        
        Seasonality.aa.add(new ActionArea(1,1,1,1,Crops.Beans.toString(),this));
        Seasonality.aaX.add(.37604166666666666);
        Seasonality.aaY.add(.43148148148148147);
        Seasonality.aasX.add(.5458333333333333-.37604166666666666);
        Seasonality.aasY.add(.6851851851851852-.43148148148148147);
        Seasonality.aa.get(Seasonality.aa.size()-1).addListener(Seasonality.mbi);
    }
    public void startGame(double mins){
        try{
            countDown.interrupt();
            countDown.join();
        }catch(InterruptedException e){}
        Seasonality.timeLeft = (long) (mins*60000);
        countDown = new Thread("Countdown"){
            public void run(){
                while(Seasonality.timeLeft>0){
                    Seasonality.timeLeft--;
                    Seasonality.s.repaint();
                    try {sleep(1);} catch (InterruptedException ex) {}
                }
                Seasonality.gp.setVisible(false);
                Seasonality.mmp.setVisible(true);
                Seasonality.w=0;
                Seasonality.h=0;
                Seasonality.s.repaint();
            }
        };
        countDown.start();
    }
}
