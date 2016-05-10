package paint;

import net.miginfocom.swing.MigLayout;
import paint.panels.ColorPanel;
import paint.panels.DrawPanel;
import paint.panels.ToolPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Max on 3/11/2015.
 */
public class MainFrame extends JFrame {
    private static MainFrame instance;
    private ToolPanel toolPanel;
    private ColorPanel colorPanel;
    private DrawPanel drawPanel;
    private Commands commands;

    //static int BRDRSIZE = 200; not needed anymore
    public MainFrame(Dimension dimension) {
        instance = this;

        this.setSize(dimension);
        this.setLayout(new MigLayout());

        makePanels();
        commands = new Commands();



        final Timer timer = new Timer(0, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long startTime = System.currentTimeMillis();
                repaint();
                long elapsedTime = System.currentTimeMillis() - startTime;
                int delay = (int) (15 - elapsedTime);
                if (delay < 0) {
                    System.out.println("Took too long to paint!");
                    delay = 0;
                }
                timer.setDelay(delay);
            }
        });

        timer.start();
    }

    private void makePanels() {
        colorPanel = new ColorPanel(this);
        drawPanel = new DrawPanel(this);
        toolPanel = new ToolPanel(this);

        this.add(toolPanel, "wrap");
        this.add(colorPanel, "");
        this.add(drawPanel, "");

        drawPanel.addKeyListener(commands);
        toolPanel.addKeyListener(commands);
        colorPanel.addKeyListener(commands);


    }

    public ToolPanel getToolPanel() {
        return toolPanel;
    }

    public ColorPanel getColorPanel() {
        return colorPanel;
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public Commands getCommands() {
        return commands;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
    }


    public static MainFrame getInstance() {
        return instance;
    }
}