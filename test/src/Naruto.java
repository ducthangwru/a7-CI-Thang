/**
 * Created by DUC THANG on 12/14/2016.
 */
public class Naruto extends Character{
    public Naruto() {
       name = "Naruto";
       village = "Leaf";
       atk = 10;
       def = 2;
       hp = 4;
    }

    public Naruto(String name, String village, int atk, int def, int hp) {
        super(name, village, atk, def, hp);
    }
}
