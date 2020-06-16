package Flowers;

import java.util.concurrent.ForkJoinPool;

public class Flower {
    private int cost;

    public Flower(int cost)
    {
        this.cost=cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
