package controllers;

import controllers.managers.BodyManager;
import models.Model;
import views.View;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/11/2016.
 */
public class BulletController extends Controller implements Body {

    public BulletController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void run() {
        this.model.move(0, -5);
    }

    public static BulletController createBulletController(int x, int y) {
        return new BulletController(new Model(x, y, 13, 33), new View(loadImage("resources/bullet.png")));
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof EnemyController) {
            System.out.println("trúng máy bay");
            this.getModel().setAlive(false);
        }
    }
}
