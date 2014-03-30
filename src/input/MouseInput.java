
package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import seasonality.Seasonality;

/**
 *
 * @author Torri
 */
public class MouseInput implements MouseListener{
    public int mx;
    public int my;
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
        mx=e.getX();
        my=e.getY();
        for (ActionArea aa : Seasonality.aa) {
            if (!aa.parent.isVisible()) continue;
            if (aa.update(mx, my)) return;
        }
        for (MButton button : Seasonality.buttons) {
            if (!button.visible || !button.parent.isVisible()) continue;
            if (button.update(mx, my)) return;
        }
        System.out.println(((double) mx/(double) Seasonality.s.getWidth())+","+((double) my/(double) Seasonality.s.getHeight()));
    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        if(Seasonality.s!=null) Seasonality.s.repaint();
    }
    @Override
    public void mouseExited(MouseEvent e) {}
}