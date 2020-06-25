package MazeGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Stack;

public class Maze extends JPanel {
    private final int fieldSize, numSideDivision;
    private Spot[][] field;
    private final int cellSide;
    private final Stack<Spot> stack;
    private Spot current;
    private int sX;
    private int sY;
    private Random r;
    private PathFinder p;

    public Maze(int fieldSize,int numSideDivision)
    {
        stack=new Stack<>();
        this.fieldSize=fieldSize;
        this.numSideDivision =numSideDivision;
        field=new Spot[numSideDivision][numSideDivision];
        this.cellSide=fieldSize/numSideDivision;
        createField();
        addNeighbours();
        sX=1;
        sY=1;
        p=new PathFinder(field,field[41][41],field[13][65]);
        r=new Random();

        current=field[sY][sX];
        current.setVisited(true);
        stack.push(current);
    }

    public void createField()
    {
        for(int i = 0; i< numSideDivision; i++)
        {
            for(int j = 0; j< numSideDivision; j++)
            {
                field[i][j]=new Spot(j,i,true,cellSide);
                if(i%2!=0 && j%2!=0 && i< numSideDivision -1 && j< numSideDivision -1) {
                    field[i][j].setWall(false);
                }
            }
        }
        //field[1][0].setWall(false);
        //field[numSideDivision-2][numSideDivision-1].setWall(false);
    }

    public void addNeighbours()
    {
        for(int i=0;i<numSideDivision;i++)
        {
            for(int j=0;j<numSideDivision;j++)
            {
                if(!field[i][j].isWall())
                {
                    boolean hasUpperNeighbour=i>1;
                    boolean hasLeftNeighbour=j>1;
                    boolean hasBottomNeighbour=i<numSideDivision-2;
                    boolean hasRightNeighbour=j<numSideDivision-2;

                    if(hasUpperNeighbour)
                    {
                        field[i][j].addNeighbour(field[i-2][j]);
                    }
                    if(hasBottomNeighbour)
                    {
                        field[i][j].addNeighbour(field[i+2][j]);
                    }
                    if(hasLeftNeighbour)
                    {
                        field[i][j].addNeighbour(field[i][j-2]);
                    }
                    if(hasRightNeighbour)
                    {
                        field[i][j].addNeighbour(field[i][j+2]);
                    }
                }
            }
        }
    }

    public void drawMaze(Graphics g)
    {
        for(int i = 0; i< numSideDivision; i++)
        {
            for(int j = 0; j< numSideDivision; j++)
            {
                field[i][j].draw(g,null);
            }
        }
    }

    public void buildMaze()
    {
        current=stack.pop();
        if(current.hasUnvisitedNeighbours())
        {
            stack.push(current);
            Spot next=current.getUnvisitedNeighbour(r);
            removeWall(next);
            next.setVisited(true);
            stack.push(next);
        }
    }

    public void removeWall(Spot next)
    {
        int curX=current.getX();
        int curY=current.getY();

        Spot wall;

        if(curX>next.getX())
            wall=field[curY][curX-1];
        else if(curX<next.getX())
            wall=field[curY][curX+1];
        else if(curY>next.getY())
            wall=field[curY-1][curX];
        else
            wall=field[curY+1][curX];

        wall.setWall(false);
    }

    public void drawPath(Path unit,Graphics g)
    {
        for(int i=0;i<unit.getSize();i++)
        {
           // drawMaze(g);
            unit.getSpot(i).draw(g,unit.getSpot(i));
//            try
//            {
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }

        }
    }

    public void paint(Graphics g)
    {
//        try
//        {
//            Thread.sleep(10);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }

        drawMaze(g);
        if(!stack.empty()) {
            buildMaze();
            repaint();
        }
        else
        {
            p.buildPath();
            drawPath(p.optimalPath,g);
        }
    }
}
