package controllers;

import models.Model;
import views.View;

import java.awt.*;
import java.util.Vector;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/8/2016.
 */
public class EnemyController extends Controller{

    private static final int SPEED = 1;
    private int timeCounter;

    private Vector<BulletEnemyController> bulletEnemyControllerVector = new Vector<>();
    private BulletEnemyController bulletEnemyController = BulletEnemyController.create(this.model.getMidX() - 15, this.model.getMidY());

    public EnemyController(Model model, View view) {
        super(model, view);
        timeCounter = 0;
    }

    public void run() {

        this.model.move(0, SPEED);

        timeCounter++;
        if(timeCounter > 30) {
            addBullet();
            timeCounter = 0;
        }

        for (BulletEnemyController bulletEnemyController : bulletEnemyControllerVector) {
            bulletEnemyController.run();
        }
    }

    public void draw(Graphics g) {
        super.draw(g);
        for (BulletEnemyController bulletEnemyController : bulletEnemyControllerVector) {
            bulletEnemyController.draw(g);
        }
    }

    private void addBullet() {
        bulletEnemyController =  BulletEnemyController.create(this.model.getMidX() - 15, this.model.getMidY());
        bulletEnemyControllerVector.add(bulletEnemyController);
    }

    public static EnemyController create(int x, int y) {
        return new EnemyController(new Model(x, y, 30, 30), new View(loadImage("resources/plane1.png")));
    }
}
