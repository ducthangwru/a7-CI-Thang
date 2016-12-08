package controllers;

import models.Model;
import views.View;

import java.util.Random;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/8/2016.
 */
public class PlaneEnemyController extends Controller{

    public PlaneEnemyController(Model model, View view) {
        super(model, view);
    }
    public void run() {
        this.model.move(0, 5);
    }

    public static PlaneEnemyController createEnemyController(int x, int y) {
        return new PlaneEnemyController(new Model(x, y, 50, 50), new View(loadImage("resources/enemy_plane_white_3.png")));
    }
}
