package models;

/**
 * Created by DUC THANG on 12/4/2016.
 */
public class BulletModel {
    private int x = 350;
    private int y = 400;

    public BulletModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
