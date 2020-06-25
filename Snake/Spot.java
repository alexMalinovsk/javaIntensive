package Snake;

import java.awt.*;

public class Spot {
    private int x;
    private int y;
    private final int size;

    public Spot(int x,int y,int size)
    {
        this.x=x;
        this.y=y;
        this.size=size;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changeX(int value)
    {
        x+=value;
    }

    public void changeY(int value)
    {
        y+=value;
    }

    public void drawSpot(Graphics g,int mode)
    {
        if(mode==0)
            g.setColor(Color.BLACK);
        if(mode==1)
            g.setColor(Color.RED);
        if(mode==2)
            g.setColor(Color.GREEN);
        if(mode==3)
            g.setColor(Color.YELLOW);
        g.fillRect(x*size,y*size,size,size);
    }
}
