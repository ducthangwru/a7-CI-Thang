package controllers;

import models.Model;
import views.View;

import java.util.Vector;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/8/2016.
 */
public class PlaneEnemyController extends Controller{

    private Vector<BulletEnemyController> bulletEnemyControllerVector;

    public PlaneEnemyController(Model model, View view) {
        super(model, view);
    }
    public void run() {
        this.model.move(0, 1);
    }

    private void addBullet() {
        BulletEnemyController bulletEnemyController = new BulletEnemyController.createBulletEnemyController(this.model.getX(), this.model.getY());
    }
    public static PlaneEnemyController createEnemyController(int x, int y) {
        return new PlaneEnemyController(new Model(x, y, 50, 50), new View(loadImage("resources/enemy_plane_white_3.png")));
    }
}
