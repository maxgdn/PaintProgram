package paint;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Max on 5/23/2015.
 */
public class Commands implements KeyListener {

    private boolean screenClear = true;

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == 40) {
            //screenClear = true;
            MainFrame.getInstance().getDrawPanel().clearImage();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_BACK_SPACE) {
            MainFrame.getInstance().getDrawPanel().clearImage();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 40) {
            MainFrame.getInstance().getDrawPanel().clearImage();
        }
    }

    public boolean isScreenClear() {
        return screenClear;
    }

    public void setScreenClear(boolean screenClear) {
        this.screenClear = screenClear;
    }


}
