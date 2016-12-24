/**
 * Created by DUC THANG on 12/21/2016.
 */
public class DecoyDuck implements Duck {
    private String name;

    public DecoyDuck(String name) {
        this.name = name;
    }

    @Override
    public void quack() {
        System.out.println("Bị Câm");
    }

    @Override
    public void fly() {
        System.out.println("Éo bay");
    }

    @Override
    public void swim() {
        System.out.println("Éo bơi");
    }

    @Override
    public boolean getShot() {
        return true;
    }
}
