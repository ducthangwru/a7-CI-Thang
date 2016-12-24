package controllers.managers;

import controllers.BaseController;
import controllers.Controller;
import controllers.GameSetting;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by DUC THANG on 12/16/2016.
 */
public class ControllerManager implements BaseController{
    protected Vector <Controller> controllers;
    public static final ControllerManager explosion = new ControllerManager();
    public static final ControllerManager enemyBullet = new ControllerManager();

    public ControllerManager() {
        controllers = new Vector<>();
    }

    public void draw(Graphics g) {
        for (Controller controller : controllers) {
            controller.draw(g);
        }
    }

    public void run() {
        for (Controller controller : controllers) {
            controller.run();
        }

        Iterator <Controller> iterator = this.controllers.iterator();
        while(iterator.hasNext()) {
            Controller controller = iterator.next();
            if(!controller.getModel().isAlive() || !GameSetting.instance.isInScreen(controller)) {
                iterator.remove();
            }
        }
    }

    public void add(Controller controller) {
        controllers.add(controller);
    }

    public void remove() {
        for (int i = 0; i < controllers.size(); i++) {
            if(controllers.get(i).getModel().getY() > 600) {
                controllers.remove(controllers.get(i));
            }
        }
    }
}
