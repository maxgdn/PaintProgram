package paint.tools;

import paint.MainFrame;
import paint.Tool;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Max on 5/3/2015.
 */
public class Pencil implements Tool {
    private final Integer size = 3;

    @Override
    public void leftClick(MouseEvent event) {
        int size = MainFrame.getInstance().getToolPanel().getBrushSize();
        Graphics2D graphics = (Graphics2D) MainFrame.getInstance().getDrawPanel().getImage().getGraphics();
        graphics.setColor(MainFrame.getInstance().getColorPanel().getColorChooser().getColor());
        graphics.fillRect(event.getX()  - size / 2, event.getY()  - size / 2, size, size);
    }

    @Override
    public void rightClick(MouseEvent event) {

    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
