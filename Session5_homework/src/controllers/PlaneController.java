package controllers;

import controllers.managers.BodyManager;
import models.Model;
import views.View;

import java.awt.event.KeyEvent;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/16/2016.
 */

public class PlaneController extends Controller implements Body {
    private static final int SPEED = 5;
    private KeySetting keySetting;

    public PlaneController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void setKeySetting(KeySetting keySetting) {
        this.keySetting = keySetting;
    }

    public void keyPressed(KeyEvent e) {
        if(keySetting != null) {
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.getKeyUp()) {
                model.move(0, -SPEED);
            }
            else if(keyCode == keySetting.getKeyDown()) {
                model.move(0, SPEED);
            }
            else if(keyCode == keySetting.getKeyLeft()) {
                model.move(-SPEED, 0);
            }
            else if(keyCode == keySetting.getKeyRight()) {
                model.move(SPEED, 0);
            }
        }
    }

    public static PlaneController createPlane(int x, int y) {
        return new PlaneController(new Model(x, y, 70, 50), new View(loadImage("resources/plane3.png")));
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof BulletEnemyController) {
            System.out.println("trúng đạn địch");
            this.getModel().setAlive(false);
        }
    }
}
