package Practice.DataStructures;

import java.util.HashSet;
import java.util.Iterator;

public class hashset {

    public static void main(String []args)
    {

        HashSet<Object> hs=new HashSet<>();

        hs.add("Hassain");
        hs.add("Hassain");
        hs.add("Shaik");
        hs.add("shaik");
        hs.add("Ruyi");
        hs.add(1);
        hs.add(true);
        hs.add('A');
        System.out.println(hs); //[1, A, Ruyi, shaik, Hassain, Shaik, true]

        System.out.println(hs.size());

        Iterator<Object> it=hs.iterator();

        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
