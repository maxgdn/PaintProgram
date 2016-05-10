package paint;

import java.awt.event.MouseEvent;

/**
 * Created by Max on 5/3/2015.
 */
public interface Tool {
    public void leftClick(MouseEvent event);
    public void rightClick(MouseEvent event);
    public void undo();
    public void redo();
}
