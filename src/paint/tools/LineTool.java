package paint.tools;

import paint.MainFrame;
import paint.Tool;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Max on 5/3/2015.
 */

public class LineTool implements Tool {

    private boolean point1Set = false;
    private int point1X;
    private int point1Y;

    @Override
    public void leftClick(MouseEvent event) {
        int size = MainFrame.getInstance().getToolPanel().getBrushSize();
        Graphics2D graphics = (Graphics2D) MainFrame.getInstance().getDrawPanel().getImage().getGraphics();
        if (!point1Set) {
            point1X = event.getX();
            point1Y = event.getY();
            point1Set = true;
        } else {
            int point2X = event.getX();
            int point2Y = event.getY();

            graphics.setColor(MainFrame.getInstance().getColorPanel().getColorChooser().getColor());
            graphics.setStroke(new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            graphics.drawLine(point1X, point1Y, point2X, point2Y);
            point1Set = false;
        }
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
