package controllers.managers;

import controllers.Body;
import models.Model;

import java.util.Vector;

/**
 * Created by DUC THANG on 12/14/2016.
 */
public class BodyManager {
    private Vector<Body> bodyVector;

    public static final BodyManager instance = new BodyManager();

    private BodyManager() {
        bodyVector = new Vector<>();
    }

    public void register(Body body) {
        this.bodyVector.add(body);
    }

    public void checkContact() {
        for(int i = 0; i < bodyVector.size() - 1; i++) {
            for(int j = i + 1; j < bodyVector.size(); j++) {
                Body bodyi = bodyVector.get(i);
                Body bodyj = bodyVector.get(j);
                Model modeli = bodyi.getModel();
                Model modelj = bodyj.getModel();

                if(modeli.intersects(modelj)) {
                    bodyi.onContact(bodyj);
                    bodyj.onContact(bodyi);
                }
            }
        }
    }
}
