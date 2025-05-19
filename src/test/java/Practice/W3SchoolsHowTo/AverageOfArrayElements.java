package Practice.W3SchoolsHowTo;

public class AverageOfArrayElements {
    public static void main(String []args)
    {
        int[] myint={10, 20, 30, 40, 50, 60};

        int sumofarrayelements=0;

        for (int i=0; i<myint.length; i++)
        {
            sumofarrayelements+=myint[i];
        }

        int averageofarrayelements= sumofarrayelements/myint.length;

        System.out.println(averageofarrayelements);

    }
}
