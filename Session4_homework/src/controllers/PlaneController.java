package controllers;

import models.Model;
import views.View;

import java.awt.event.KeyEvent;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/11/2016.
 */

public class PlaneController extends Controller {
    private static final int SPEED = 5;
    private KeySetting keySetting;

    public PlaneController(Model model, View view) {
        super(model, view);
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
}
