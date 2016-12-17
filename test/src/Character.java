/**
 * Created by DUC THANG on 12/14/2016.
 */

public class Character {
    protected String name;
    protected String village;
    protected int atk;
    protected int def;
    protected int hp;

    public Character() {
    }

    public Character(String name, String village, int atk, int def, int hp) {
        this.name = name;
        this.village = village;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
    }

    public void attack(Character character) {
        if(this.atk - character.def >= 0) {
            character.hp = character.hp - (this.atk - character.def);
            System.out.println(this.name + " thắng!");
            System.out.println("Máu còn lại: " + this.name + ": " + this.hp + "  " + character.name + ": " + character.hp);
        }
        else {
            this.hp = this.hp - (character.def - this.atk);
            System.out.println(character.name + " thắng!");
            System.out.println("Máu còn lại: " + this.name + ": " + this.hp + "  " + character.name + ": " + character.hp);
        }
    }
}
