package paint.panels;

import paint.MainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Max on 5/3/2015.
 */
public class ColorPanel extends JPanel {
    private final JColorChooser colorChooser;

    public ColorPanel(MainFrame mainFrame) {
        colorChooser = new JColorChooser();
        colorChooser.setColor(Color.BLACK);
        this.add(colorChooser);
    }

    public JColorChooser getColorChooser() {
        return colorChooser;
    }
}
