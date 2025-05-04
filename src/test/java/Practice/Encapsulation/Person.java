package Practice.Encapsulation;

public class Person {

    private String name;

    /*encapsulation meaning wrapping of variables and methods that operate on data into a single unit, main use of this is
    to hide the sensitive data by declaring the variable as private, and access them via public getters and setters methods*/

    public String getname()
    {
       return name;
    }

    public void setname(String name)
    {
        this.name=name;
    }
}
