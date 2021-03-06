package input;

import assets.LoadArt;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Mouse Button
 *
 * @author Torri
 */
public class MButton {

    public BufferedImage img;
    public int x = 1;
    public int y = 1;
    public boolean visible = true;
    private boolean isListened = false;
    protected final LoadArt la = new LoadArt();
    private MButtonInput mbi;
    public int sx = 1;
    public int sy = 1;
    public final String name;
    private String data;
    public Component parent;

    /**
     * Makes a MButton
     *
     * @param name1 name
     * @param parent1
     */
    public MButton(String name1, Component parent1) {
        name = name1;
        parent = parent1;
        isListened = false;
    }

    public void setVisible(boolean show) {
        visible = show;
    }

    public void addListener(MButtonInput mbi1) {
        if (!isListened) {
            mbi = mbi1;
            isListened = true;
        }
    }

    public boolean update(int mx, int my) {
        boolean go = (mx > x + 8 && mx < x + sx && my > y && my < y + sy && parent.isVisible() && visible);
        if (go) {
            if (data != null) {
                try {
                    mbi.clicked(name + data, parent);
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
            if (data == null) {
                try {
                    mbi.clicked(name, parent);
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return go;
    }

    public void setPos(int x1, int y1, int sx1, int sy1) {
        if (sx == 0 || sy == 0) {
            return;
        }
        x = x1;
        y = y1;
        sx = sx1;
        sy = sy1;
        img = new BufferedImage(sx, sy, BufferedImage.TYPE_INT_ARGB);
        img = la.createBufferedImage("Button.png", sx, sy);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.PLAIN, sy / 2));
        FontMetrics fm = g.getFontMetrics(g.getFont());
        int width = fm.stringWidth(name);
        int div = 2;
        while (width > sx) {
            div++;
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, sy / div));
            fm = g.getFontMetrics(g.getFont());
            width = fm.stringWidth(name);
        }
        g.drawString(name, sx / 2 - width / 2, (sy / 2) + ((sy / div) / 2));
        g.dispose();
    }

    public void setData(String s) {
        data = s;
    }

}
