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
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
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
    //Count Down
    public static long timeLeft = 5 * (60000);
    //Crops Clicked
    public static boolean[] clicked = new boolean[Crops.values().length];
    public static boolean[] pointTaken = new boolean[Crops.values().length];
    public static boolean update = false, resetPaint = false;
    //Score
    public static int score = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        s = new Seasonality();
    }

    public Seasonality() {
        super("Seasonality");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        setIconImage(new LoadArt().createBufferedImage("Favicon.jpg"));
        setResizable(false);
        addMouseListener(mi);
        o = new StartupOptions();
        o.setVisible(true);
        add(o);
        o.updateUI();
        mmp = new MainMenuPanel();
        mmp.setVisible(false);
        add(mmp);
        gp = new Gameplay();
        gp.setVisible(false);
        add(gp);
    }

    public void fullScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.getDefaultScreenDevice().setFullScreenWindow(s);
    }
    public BufferedImage img;

    public void render() {

        if (o.isVisible()) {
            return;
        }

        this.setFocusable(true);
        this.addMouseListener(mi);

        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        if (mmp.isVisible()) {
            g.drawImage(new assets.LoadArt().createBufferedImage("MMB.jpg", getWidth(), getHeight()), 0, 0, this);
            g.drawImage(new assets.LoadArt().createBufferedImage("Logo.png", (int) (0.3 * getWidth() * (233 / 120)), (int) (0.3 * getHeight())), (int) ((0.5 * getWidth()) - (0.3 * getWidth() * 0.5)), 50, this);
        }

        if (gp.isVisible()) {

            g.drawImage(new assets.LoadArt().createBufferedImage("stand.jpg", getWidth(), getHeight()), 0, 0, this);
            g.setColor(Color.BLACK);
            g.fillRect(30, 15, 100, 50);
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 50));
            if ((timeLeft - ((timeLeft / 60) * 60)) >= 10) {
                g.drawString((timeLeft / 60) + ":" + (timeLeft - ((timeLeft / 60) * 60)), 30, 60);
            }
            if ((timeLeft - ((timeLeft / 60) * 60)) < 10) {
                g.drawString((timeLeft / 60) + ":0" + (timeLeft - ((timeLeft / 60) * 60)), 30, 60);
            }

            g.setColor(Color.BLACK);
            g.fillRect(30, 75, g.getFontMetrics().stringWidth("Score: " + score), 50);
            g.setColor(Color.WHITE);
            g.drawString("Score: " + score, 30, 120);

            if (resetPaint) {
                for (MButton m : Seasonality.buttons) {
                    if (m.name.equalsIgnoreCase("Pick Up") | m.name.equalsIgnoreCase("Put Back")) {
                        m.setVisible(false);
                    }
                }
                resetPaint = false;
                update = false;
            }

            if (update) {
                g.drawImage(new assets.LoadArt().createBufferedImage("InfoPanel.png", (int) (0.5 * getWidth()), (int) (0.5 * getHeight())), (int) (0.25 * getWidth()), (int) (0.25 * getHeight()), this);
            }
        }

        for (int i = 0; i < aa.size(); i++) {
            aa.get(i).setPos((int) (aaX.get(i) * s.getWidth()), (int) (aaY.get(i) * s.getHeight()), (int) (aasX.get(i) * s.getWidth()), (int) (aasY.get(i) * s.getHeight()));
            if (pointTaken[i]) {
                g.drawImage(aa.get(i).img, aa.get(i).x, aa.get(i).y, this);
            }
        }

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i) == null | !buttons.get(i).parent.isVisible() || !buttons.get(i).visible) {
                continue;
            }
            buttons.get(i).setPos((int) ((placeX.get(i) * getWidth()) - (0.5 * sizeX.get(i) * getWidth())), (int) ((placeY.get(i) * getHeight()) - (0.5 * sizeY.get(i) * getHeight())), (int) (sizeX.get(i) * getWidth()), (int) (sizeY.get(i) * getHeight()));
            g.drawImage(buttons.get(i).img, buttons.get(i).x, buttons.get(i).y, this);
        }

        g.dispose();
        bs.show();
    }

    public void paint(Graphics g) {
        if (s == null) {
            return;
        }
        render();
        g.dispose();
    }
}
