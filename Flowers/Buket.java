package Flowers;

import java.util.ArrayList;
import java.util.Calendar;

public class Buket {
    private int BuketCost;
    private ArrayList<Flower> flowers;

    public Buket(ArrayList<Flower> flowers)
    {
        this.flowers=flowers;
        BuketCost=0;
    }

    public int CalculateBuketCost()
    {
        for (int i=0;i<flowers.size();i++)
            BuketCost+=flowers.get(i).getCost();
        return BuketCost;
    }
}
