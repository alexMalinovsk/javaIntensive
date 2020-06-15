package Next;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Scanner;

public class Greed {
    public static final String[] ANSI_COLORS = {"\u001B[31m","\u001B[32m","\u001B[33m","\u001B[34m","\u001B[35m","\u001B[36m","\u001B[37m"};
    public static final String ANSI_RESET = "\u001B[0m";
    static char[][] map;
    static int x,y,n,m;
    static Random rand;
    static Scanner sc;
    static int score;
    static int end;

    public static void mapView()
    {
        System.out.flush();
        System.out.println("Score: "+score);


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==y && j==x)
                    System.out.print(map[i][j]);
                else
                    System.out.print(ANSI_COLORS[rand.nextInt(7)]+map[i][j]+ANSI_RESET);
            }
            System.out.println();
        }
    }

    public static boolean isMovable(int dir,int d){
        if(d<0)
        {
            System.out.println("Bad move");
            return false;
        }
        for(int i=0;i<d;i++)
        {
            if(y+i*(dir/2)-n*((y+i*(dir/2))/(n))<=0 || x+i*(dir%2)-m*((x+i*(dir%2))/(m))<=0 || map[y+i*(dir/2)][x+i*(dir%2)]==' ')
            {
                System.out.println("Bad move");
                return false;
            }
        }
        if(map[y+d*(dir/2)][x+d*(dir%2)]==' ')
        {
            System.out.println("Bad move");
            return false;
        }
        return true;
    }

    public static void move(int dir,int d) {
        if(isMovable(dir,d)==true)
        {
            for (int i = 0; i < d; i++) {
                map[y + i * (dir / 2)][x + i * (dir % 2)] = ' ';
            }
            x += dir % 2 * d;
            y += dir / 2 * d;
            score += Math.abs(dir / 2 * d + dir % 2 * d);
            map[y][x] = '@';
            return;
        }

    }

    public static void step() {
        int dist = 0, ok = 0;
        try {
            char buf = sc.nextLine().charAt(0);

            if(isMovable(-2,map[y - 1][x] - 48) || isMovable(-1,map[y][x - 1] - 48) || isMovable(2,map[y + 1][x] - 48) || isMovable(1,map[y][x + 1] - 48)) {
                switch (buf) {
                    case 'w': {
                        dist = map[y - 1][x] - 48;
                        move(-2, dist);
                        break;
                    }
                    case 'a': {
                        dist = map[y][x - 1] - 48;
                        move(-1, dist);
                        break;
                    }
                    case 's': {
                        dist = map[y + 1][x] - 48;
                        move(2, dist);
                        break;
                    }
                    case 'd': {
                        dist = map[y][x + 1] - 48;
                        move(1, dist);
                        break;
                    }
                }
            }
            else {
                end=1;
                return;
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e)
        {
           // System.out.println("Bade move");
        }
    }
    public static boolean GameEnd()
    {
        if(score>250 || end==1)
            return false;
        return true;
    }

    public static void Start()
    {
        score=0;
        sc=new Scanner(System.in);
        n=20;
        m=40;
        map=new char[n][m];
        end=0;
        rand=new Random(2);
        x=rand.nextInt(m-1)+1;
        y=rand.nextInt(n-1)+1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                map[i][j]=(char) (rand.nextInt(9)+49);
               // System.out.print(map[i][j]);
            }
           // System.out.println();
        }
        map[y][x]='@';
        mapView();
        while (GameEnd())
        {
            step();
            mapView();
        }
        System.out.print("End");
    }

    public static void main(String[] args)
    {
        Start();
    }

}
