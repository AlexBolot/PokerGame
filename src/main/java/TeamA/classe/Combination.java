package TeamA.classe;

import java.util.ArrayList;

public abstract class Combination {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private String name;
    private int value;

    public Combination(ArrayList<Card> hand){
        this.hand = hand;

        // TODO trouver la meilleure combinaison
        //this.name =
        //this.value = value;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
