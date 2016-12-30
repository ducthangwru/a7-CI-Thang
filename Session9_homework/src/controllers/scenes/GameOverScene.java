package controllers.scenes;

import controllers.BulletController;
import controllers.Controller;
import controllers.PlaneController;
import controllers.enemies.BulletEnemyController;
import controllers.gifts.BombController;
import controllers.managers.BodyManager;
import controllers.managers.ControllerManager;
import controllers.managers.EnemyControllerManager;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/30/2016.
 */
public class GameOverScene extends GameScene {
    Image background;

    public GameOverScene() {
        Utils.playSound("resources/gameoversound.wav", false);
        background = loadImage("resources/gameover.png");
    }

    int timeCount;
    int time;

    @Override
    public void update(Graphics g) {
        g.drawImage(background,0, 0, 800, 600, null);
        timeCount++;
        g.drawImage(background, 0, 0, 800, 600, null);
        if(timeCount >= 50) {
            if(time < 100) {
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.setColor(Color.RED);
                g.drawString("PRESS ANY KEY TO MENU GAME!!!!!!!!!!!!", 200, 550);
                time++;
            }
        }

        if(time >= 100)
            time = 0;

        if (timeCount > 90){
            timeCount = 0;
        }
    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        removeAll();
        this.sceneListener.back();
    }

    public void removeAll() {
        PlaneController.instance.getModel().setX(300);
        PlaneController.instance.getModel().setY(500);
        BodyManager.instance.getBodyVector().removeAll(BodyManager.instance.getBodyVector());
        PlaneController.instance.getModel().setAlive(true);
        PlaneController.instance.setHp(3);
        PlaneController.instance.setLives(3);
        EnemyControllerManager.enemyBullet.getControllers().removeAll(EnemyControllerManager.enemyBullet.getControllers());
        BodyManager.instance.register(PlaneController.instance);
    }
}
