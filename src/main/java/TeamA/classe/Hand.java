package TeamA.classe;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>();

    public Hand(ArrayList<Card> hand){
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public Combination findBestCombination ()
    {
        return new PlusHauteCarte(hand);
    }
    public String toString(){
        String affHand = "";
        for(Card c : hand){
            affHand += c.getName()+'_';
        }
        return affHand;
    }

}
