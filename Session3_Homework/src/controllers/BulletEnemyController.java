package controllers;

import models.Model;
import views.View;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/8/2016.
 */
public class BulletEnemyController extends Controller{

    public BulletEnemyController(Model model, View view) {
        super(model, view);
    }

    public void run() {
        this.model.move(0, 5);
    }

    public static BulletEnemyController createBulletEnemyController(int x, int y) {
        return new BulletEnemyController(new Model(x, y, 32, 32), new View(loadImage("resources/enemy_bullet.png")));
    }
}
