package Next;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class mat {
    public static void main(String[] args)
    {
        Random rand=new Random();
        int n=10,k=0;
        double aver=0;
        int[][] mat=new int[18][12];
        ArrayList<Integer> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        k=sc.nextInt();

        for(int i=0;i<18;i++)
        {
            for(int j=0;j<12;j++)
            {
                mat[i][j]=rand.nextInt(100);
                System.out.print("\t"+mat[i][j]);
            }
            System.out.println();
        }

        for(int i=0;i<18;i++) {
            aver+=mat[i][k-1];
        }

        System.out.println(aver/18);
    }

}
