/**
 * Created by DUC THANG on 12/21/2016.
 */
public class STDuck implements Duck {
    private String name;

    public STDuck(String name) {
        this.name = name;
    }

    public void quack() {
        if(getShot()) {
            System.out.println("aaaaaaaa");
        }
        else {
            System.out.println("Quack quack quack");
        }
    }

    public void fly() {
        if(getShot()) {
            System.out.println("aaaaaa, Tao bị bắn mất cánh :))");
        }
        else {
            System.out.println("I can fly");
        }
    }

    public void swim() {
        if(getShot()) {
            System.out.println("Éo bơi được nữa");
        }
        else {
            System.out.println("I can swim");
        }
    }

    @Override
    public boolean getShot() {
        return true;
    }
}
