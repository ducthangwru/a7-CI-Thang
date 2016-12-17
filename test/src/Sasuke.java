/**
 * Created by DUC THANG on 12/14/2016.
 */
public class Sasuke extends Character {
    public Sasuke() {
        name = "Sasuke";
        village = "Leaf";
        atk = 9;
        def = 9;
        hp = 6;
    }

    public Sasuke(String name, String village, int atk, int def, int hp) {
        super(name, village, atk, def, hp);
    }
}
