package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Paire	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 07/10/17 21:50
 ...............................................................................................................................*/

public class Paire extends Combination {
    private Card paire;

    public Paire(ArrayList<Card> hand) throws IllegalArgumentException {
        super(hand);
        paire = FindPaire(hand);
        if (paire == null)
            throw new IllegalArgumentException("Parameter does not contain a " + getClass().getSimpleName());
        //noinspection unchecked
        ArrayList<Card> reducedHand = (ArrayList<Card>) hand.clone();

        for (Card c : hand) {
            if (c.compareTo(paire) == 0) reducedHand.remove(c);
        }

        this.setRestOfCards(reducedHand);
        this.setValue(1);
    }

    public static boolean isTypeOf(ArrayList<Card> cards) throws IllegalArgumentException {
        return FindPaire(cards) != null;
    }

    static Card FindPaire(ArrayList<Card> hand) throws IllegalArgumentException {
        if (hand == null) throw new IllegalArgumentException("Parameter is null");
        if (hand.size() != 5) throw new IllegalArgumentException("Invalid size of param : " + hand.size() + " != 5");
        int[] tab = new int[15];
        int compteur = 0;
        Card card = null;
        for (Card c : hand) {
            tab[c.getValue()] += 1;
        }
        for (int i = 0; i < tab.length; i++) {
            // si la carte est en double alors on la stock dans un tableau
            if (tab[i] == 2) {
                card = new Card(i, "Ca");
                compteur++;
            }
        }
        return compteur == 1 ? card : null;
    }



    public Card getPaire ()
    {
        return paire;
    }

    public void setPaire (Card paire)
    {
        this.paire = paire;
    }

    @Override
    public int compareTo(Combination otherComb) throws IllegalArgumentException
    {
        if (otherComb == null) throw new IllegalArgumentException("Parameter is null");

        int valueCompare = super.compareTo(otherComb);

        if (valueCompare != 0) return valueCompare;

        Paire otherPair = (Paire) otherComb;
        int cardCompare = this.paire.compareTo(otherPair.paire);

        if (cardCompare != 0) return cardCompare;

        PlusHauteCarte reste = new PlusHauteCarte(this.getRestOfCards());
        PlusHauteCarte autreReste = new PlusHauteCarte(otherPair.getRestOfCards());

        return reste.compareTo(autreReste);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " de " + this.getPaire().getStringValue();
    }
}
