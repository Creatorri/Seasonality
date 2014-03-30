
package seasonality;

import assets.LoadArt;
import input.ActionArea;
import input.ButtonInput;
import input.MButton;
import input.MButtonInput;
import input.MouseInput;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import ui.Gameplay;
import ui.MainMenuPanel;
import ui.StartupOptions;

/**
 *
 * @author Torri
 */
public class Seasonality extends JFrame{
    //Panels
    public static Seasonality s;
    public static StartupOptions o;
    public static MainMenuPanel mmp;
    public static Gameplay gp;
    public static ButtonInput bi = new ButtonInput();
    public static MouseInput mi = new MouseInput();
    public static MButtonInput mbi = new MButtonInput();
    //MButtons
    public static ArrayList<MButton> buttons = new ArrayList<>();
    public static ArrayList<Double> placeX = new ArrayList<>();
    public static ArrayList<Double> placeY = new ArrayList<>();
    public static ArrayList<Double> sizeX = new ArrayList<>();
    public static ArrayList<Double> sizeY = new ArrayList<>();
    //Action Areas
    public static ArrayList<ActionArea> aa = new ArrayList<>();
    public static ArrayList<Double> aaX = new ArrayList<>();
    public static ArrayList<Double> aaY = new ArrayList<>();
    public static ArrayList<Double> aasX = new ArrayList<>();
    public static ArrayList<Double> aasY = new ArrayList<>();
    //Update Stuff
    public static int w=0;
    public static int h=0;
    //Count Down
    public static long timeLeft = 5*(60000);
    //Crops Clicked
    public static boolean[] clicked = new boolean[Crops.values().length];
    public static boolean update = false,resetPaint = false;
    //Score
    public static int score = 0;
    //Private Time Stuff
    private String[] timeo = new String[2];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        s = new Seasonality();
    }
    public Seasonality(){
        super("Seasonality");
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        setIconImage(new LoadArt().createBufferedImage("Favicon.jpg"));
        setResizable(false);
        addMouseListener(mi);
        o=new StartupOptions();
        o.setVisible(true);
        add(o);
        o.updateUI();
        mmp=new MainMenuPanel();
        mmp.setVisible(false);
        add(mmp);
        gp=new Gameplay();
        gp.setVisible(false);
        add(gp);
    }
    public void fullScreen(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.getDefaultScreenDevice().setFullScreenWindow(s);
    }
    public void paint(Graphics g){
//        super.paint(g);
        if(s==null) return;
        if(gp!=null && gp.isVisible()){
            String[] time = new SimpleDateFormat("m:ss").format(Date.from(Instant.ofEpochMilli(timeLeft))).split(":");
            if(time[1] == null ? timeo[1] == null : !time[0].equals(timeo[1])){
                g.setColor(Color.BLACK);
                g.fillRect(30, 15, 100, 50);
                g.setColor(Color.WHITE);
                g.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,50));
                g.drawString(time[0]+":"+time[1], 30, 60);
                timeo=time;
            }
            if(resetPaint){
                g.drawImage(new assets.LoadArt().createBufferedImage("stand.jpg", getWidth(), getHeight()), 0, 0, this);
                for(MButton m : Seasonality.buttons){
                    if(m.name.equalsIgnoreCase("Pick Up") | m.name.equalsIgnoreCase("Put Back")) m.setVisible(false);
                }
                resetPaint=false;
                update=false;
            }
        }
        if(getWidth()==0 | getHeight()==0 | !isResizable() | o.isVisible() | w==getWidth() | h==getHeight()) return;
        w=getWidth();
        h=getHeight();
        if(mmp.isVisible()){
            g.drawImage(new assets.LoadArt().createBufferedImage("MMB.jpg", getWidth(), getHeight()), 0, 0, this);
            g.drawImage(new assets.LoadArt().createBufferedImage("Logo.png", (int) (0.3*getWidth()*(233/120)), (int) (0.3*getHeight())), (int) ((0.5*getWidth())-(0.3*getWidth()*0.5)), 50, this);
        }
        if(gp.isVisible()){
            g.drawImage(new assets.LoadArt().createBufferedImage("stand.jpg", getWidth(), getHeight()), 0, 0, this);
            if(update){
                g.drawImage(new assets.LoadArt().createBufferedImage("InfoPanel.png", (int) (0.5*getWidth()), (int) (0.5*getHeight())), (int) (0.25*getWidth()), (int) (0.25*getHeight()), this);
            }
        }
        for(int i=0;i<buttons.size();i++){
            if(buttons.get(i)==null | !buttons.get(i).parent.isVisible() || !buttons.get(i).visible) continue;
            try{
                buttons.get(i).setPos((int) ((placeX.get(i)*getWidth())-(0.5*sizeX.get(i)*getWidth())), (int) ((placeY.get(i)*getHeight())-(0.5*sizeY.get(i)*getHeight())), (int) (sizeX.get(i)*getWidth()), (int) (sizeY.get(i)*getHeight()));
                buttons.get(i).addListener(mbi);
                g.drawImage(buttons.get(i).img, buttons.get(i).x, buttons.get(i).y, this);
            }catch(Exception e){}
        }
        for(int i=0;i<aa.size();i++){
            Seasonality.aa.get(i).setPos((int) (Seasonality.aaX.get(i)*Seasonality.s.getWidth()), (int) (Seasonality.aaY.get(i)*Seasonality.s.getHeight()), (int) (Seasonality.aasX.get(i)*Seasonality.s.getWidth()), (int) (Seasonality.aasY.get(i)*Seasonality.s.getHeight()));
        }
        g.dispose();
    }
}
