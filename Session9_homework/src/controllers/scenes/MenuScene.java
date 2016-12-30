package controllers.scenes;

import java.awt.*;
import java.awt.event.KeyEvent;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/28/2016.
 */
public class MenuScene extends GameScene{
    Image background;

    public MenuScene() {
        background = loadImage("resources/1945-logo.png");
    }

    int timeCount;
    int time;
    @Override
    public void update(Graphics g) {
        timeCount++;
        g.drawImage(background, 0, 0, 800, 600, null);
        if(timeCount >= 50) {
            if(time < 100) {
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.setColor(Color.RED);
                g.drawString("PRESS ANY KEY TO PLAY!!!!!!!!!!!!", 200, 500);
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
        this.sceneListener.replaceScene(new PlayGameScene(), true);
    }
}
