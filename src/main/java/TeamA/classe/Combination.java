package TeamA.classe;

import java.util.ArrayList;

public class Combination {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private String name;
    private int value;

    public Combination(String name, int value){
        this.name = name;
        this.value = value;
    }
}
