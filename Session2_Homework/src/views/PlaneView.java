package views;

import models.PlaneModel;
import java.awt.*;

/**
 * Created by DUC THANG on 12/3/2016.
 */

public class PlaneView {
    private Image image;

    public PlaneView(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, PlaneModel planeModel) {
        g.drawImage(this.image, planeModel.getX(), planeModel.getY(), 70, 50, null);
    }
}
