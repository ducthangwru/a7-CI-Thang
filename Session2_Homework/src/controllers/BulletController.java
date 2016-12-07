package controllers;

import models.BulletModel;
import views.BulletView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by DUC THANG on 12/4/2016.
 */
public class BulletController {
    private BulletView bulletView;
    private BulletModel bulletModel;

    public BulletController(BulletView bulletView, BulletModel bulletModel) {
        this.bulletView = bulletView;
        this.bulletModel = bulletModel;
    }

    public BulletView getBulletView() {
        return bulletView;
    }

    public void setBulletView(BulletView bulletView) {
        this.bulletView = bulletView;
    }

    public BulletModel getBulletModel() {
        return bulletModel;
    }

    public void setBulletModel(BulletModel bulletModel) {
        this.bulletModel = bulletModel;
    }

    public void draw(Graphics g) {
        bulletView.draw(g, bulletModel);
    }
}
