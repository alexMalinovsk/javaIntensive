import java.util.ArrayList;
import java.util.Scanner;

public class averageValue {
    public static void main(String[] args)
    {
        ArrayList<Double> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        double negAver=0,posAver=0;
        int n,negCount=0,posCount=0;

        n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            list.add(sc.nextDouble());
            if(list.get(i)>=0)
            {
                posAver+=list.get(i);
                posCount++;
            }
            if(list.get(i)<0)
            {
                negAver+=list.get(i);
                negCount++;
            }
        }
        posAver/=posCount;
        negAver/=negCount;

        System.out.println(posAver*negAver);
    }

}
