package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import seasonality.Seasonality;

/**
 *
 * @author Torri
 */
public class MouseInput implements MouseListener {

    public int mx;
    public int my;
    public boolean clicked;

    @Override
    public void mouseClicked(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        clicked = true;
        for (ActionArea aa : Seasonality.aa) {
            if(!clicked){
                return;
            }
            if (!aa.parent.isVisible()) {
                continue;
            }
            if (aa.update(mx, my)) {
                return;
            }
        }
        for (MButton button : Seasonality.buttons) {
            if(!clicked){
                return;
            }
            if (!button.visible || !button.parent.isVisible()) {
                continue;
            }
            if (button.update(mx, my)) {
                return;
            }
        }
//        System.out.println(((double) mx / (double) Seasonality.s.getWidth()) + "," + ((double) my / (double) Seasonality.s.getHeight()));
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (Seasonality.s != null) {
            try {
                Seasonality.s.render();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
