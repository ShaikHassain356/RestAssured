package Practice.WrapperClasses;

public class WrapperClassesDemo {

    public static void main(String[]args)
    {
        //wrapper classes provide way to use primitive data type as objects

        Integer myint=100;
        Double mydouble=2.7;
        Character mychar='A';


        System.out.println(myint);
        System.out.println(mychar);
        System.out.println(mydouble);


        //these below methods like myint.intValue() will give the value associated with that particular wrapper object
        System.out.println(myint.intValue());
        System.out.println(mychar.charValue());
        System.out.println(mydouble.doubleValue());

        //toString() method used to convert wrapper object to strings

         String convertedwrapper= myint.toString();
        System.out.println(convertedwrapper.length());

        // Using method from wrapper class
        String str = Integer.toString(123);
        System.out.println(str);

    }
}
