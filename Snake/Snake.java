package Snake;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private final ArrayList<Spot> snake;
    public Spot head;
    private final int spotSize;

    public Snake(int x,int y,int size)
    {
        head=new Spot(x,y,size);
        snake=new ArrayList<>();
        spotSize=size;
        snake.add(head);
    }

    public int getSize()
    {
        return snake.size();
    }

    public void move(int direction)
    {
        for(int i=snake.size()-1;i>0;i--)
        {
            snake.get(i).setX(snake.get(i-1).getX());
            snake.get(i).setY(snake.get(i-1).getY());
        }

        switch (direction) {
            case 1 ->
                head.changeY(-1);
            case 2 ->
                head.changeX(1);
            case 3 ->
                head.changeY(1);
            case 4 ->
                head.changeX(-1);

        }
        if(head.getX()>74)
            head.setX(0);
        if(head.getX()<0)
            head.setX(74);
        if(head.getY()>74)
            head.setY(0);
        if(head.getY()<0)
            head.setY(74);
    }

    public void drawSnake(Graphics g)
    {
        for(int i=1;i<snake.size();i++)
        {
            snake.get(i).drawSpot(g,2);
        }
        snake.get(0).drawSpot(g,3);
    }

    public boolean GameEnd()
    {
        for(int i=1;i<snake.size();i++)
        {
            if(head.getX()==snake.get(i).getX() && head.getY()==snake.get(i).getY())
                return true;
        }
        return false;
    }

    public void addBody(int dir)
    {
        if(snake.size()==1)
        {
            int nx=0;
            int ny=0;
            switch (dir) {
                case 1 -> {
                    ny = snake.get(0).getY() + 1;
                    nx = snake.get(0).getX();
                }
                case 2 -> {
                    ny = snake.get(0).getY();
                    nx = snake.get(0).getX() - 1;
                }
                case 3 -> {
                    ny = snake.get(0).getY() - 1;
                    nx = snake.get(0).getX();
                }
                case 4 -> {
                    ny = snake.get(0).getY();
                    nx = snake.get(0).getX() + 1;
                }
            }
            Spot body=new Spot(nx,ny,spotSize);
            snake.add(body);
            return;
        }
        int nX=snake.get(snake.size()-1).getX()-snake.get(snake.size()-2).getX()+snake.get(snake.size()-1).getX();
        int nY=snake.get(snake.size()-1).getY()-snake.get(snake.size()-2).getY()+snake.get(snake.size()-1).getY();
        snake.add(new Spot(nX,nY,spotSize));
    }
    public boolean eatFood(Spot food)
    {
        for(int i=0;i<snake.size();i++)
            if (food.getX() == snake.get(i).getX() && food.getY() == snake.get(i).getY())
                return true;
        return false;
    }
}
