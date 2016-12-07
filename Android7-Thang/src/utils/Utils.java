package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by DUC THANG on 12/7/2016.
 */
public class Utils {
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
}
