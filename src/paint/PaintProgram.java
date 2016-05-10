package paint;


import java.awt.*;
import java.util.ArrayList;


/**
 * Created by Max on 3/11/2015.
 */
public class PaintProgram {
    private static final ArrayList<MainFrame> mainFrames = new ArrayList<MainFrame>();

    public static void main(String[] args) {
        createMainFrame();
    }

    /**
     * Makes a new MainFrame.
     */
    private static void createMainFrame() {

        Toolkit tk = Toolkit.getDefaultToolkit();
        int winWidth = ((int) tk.getScreenSize().getWidth());
        int winHeight = ((int) tk.getScreenSize().getHeight());
        MainFrame mainFrame = new MainFrame(new Dimension(winWidth, winHeight));
        mainFrames.add(mainFrame);



        // Human-readable frame number
        int frameNumber = mainFrames.indexOf(mainFrame) + 1;
        mainFrame.setTitle("Paint Program #" + frameNumber);
        //mainFrame.setTitle("Paint Program #");
        mainFrame.setVisible(true);
    }
}
