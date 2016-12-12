package controllers.managers;

import controllers.EnemyController;
import java.util.Random;

/**
 * Created by DUC THANG on 12/10/2016.
 */
public class EnemyControllerManager extends ControllerManager{

    private void spawn() {
        EnemyController enemyController = EnemyController.create(new Random().nextInt(800), 0);
        this.controllers.add(enemyController);
    }

    public void run() {
        super.run();
        spawn();
    }
}
