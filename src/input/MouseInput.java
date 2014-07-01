package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import seasonality.Seasonality;

/**
 *
 * @author Torri
 */
public class MouseInput implements MouseListener, MouseMotionListener {

    public int mx;
    public int my;

    public int dmx;
    public int dmy;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        System.out.println(mx + "/" + Seasonality.s.getWidth() + " , " + my + "/" + Seasonality.s.getHeight());
        for (ActionArea aa : Seasonality.aa) {
            if (!aa.parent.isVisible()) {
                continue;
            }
            if (aa.update(mx, my)) {
                return;
            }
        }
        for (MButton button : Seasonality.buttons) {
            if (!button.visible || !button.parent.isVisible()) {
                continue;
            }
            if (button.update(mx, my)) {
                return;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (Seasonality.s != null) {
            Seasonality.s.render();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        dmx = -1;
        dmy = -1;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dmx = e.getX();
        dmy = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        dmx = e.getX();
        dmy = e.getY();
    }

}
