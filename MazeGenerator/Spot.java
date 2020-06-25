package MazeGenerator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Spot {
    private int x;
    private int y;
    private boolean isWall;
    private final int cellSide;
    private ArrayList<Spot> neigbrours;
    private boolean visited;
    private boolean isPath;

    public Spot(int x,int y, boolean isWall,int CellSide) {
        this.x=x;
        this.y = y;
        this.isWall = isWall;
        this.cellSide =CellSide;
        neigbrours=new ArrayList<>();
        visited=false;
        isPath=false;
    }

    public void setWall(boolean wall) {
        isWall = wall;
    }

    public void addNeighbour(Spot spot)
    {
        neigbrours.add(spot);
    }

    public boolean isWall() {
        return isWall;
    }

    public void draw(Graphics g,Spot n)
    {
        Color black=Color.BLACK;
        Color white=Color.WHITE;
        if(isWall)
            g.setColor(black);
        else
            g.setColor(white);
        if(n!=null)
        {
            isPath=true;
        }
        if(isPath)
            g.setColor(Color.RED);
        g.fillRect(x*cellSide,y*cellSide,cellSide,cellSide);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean hasUnvisitedNeighbours()
    {
        for(Spot neighbour: neigbrours)
        {
            if(!neighbour.visited)
                return true;
        }
        return false;
    }

    public Spot getUnvisitedNeighbour(Random r)
    {
        ArrayList<Spot> unVisited=new ArrayList<>();
        int c=0;
        for(Spot neighbour: neigbrours)
        {
            if(!neighbour.visited) {
                unVisited.add(neighbour);
                c++;
            }
        }


        return unVisited.get(r.nextInt(unVisited.size()));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
