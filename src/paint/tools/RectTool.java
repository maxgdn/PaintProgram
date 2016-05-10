package paint.tools;

import paint.MainFrame;
import paint.Tool;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Max on 5/3/2015.
 */

public class RectTool implements Tool {

    private boolean point1Set = false;
    private int point1X;
    private int point1Y;

    @Override
    public void leftClick(MouseEvent event) {
        Graphics2D graphics = (Graphics2D) MainFrame.getInstance().getDrawPanel().getImage().getGraphics();
        if (!point1Set) {
            point1X = event.getX();
            point1Y = event.getY();
            point1Set = true;
        } else {
            int point2X = event.getX();
            int point2Y = event.getY();

            int leftPoint, rightPoint, topPoint, bottomPoint;

            if (point1X < point2X) {
                leftPoint = point1X;
                rightPoint = point2X;
            } else {
                leftPoint = point2X;
                rightPoint = point1X;
            }

            if (point1Y < point2Y) {
                topPoint = point1Y;
                bottomPoint = point2Y;
            } else {
                topPoint = point2Y;
                bottomPoint = point1Y;
            }

            graphics.setColor(MainFrame.getInstance().getColorPanel().getColorChooser().getColor());
            //graphics.setStroke(new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            if (MainFrame.getInstance().getToolPanel().getFillIsTrue()) {
                graphics.fillRect(leftPoint, topPoint, rightPoint - leftPoint, bottomPoint - topPoint);
            } else {
                graphics.drawRect(leftPoint, topPoint, rightPoint - leftPoint, bottomPoint - topPoint);
            }
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
