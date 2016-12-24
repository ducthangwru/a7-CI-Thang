/**
 * Created by DUC THANG on 12/21/2016.
 */
public class Main {
    public static void main(String[] args) {
        STDuck stDuck = new STDuck("Chó");
        stDuck.getShot();
        stDuck.fly();
        stDuck.quack();
        stDuck.swim();

        RubberDuck rubberDuck = new RubberDuck("Mèo");
        rubberDuck.swim();
        rubberDuck.fly();
        rubberDuck.quack();

        DecoyDuck decoyDuck = new DecoyDuck("Lợn");
        decoyDuck.quack();
        decoyDuck.fly();
        decoyDuck.swim();
    }
}
