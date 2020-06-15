import java.util.ArrayList;
import java.util.Scanner;

public class EasyLists {
    public static void main(String[] args) {
      //  int min = Integer.MAX_VALUE,max=Integer.MIN_VALUE,minIn=0,maxIn=0;
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(sc.nextLine());
        }
        for (int i=0;i<13;i++) {
            list.add(0,list.get(4));
            list.remove(5);
        }
//            if (list.get(i).length() < min) {
//                min = list.get(i).length();
//                minIn=i;
//            }
//            if (list.get(i).length() > max) {
//                max = list.get(i).length();
//                maxIn=i;
//            }
        System.out.println(list);

//        if(minIn<maxIn)
//        System.out.println(list.get(minIn));
//        else
//        System.out.println(list.get(maxIn));
//        for (int i = 0; i < 5; i++) {
//            if (list.get(i).length() == min)
//                System.out.println(list.get(i));
//        }
    }
}
