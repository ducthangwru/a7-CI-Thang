package controllers;

import models.Model;
import utils.Utils;
import views.View;

/**
 * Created by DUC THANG on 12/11/2016.
 */
public class BulletEnemyController extends Controller {
    private static final int SPEED = 3;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;

    public BulletEnemyController(Model model, View view) {
        super(model, view);
    }

    public void run() {
        model.move(0, SPEED);
    }

    public static BulletEnemyController create(int x, int y) {
        return new BulletEnemyController(new Model(x, y, WIDTH, HEIGHT), new View(Utils.loadImage("resources/enemy_bullet.png")));
    }
}
