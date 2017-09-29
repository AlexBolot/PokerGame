package TeamA.classe.Combinations;

import TeamA.classe.Card;
import TeamA.classe.Hand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/*................................................................................................................................
 . Copyright (c) 
 .
 . The DoublePaireTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 26/09/17 16:46
 ...............................................................................................................................*/

public class DoublePaireTest
{
    private  ArrayList<Card> obj1, obj2, obj3, obj4, obj5, obj6;
    @Before
    public void init(){
         obj1 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(8, "Co"),
                new Card(8, "Tr"),
                new Card(2, "Pi"),
                new Card(4, "Pi")));

        obj2 = new ArrayList<>(Arrays.asList(new Card(3, "Ca"),
                new Card(3, "Co"),
                new Card(7, "Tr"),
                new Card(7, "Pi"),
                new Card(4, "Pi")));

        obj3 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(4, "Co"),
                new Card(8, "Tr"),
                new Card(2, "Pi"),
                new Card(7, "Pi")));

        obj4 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(2, "Co"),
                new Card(1, "Tr"),
                new Card(2, "Pi"),
                new Card(7, "Pi")));

        obj5 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(4, "Co"),
                new Card(8, "Tr"),
                new Card(2, "Pi"),
                new Card(2, "Pi")));

        obj6 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(2, "Co"),
                new Card(1, "Tr"),
                new Card(2, "Pi"),
                new Card(7, "Pi")));
    }

    @Test
    public void DoublePaire(){
        DoublePaire dp = new DoublePaire(obj1);
        Assert.assertEquals(1,dp.getHand().size()); // on test si les cartes on bien était supprimé de la main
    }

    @Test
    public void isTypeOf () throws Exception
    {
        Assert.assertEquals(true, DoublePaire.isTypeOf(obj1));// double pair
        Assert.assertEquals(true, DoublePaire.isTypeOf(obj2)); // double pair
        Assert.assertEquals(false, DoublePaire.isTypeOf(obj3)); // pair
        Assert.assertEquals(false, DoublePaire.isTypeOf(obj4)); //brelan
        Assert.assertEquals(false, DoublePaire.isTypeOf(obj5)); // brelan
        Assert.assertEquals(false, DoublePaire.isTypeOf(obj6)); // carré
    }



}