import java.util.Vector;

/**
 * Created by DUC THANG on 12/14/2016.
 */
public class Main {
    public static void main(String[] args) {
        Character naruto = new Naruto();
        Character sasuke = new Sasuke();
        Character levi = new Levi();
        Character gaara = new Gaara();
        Vector <Character> characterVector = new Vector<>();
        characterVector.add(naruto);
        characterVector.add(sasuke);
        characterVector.add(levi);
        characterVector.add(gaara);

        //naruto.attack(sasuke);
        //levi.attack(gaara);

        for (int i = 0; i < characterVector.size() - 1; i++) {
            characterVector.get(i).attack(characterVector.get(i + 1));
        }
        characterVector.get(characterVector.size() - 1).attack(characterVector.get(0));
    }
}
