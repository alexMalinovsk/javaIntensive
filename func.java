import java.util.Scanner;
//import java.math.*;


public class func {
    public static void main(String[] args) {
        double x,y,z;
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        a=(int)(Math.acos((x*x+y*y-z*z)/(2*x*y))*180/Math.PI);
        b=(int)(Math.acos((x*x+z*z-y*y)/(2*x*z))*180/Math.PI);
        c=(int)(Math.acos((z*z+y*y-x*x)/(2*z*y))*180/Math.PI);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
//
        if(x+y>z && x+z>y && y+z>x) {
            if (a == 90 || b == 90 || c == 90) {
                System.out.println("Прямоугольный");
            }
        }
//        else
//            System.out.println("Не существует");
    }
}
