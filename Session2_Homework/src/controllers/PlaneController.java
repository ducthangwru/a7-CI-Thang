package controllers;

import models.PlaneModel;
import views.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by DUC THANG on 12/3/2016.
 */
public class PlaneController {
    private PlaneModel planeModel;
    private PlaneView planeView;
    private KeySetting keySetting;

    public PlaneController(PlaneModel planeModel, PlaneView planeView) {
        this.planeModel = planeModel;
        this.planeView = planeView;
    }

    public PlaneModel getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(PlaneModel planeModel) {
        this.planeModel = planeModel;
    }

    public PlaneView getPlaneView() {
        return planeView;
    }

    public void setPlaneView(PlaneView planeView) {
        this.planeView = planeView;
    }

    public KeySetting getKeySetting() {
        return keySetting;
    }

    public void setKeySetting(KeySetting keySetting) {
        this.keySetting = keySetting;
    }

    public void keyPressed(KeyEvent e) {
        if(keySetting != null) {
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.getKeyUp()) {
                planeModel.move(0, -5);
            }
            else if(keyCode == keySetting.getKeyDown()) {
                planeModel.move(0, 5);
            }
            else if(keyCode == keySetting.getKeyLeft()) {
                planeModel.move(-5, 0);
            }
            else if(keyCode == keySetting.getKeyRight()) {
                planeModel.move(5, 0);
            }
        }
    }

    public void draw(Graphics g) {
        planeView.draw(g, planeModel);
    }

    public void run() {

    }
}
