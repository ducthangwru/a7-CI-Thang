package controllers;

import controllers.managers.BodyManager;
import models.Model;
import views.View;

import java.awt.*;
import java.util.Vector;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/11/2016.
 */
public class EnemyController extends Controller implements Body {

    private int speedY;
    private int speedX;

    private Vector<BulletEnemyController> bulletEnemyControllerVector = new Vector<>();
    private BulletEnemyController bulletEnemyController = BulletEnemyController.create(this.model.getMidX() - 15, this.model.getMidY());

    public EnemyController(Model model, View view) {
        super(model, view);
        this.speedX = 0;
        this.speedY = 0;
        BodyManager.instance.register(this);
    }

    public void run() {

        this.model.move(speedX, speedY);
        if(model.getTimeCounter() > 50) {
            addBullet();
            model.setTimeCounter(0);
        }

        for (BulletEnemyController bulletEnemyController : bulletEnemyControllerVector) {
            bulletEnemyController.run();
        }
    }

    public void moveDown() {
        speedX = 0;
        speedY = 1;
    }

    public void movePaddle() {
        speedX = -1;
        speedY = 1;
    }

    public void moveParabol() {

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

    public static EnemyController create(int x, int y, String path) {
        return new EnemyController(new Model(x, y, 30, 30), new View(loadImage(path)));
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof BulletController) {
            System.out.println("trúng đạn");
            this.getModel().setAlive(false);
        }
    }
}
