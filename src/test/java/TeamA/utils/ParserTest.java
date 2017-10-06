package TeamA.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

/*................................................................................................................................
 . Copyright (c)
 .
 . The ParserTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 06/10/17 23:38
 ...............................................................................................................................*/

public class ParserTest
{
    @Test
    public void readCards_Right ()
    {
        String typed = "2Ca 3Pi 5Tr 3Ca DPi";

        ByteArrayInputStream in = new ByteArrayInputStream(typed.getBytes());
        System.setIn(in);

        Assert.assertEquals(typed, Parser.readCards().toString());
    }

    //NoSuchElementExeception means an IllegalArgumentException was raised,
    //and that Parser asked for retyping -> which couldn't be done.
    @Test (expected = NoSuchElementException.class)
    public void readCards_WrongSize ()
    {
        String typed = "2Ca 3Pi 5Tr 7Co 3Ca DPi";

        ByteArrayInputStream in = new ByteArrayInputStream(typed.getBytes());
        System.setIn(in);

        Parser.readCards();
    }

    //NoSuchElementExeception means an IllegalArgumentException was raised,
    //and that Parser asked for retyping -> which couldn't be done.
    @Test (expected = NoSuchElementException.class)
    public void readCards_WrongValue ()
    {
        String typed = "24Ca 3Pi 5Tr 7Co DPi";

        ByteArrayInputStream in = new ByteArrayInputStream(typed.getBytes());
        System.setIn(in);

        Parser.readCards();
    }

    //NoSuchElementExeception means an IllegalArgumentException was raised,
    //and that Parser asked for retyping -> which couldn't be done.
    @Test (expected = NoSuchElementException.class)
    public void readCards_WrongColor ()
    {
        String typed = "2Bi 3Pi 5Tr 7Co DPi";

        ByteArrayInputStream in = new ByteArrayInputStream(typed.getBytes());
        System.setIn(in);

        Parser.readCards();
    }

    //NoSuchElementExeception means an IllegalArgumentException was raised,
    //and that Parser asked for retyping -> which couldn't be done.
    @Test (expected = NoSuchElementException.class)
    public void readCards_Duplicate ()
    {
        String typed = "3Pi 3Pi 5Tr 7Co DPi";

        ByteArrayInputStream in = new ByteArrayInputStream(typed.getBytes());
        System.setIn(in);

        Parser.readCards();
    }
}