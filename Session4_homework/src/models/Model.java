package models;

/**
 * Created by DUC THANG on 12/11/2016.
 */
public class Model {
    private int x;
    private int y;
    private int width;
    private int height;
    private int timeCounter;

    public Model(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        timeCounter = 0;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public int getMidX() {
        return this.x + width / 2;
    }

    public int getMidY() {
        return this.y + height;
    }

    public int getTimeCounter() {
        timeCounter++;
        return timeCounter;
    }

    public void setTimeCounter(int timeCounter) {
        this.timeCounter = timeCounter;
    }
}
