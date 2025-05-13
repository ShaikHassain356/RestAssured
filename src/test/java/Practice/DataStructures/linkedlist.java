package Practice.DataStructures;

import java.util.Iterator;
import java.util.LinkedList;

public class linkedlist {

    public static void main(String[]args)
    {
        LinkedList<Integer> dob=new LinkedList<Integer>();
        dob.add(1997);
        dob.add(1998);
        dob.add(1999);
        dob.add(2000);

        System.out.println(dob); //[1997, 1998, 1999, 2000]

        System.out.println(dob.size());

        System.out.println(dob.get(1));

        Iterator it= dob.iterator();

        while (it.hasNext())
        {
            System.out.println(it.next());
        }


    }
}
