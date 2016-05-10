package paint.tools;

import paint.MainFrame;
import paint.Tool;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Max on 5/3/2015.
 */
public class TextTool implements Tool {

    @Override
    public void leftClick(MouseEvent event) {
        String currentText = MainFrame.getInstance().getToolPanel().getCurrentText();
        Font graphicFont = new Font("Arial", Font.PLAIN, MainFrame.getInstance().getToolPanel().getBrushSize());

        Graphics2D graphics = (Graphics2D) MainFrame.getInstance().getDrawPanel().getImage().getGraphics();
        graphics.setColor(MainFrame.getInstance().getColorPanel().getColorChooser().getColor());
        graphics.setFont(graphicFont);
        graphics.drawString(currentText, event.getX(), event.getY());
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
