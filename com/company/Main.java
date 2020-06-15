package com.company;

import java.net.SocketOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean doublet;
        int f,s;
        Scanner sc=new Scanner(System.in);
//        n=sc.nextInt();
//        System.out.println(n*n-3*n+2);

//        isWeekend=!isWeekday;
//        System.out.println(isWeekend);
        f=sc.nextInt();
        s=sc.nextInt();
        doublet=f==s;
        System.out.println(doublet);
    }
}
