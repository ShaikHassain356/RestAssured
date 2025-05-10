package Practice.ConstructorOverloading;

public class ClassB {

    public static void main(String []args)
    {
        ClassA obj=new ClassA();
        System.out.println(obj.volume());

        ClassA obj2=new ClassA(1,2,3);
        System.out.println(obj2.volume());
    }
}
