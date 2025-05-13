package Practice.DataStructures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class hashmap {

    public static void main(String[]args)
    {
        HashMap<Integer, String> persondob=new HashMap<>();

        persondob.put(1997, "Hassain");
        persondob.put(1998, "Karri");
        persondob.put(1999,"Sana");
        persondob.put(2000,"Pandu");

        System.out.println(persondob);

        Iterator<Map.Entry<Integer, String>> it=persondob.entrySet().iterator();

        while (it.hasNext())
        {
            Map.Entry<Integer, String> entry=it.next();

            System.out.println(entry.getKey() +" "+entry.getValue());
        }
    }
}
