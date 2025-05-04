package Practice.Encapsulation;

public class Person2 {
    public static void main(String []args)
    {
        Person pn=new Person();
        pn.setname("Hassain");
        String myname= pn.getname();
        System.out.println(myname);
        System.out.println(pn.getname());

    }
}
