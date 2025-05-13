package Practice.DataStructures;

import java.util.ArrayList;
import java.util.Iterator;

public class arraylist {

    public static void main(String []args)
    {
        ArrayList<String> name=new ArrayList<String>();

        name.add("Hassain");
        name.add("Shaik");
        name.add("manu");
        name.add("saitama");

        System.out.println(name); //[Hassain, Shaik, manu, saitama]

        System.out.println(name.get(2)); //manu

        System.out.println(name.size());

        name.set(1,"replaced");

        //fetching values using iterator

        Iterator it= name.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }



    }
}
