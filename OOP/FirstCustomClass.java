package OOP;

public class FirstCustomClass {
    public static void main(String[] args) {
        Student Petya=new Student("Petya",15,"Male",75,5);
        Petya.yearOfStudyIncrement(22);
        System.out.print(Petya.getYearOfStudy());
    }
}
