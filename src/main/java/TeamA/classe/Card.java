package TeamA.classe;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Card	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 23/09/17 15:40
 .
 . Contact : bolotalex06@gmail.com
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