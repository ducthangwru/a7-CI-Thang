/**
 * Created by DUC THANG on 12/21/2016.
 */
public class RubberDuck implements Duck {
    private String name;

    public RubberDuck(String name) {
        this.name = name;
    }

    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("i can't fly");
    }

    @Override
    public void swim() {
        System.out.println("i can swim");
    }

    @Override
    public boolean getShot() {
        return true;
    }
}
