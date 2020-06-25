package Snake;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game extends JPanel {
    private final Spot[][] field;
    private final int height;
    private final int width;
    private final Snake snake;
    private final int spotSize;
    public int dir;
    private boolean foodReady;
    private final Random r;
    private Spot food;
    private int oldDir;
    public boolean pause;
    private final int complexity;

    public Game(int width, int height, int spotSize,int complexity)
    {
        r=new Random();
        this.width=width;
        this.height=height;
        this.spotSize=spotSize;
        field=new Spot[height][width];
        snake=new Snake(r.nextInt(75),r.nextInt(75),spotSize);
        createField();
        dir=r.nextInt(4)+1;
        oldDir=dir;
        foodReady=false;
        pause=false;
        this.complexity=complexity;
    }

    public void createField()
    {
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                field[i][j]=new Spot(i,j,spotSize);
            }
        }
    }

    public void drawField(Graphics g)
    {
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                field[i][j].drawSpot(g,0);
            }
        }
    }

        public void paint(Graphics g)
    {
        if(!pause) {
            if (oldDir != dir) {
                if (Math.abs(dir - oldDir) == 2)
                    dir = oldDir;
                else
                    oldDir = dir;
            }
            try {
                Thread.sleep(1000/complexity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (snake.GameEnd()) {
                System.out.println("Game over! You score: " + snake.getSize());
                return;
            }

            drawField(g);
            snake.move(dir);
            if (!foodReady) {
                food = new Spot(r.nextInt(75), r.nextInt(75), spotSize);
                foodReady = true;
                food.drawSpot(g, 1);
            }
            if (foodReady) {
                food.drawSpot(g, 1);
            }
            if (snake.eatFood(food)) {
                foodReady = false;
                snake.addBody(dir);
            }
            snake.drawSnake(g);
        }
        repaint();
    }
}
