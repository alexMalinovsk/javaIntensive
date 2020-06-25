package OOP;

public class Student extends Man {
    private int yearOfStudy;

    public Student(String name, int age,String gender,int mass,int yearOfStudy)
    {
        super(name,age,gender,mass);
        this.yearOfStudy=yearOfStudy;
    }


    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void yearOfStudyIncrement(int value)
    {
        yearOfStudy+=value;
    }
}
