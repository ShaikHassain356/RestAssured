package Practice.ConstructorOverloading;

public class ClassA {

    int length, height, width;

    ClassA()
    {
        length=height=width=1;
    }

    ClassA(int len, int hei, int wid)
    {
      length=len;
      height=hei;
      width=wid;
    }
    int volume()
    {
        return(length*height*width);
    }
}
