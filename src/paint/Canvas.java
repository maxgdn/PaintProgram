package paint;

import java.awt.*;

/**
 * Created by Max on 5/3/2015.
 */
public class Canvas {
    private final Color[][] pixels;

    public Canvas(int width, int height) {
        this.pixels = new Color[width][height];
    }

    public Color[][] getPixels() {
        return pixels;
    }
}
