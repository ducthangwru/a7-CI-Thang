import controllers.*;
import controllers.managers.BodyManager;
import controllers.managers.BombManager;
import controllers.managers.ControllerManager;
import controllers.managers.EnemyControllerManager;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.Vector;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/16/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;

    BufferedImage backBuffer;
    GameSetting gameSetting;
    Vector<BaseController> controllers;

    public GameWindow() {
        configSettings();

        controllers = new Vector<>();
        controllers.add(new EnemyControllerManager());
        controllers.add(ControllerManager.explosion);
        controllers.add(PlaneController.instance);
        controllers.add(BodyManager.instance);
        controllers.add(ControllerManager.enemyBullet);
        controllers.add(new BombManager());

        setVisible(true);
        setSize(gameSetting.getWidth(), gameSetting.getHeight());
        backBuffer = new BufferedImage(gameSetting.getWidth(), gameSetting.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        background = loadImage("resources/background.png");
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                PlaneController.instance.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        repaint();
    }

    private void configSettings() {
        PlaneController.instance.keySetting = new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE);
        gameSetting = GameSetting.instance;
    }


    public void update(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background, 0, 0, gameSetting.getWidth(), gameSetting.getHeight(), null);

        for(BaseController baseController : this.controllers) {
            baseController.draw(backBufferGraphics);
        }

        if(PlaneController.instance.getLives() < 0) {
            backBufferGraphics.drawImage(loadImage("resources/gameover.png"), -100, 0, 1000, 563, null);
            g.drawImage(backBuffer, 0, 0, gameSetting.getWidth(), gameSetting.getHeight(), null);
            try {
                Thread.sleep(5000);
                System.exit(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        g.drawImage(backBuffer, 0, 0, gameSetting.getWidth(), gameSetting.getHeight(), null);
    }

    @Override
    public void run() {
        while(true) {
            this.repaint();
            try {
                Thread.sleep(17);
                for (BaseController controller : controllers) {
                    controller.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
