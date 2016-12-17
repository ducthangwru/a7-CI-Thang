import controllers.BulletController;
import controllers.KeySetting;
import controllers.PlaneController;
import controllers.managers.BodyManager;
import controllers.managers.EnemyControllerManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static controllers.PlaneController.createPlane;
import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/11/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    PlaneController planeController;
    Vector<BulletController> bulletControllerVector;
    BufferedImage backBuffer;
    EnemyControllerManager enemyControllerManager;

    public GameWindow() {
        planeController = createPlane(300, 400);
        planeController.setKeySetting(new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT));
        bulletControllerVector = new Vector<>();
        enemyControllerManager = new EnemyControllerManager();
        setVisible(true);
        setSize(800, 600);
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_3BYTE_BGR);
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
                planeController.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    BulletController bulletController = BulletController.createBulletController(planeController.getModel().getX() + 35 -6, planeController.getModel().getY() - 30);
                    bulletControllerVector.add(bulletController);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        repaint();
    }



    public void update(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background, 0, 0, 800, 600, null);
        planeController.draw(backBufferGraphics);
        for (BulletController bulletController : bulletControllerVector) {
            bulletController.draw(backBufferGraphics);
        }
        enemyControllerManager.draw(backBufferGraphics);
        g.drawImage(backBuffer, 0, 0, 800, 600, null);
    }

    @Override
    public void run() {
        while(true) {
            this.repaint();
            try {
                Thread.sleep(17);
                enemyControllerManager.run();
                BodyManager.instance.checkContact();
                for (int i = 0; i < bulletControllerVector.size(); i++) {
                    bulletControllerVector.get(i).run();
                }
                for (int i = 0; i < bulletControllerVector.size(); i++) {
                    if(bulletControllerVector.get(i).getModel().getY() < 0) {
                        bulletControllerVector.remove(bulletControllerVector.get(i));
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
