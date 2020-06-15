import java.util.Scanner;

public class encode {
    public static void main(String[] args) {
        int[] arr=new int[10];
        int n,buf;

        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    buf=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=buf;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i]);
        }
        //System.out.println(max);
    }
}
