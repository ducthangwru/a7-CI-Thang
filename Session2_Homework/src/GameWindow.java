import controllers.BulletController;
import controllers.KeySetting;
import controllers.PlaneController;
import models.BulletModel;
import models.PlaneModel;
import views.BulletView;
import views.PlaneView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by DUC THANG on 12/1/2016.
 */

public class GameWindow extends Frame implements Runnable {
    Image background;
    PlaneController planeController;
    Vector <BulletController> bulletControllerVector;
    BufferedImage backBuffer;

    public GameWindow()
    {
        bulletControllerVector = new Vector<>();

        PlaneModel planeModel = new PlaneModel(300, 300);
        PlaneView planeView = new PlaneView(loadImage("resources/plane3.png"));
        KeySetting keySetting = new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        planeController = new PlaneController(planeModel, planeView);
        planeController.setKeySetting(keySetting);
        
        setVisible(true);
        setSize(800, 600);
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_3BYTE_BGR);
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

        background = loadImage("resources/background.png");

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                planeController.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    bulletControllerVector.add(new BulletController(new BulletView(loadImage("resources/bullet.png")),
                            new BulletModel(planeController.getPlaneModel().getX() + 35 - 6,
                                    planeController.getPlaneModel().getY() - 30)));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        repaint();
    }

    private Image loadImage(String url) {
        try {
            Image image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background, 0, 0, 800, 600, null);
        planeController.draw(backBufferGraphics);
        for (BulletController bulletController : bulletControllerVector) {
            bulletController.draw(backBufferGraphics);
        }
        g.drawImage(backBuffer, 0, 0, 800, 600, null);
    }

    @Override
    public void run() {
        while (true) {
            this.repaint();
            try {
                Thread.sleep(17);
                for (int i = 0; i < bulletControllerVector.size(); i++) {
                    bulletControllerVector.get(i).getBulletModel().move(0, -5);
                    if(bulletControllerVector.get(i).getBulletModel().getY() < 0)
                        bulletControllerVector.remove(bulletControllerVector.get(i));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
