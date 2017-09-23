package TeamA.classe;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Card	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class Card implements Comparable
{
    private int value;
    private String name;

    public Card(int value, String name){
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }
    public String getName() {
        return name;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int compareTo (Object o)
    {
        return 0;
    }
}