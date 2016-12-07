package views;

import models.BulletModel;

import java.awt.*;

/**
 * Created by DUC THANG on 12/4/2016.
 */
public class BulletView {
    private Image image;

    public BulletView(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, BulletModel bulletModel) {
        g.drawImage(image, bulletModel.getX(), bulletModel.getY(), null);
    }
}
