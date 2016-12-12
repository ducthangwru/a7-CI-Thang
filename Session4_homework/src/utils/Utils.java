package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by DUC THANG on 12/11/2016.
 */
public class Utils {
    private static int timeCounter;

    public Utils() {
        timeCounter = 0;
    }

    public static Image loadImage(String path) {
        try {
            Image image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            System.out.println("Load Image Failed!!!");
            e.printStackTrace();
        }
        return null;
    }

    public static int getTimeCounter() {
        timeCounter++;
        return timeCounter;
    }

    public static void setTimeCounter(int x) {
        timeCounter = x;
    }
}
