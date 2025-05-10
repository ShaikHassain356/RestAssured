package Practice.Inheritance;

public class superclass {

     int age=28;
    String name="Hassain";
    public static void main(String []args)
    {
        System.out.println("Hi hello");
    }

    void print()
    {
        superclass sc=new superclass();
        System.out.println(sc.age);
        System.out.println(sc.name);
    }
    void print2(String name)
    {
        System.out.println("name we have received is "+name);
    }
}
