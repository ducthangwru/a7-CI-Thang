package controllers;

import models.Model;
import views.View;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/5/2016.
 */
public class BulletController extends Controller {

    public BulletController(Model model, View view) {
        super(model, view);
    }

    public void run() {
        this.model.move(0, -5);
    }

    public static BulletController createBulletController(int x, int y) {
        return new BulletController(new Model(x, y, 13, 33), new View(loadImage("resources/bullet.png")));
    }
}
