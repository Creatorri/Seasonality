
package input;

import java.awt.Component;

/**
 *
 * @author Torri
 */
public class ActionArea extends MButton{
    public ActionArea(int x1, int y1, int sx1, int sy1, String name1, Component parent1) {
        super(x1, y1, sx1, sy1, name1, parent1);
        img=null;
    }
    public void setPos(int x1,int y1,int sx1,int sy1){
        super.setPos(x1, y1, sx1, sy1);
        img=null;
    }
}
