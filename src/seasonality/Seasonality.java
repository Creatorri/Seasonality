package seasonality;

import assets.LoadArt;
import input.ActionArea;
import input.ButtonInput;
import input.MButton;
import input.MButtonInput;
import input.MouseInput;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import ui.EndScreen;
import ui.Gameplay;
import ui.MainMenuPanel;
import ui.StartupOptions;

/**
 *
 * @author Torri
 */
public class Seasonality extends JFrame {

    //Panels
    public static Seasonality s;
    public static StartupOptions o;
    public static MainMenuPanel mmp;
    public static Gameplay gp;
    public static EndScreen es;
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
    public static ArrayList<Integer> aaX = new ArrayList<>();
    public static ArrayList<Integer> aaY = new ArrayList<>();
    public static ArrayList<Integer> aasX = new ArrayList<>();
    public static ArrayList<Integer> aasY = new ArrayList<>();
    //Count Down
    public static long timeLeft = 5 * (60000);
    //Crops Clicked
    public static boolean[] clicked = new boolean[Crops.values().length];
    public static int pickedup = -1;
    public static boolean[] pointTaken = new boolean[Crops.values().length];
    public static boolean update = false, resetPaint = false;
    //Score
    public static int score = 0;
    //Mode
    public static final int LEARN_MODE = 0;
    public static final int PLAY_MODE = 1;
    public static int mode = 0;
    //Reder Points
    public static double xMult = 1920.0 / 1174.0;
    public static double yMult = 1080.0 / 868.0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        s = new Seasonality();
    }

    public Seasonality() {
        super("Seasonality");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        setIconImage(new LoadArt().createBufferedImage("Favicon.jpg"));
        setResizable(false);
        addMouseListener(mi);
        addMouseMotionListener(mi);
        setVisible(true);
        //Inits and Adds
        o = new StartupOptions();
        o.setVisible(true);
        add(o);
        o.done.setEnabled(false);
        o.updateUI();
        mmp = new MainMenuPanel();
        mmp.setVisible(false);
        add(mmp);
        gp = new Gameplay();
        gp.setVisible(false);
        add(gp);
        es = new EndScreen();
        //Allows User To Continue
        o.done.setEnabled(true);
    }
    
    public void buttonSize(){
        for (int i = 0; i < aa.size(); i++) {
            aa.get(i).setPos((int) (aaX.get(i) * xMult), (int) (aaY.get(i) * yMult), (int) (aasX.get(i) * xMult), (int) (aasY.get(i) * yMult));
            aa.get(i).data.resizeImage((int) (aasX.get(i) * xMult), (int) (aasY.get(i) * yMult));
        }
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setPos((int) ((placeX.get(i) * Seasonality.s.getWidth()) - (0.5 * sizeX.get(i) * Seasonality.s.getWidth())), (int) ((placeY.get(i) * Seasonality.s.getHeight()) - (0.5 * sizeY.get(i) * Seasonality.s.getHeight())), (int) (sizeX.get(i) * Seasonality.s.getWidth()), (int) (sizeY.get(i) * Seasonality.s.getHeight()));
        }
    }

    public void fullScreen() {
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(s);
        render();
        buttonSize();
    }

    public void render() {

//        long start = System.nanoTime();
        xMult = getWidth() / 1174.0;
        yMult = getHeight() / 868.0;

        if (o.isVisible()) {
            return;
        }

        this.setFocusable(true);

        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        if (mmp.isVisible()) {
            mmp.render(g);
            es.setVisible(false);
        } else if (gp.isVisible()) {
            gp.render(g);
        } else if (es.isVisible()) {
            es.render(g);
        }

        updateButtons(g, gp.isVisible());

        renderCrops(g);

        g.dispose();
        bs.show();

//        System.out.println("That update took " + (System.nanoTime() - start) / (1.0E9) + " seconds.");
    }

    /**
     * updates both buttons and action areas if everything is true, else just
     * buttons
     *
     * @param g
     * @param everything
     */
    public void updateButtons(Graphics g, boolean everything) {

        for (MButton button : buttons) {
            if (button.parent.isVisible() && button.visible) {
                g.drawImage(button.img, button.x, button.y, this);
            }
        }

        if (everything) {
            for (ActionArea aa1 : aa) {
                if (pointTaken[aa1.data.ordinal()]) {
                    g.drawImage(aa1.img, aa1.x, aa1.y, this);
                }
            }
        }
    }

    public void paint(Graphics g) {
        if (s == null) {
            return;
        }
        render();
        g.dispose();
    }

    public static void doScoreOp() {
        if (Crops.values()[pickedup].forceSeason == 2) {
            score++;
        } else if (Crops.values()[pickedup].forceSeason == 3) {
            score = score - 2;
        } else if(Crops.values()[pickedup].inSeason((double) Calendar.getInstance().get(Calendar.MONTH)) && Crops.values()[pickedup].forceSeason != 1){
            score++;
        } else {
            score--;
        }
        pointTaken[pickedup] = true;
        pickedup = -1;
    }

    private void renderCrops(Graphics g) {
        if (gp.isVisible() && mode == PLAY_MODE) {
            if (this.isVisible() && pickedup > -1) {
                try{
                    g.drawImage(Crops.values()[pickedup].image, mi.dmx - Crops.values()[pickedup].image.getWidth() / 2, mi.dmy - Crops.values()[pickedup].image.getHeight() / 2, this);
                }catch(ArrayIndexOutOfBoundsException e){
                }
            }
        }
    }

}
