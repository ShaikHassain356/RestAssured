package Practice.W3SchoolsHowTo;

public class MathClassMethods {

    public static void main(String []args)
    {
        int a=49, b=51;

        double sqrroot= Math.sqrt(a);
        System.out.println(sqrroot);  //7.0

        int add= Math.addExact(a,b);
        System.out.println(add); //100

        int dec= Math.decrementExact(a);
        System.out.println(dec); //48

        int abs= Math.abs(a);
        System.out.println(abs);  //49

        int inc= Math.incrementExact(a);
        System.out.println(inc);  //50

        //to generate random number

        double randomnum= Math.random();
        System.out.println(randomnum);

    }
}
