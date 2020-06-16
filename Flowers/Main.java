package Flowers;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Rosa r=new Rosa(12);
        Romashka rom=new Romashka(15);
        Tylpal t1=new Tylpal(25);
        Tylpal t2=new Tylpal(35);
        ArrayList<Flower> arr=new ArrayList<>();

        arr.add(r);
        arr.add(t1);
        arr.add(t2);
        arr.add(rom);
        Buket b=new Buket(arr);
        System.out.print(b.CalculateBuketCost());
    }
}
