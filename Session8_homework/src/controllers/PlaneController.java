package controllers;

import controllers.enemies.BulletEnemyController;
import controllers.managers.BodyManager;
import controllers.managers.ControllerManager;
import models.Model;
import utils.Utils;
import views.SingerView;
import views.View;

import java.awt.*;
import java.awt.event.KeyEvent;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/16/2016.
 */

public class PlaneController extends Controller implements Body {
    private static final int SPEED = 5;
    public KeySetting keySetting;
    private ControllerManager bulletManager;
    public static final PlaneController instance = createPlane(300, 300);

    public PlaneController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
        bulletManager = new ControllerManager();
    }

    public void keyPressed(KeyEvent e) {
        if (keySetting != null) {
            int keyCode = e.getKeyCode();
            if (keyCode == keySetting.keyUp) {
                model.move(0, -SPEED);
            } else if (keyCode == keySetting.keyDown) {
                model.move(0, SPEED);
            } else if (keyCode == keySetting.keyLeft) {
                model.move(-SPEED, 0);
            } else if (keyCode == keySetting.keyRight) {
                model.move(SPEED, 0);
            } else if (keyCode == keySetting.keyShoot) {
                shoot();
            }
        }
    }

    @Override
    public void run() {
        super.run();
        bulletManager.run();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    private void shoot() {
        Utils.playSound("resources/Jump3.wav", false);
        BulletController bulletController = BulletController.createBulletController(this.getModel().getMidX() - BulletController.WIDTH / 2, this.model.getY() - BulletController.HEIGHT);
        bulletManager.add(bulletController);
    }

    public static PlaneController createPlane(int x, int y) {
        return new PlaneController(new Model(x, y, 70, 50), new SingerView(loadImage("resources/plane3.png")));
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof BulletEnemyController) {
            System.out.println("trúng đạn địch");
            this.getModel().setAlive(false);
        }
    }
}
