package controllers.managers;

import controllers.EnemyController;
import utils.Utils;

import java.util.Random;

/**
 * Created by DUC THANG on 12/16/2016.
 */
public class EnemyControllerManager extends ControllerManager {

    private void spawn() {
        if(Utils.getTimeCounter() > 100) {
            EnemyController enemyController = EnemyController.create(new Random().nextInt(800), 0, "resources/plane1.png");
            enemyController.moveDown();
            add(enemyController);
            EnemyController enemyController1 = EnemyController.create(new Random().nextInt(800), 0, "resources/enemy_plane_yellow_3.png");
            enemyController1.movePaddle();
            add(enemyController1);
            //EnemyController enemyController2 = EnemyController.create(0, 200, "resources/enemy_plane_white_2.png");
            //enemyController2.moveParabol();
            //add(enemyController2);
            Utils.setTimeCounter(0);
        }
    }

    @Override
    public void remove() {
        super.remove();
    }

    public void run() {
        super.run();
        spawn();
        remove();
    }
}
