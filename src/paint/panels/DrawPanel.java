package paint.panels;

import paint.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Max on 5/3/2015.
 */
public class DrawPanel extends JComponent {
    private Image image;
    private final MainFrame mainFrame;

    public DrawPanel(final MainFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;
        this.setPreferredSize(new Dimension(1040, 720));
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setDoubleBuffered(false);
    }


    public void init() {
        image = createImage(1040, 720);
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        clearImage();

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                super.mouseDragged(event);
                mainFrame.getToolPanel().getCurrentTool().leftClick(event);
            }

            @Override
            public void mouseClicked(MouseEvent event) {
                super.mouseClicked(event);
                mainFrame.getToolPanel().getCurrentTool().leftClick(event);
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainFrame.getToolPanel().getCurrentTool().leftClick(e);
            }
        });
    }


    public void clearImage() {
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setPaint(Color.WHITE);
        g2d.fillRect(0, 0, getSize().width, getSize().height);
        repaint();
    }



    @Override
    public void paintComponent(Graphics graphics) {
        if (image == null) init();
        graphics.drawImage(image, 0, 0, null);

//        for (int x = 0; x < 1040; x++) {
//            for (int y = 0; y < 720; y++) {
//                Color color = canvas.getPixels()[x][y];
//                if (color == null) color = Color.WHITE;
//                g2d.setColor(color);
//                g2d.drawRect(x, y, 1, 1);
//            }
//        }
//
//        g2d.dispose();
    }

//    public Canvas getCanvas() {
//        return canvas;
//    }



    public Image getImage() {
        return image;
    }
}
