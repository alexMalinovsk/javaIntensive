package MazeGenerator;

import javax.swing.*;
import java.util.ArrayList;

public class PathFinder extends JPanel {
    private final ArrayList<Path> paths;
    private final Spot[][] field;
    public Path optimalPath;
    private Spot finishSpot;

    public PathFinder(Spot[][] field,Spot startSpot,Spot finishSpot)
    {
        paths=new ArrayList<>();
        optimalPath=null;
        this.field=field;
        paths.add(new Path(startSpot));
        this.finishSpot=finishSpot;
    }

    public void getOptimalPath() {
        for (Path path : paths) {
            if (path.peek() == finishSpot) {
                optimalPath = path;
                return;
            }
        }
        optimalPath=paths.get(0);
    }

    public boolean finishBuild()
    {
        for (Path path : paths) {
            if (path.peek() == finishSpot)
                return true;
        }
        return false;
    }

    public int variantsDirection(Path unit)
    {
            int counter = 0;
            if (!field[unit.peek().getY() - 1][unit.peek().getX()].isWall() && !unit.inPath(field[unit.peek().getY() - 1][unit.peek().getX()])) {
                counter++;
            }
            if (!field[unit.peek().getY() + 1][unit.peek().getX()].isWall() && !unit.inPath(field[unit.peek().getY() + 1][unit.peek().getX()])) {
                counter++;
            }
            if (!field[unit.peek().getY()][unit.peek().getX() - 1].isWall() && !unit.inPath(field[unit.peek().getY()][unit.peek().getX() - 1])) {
                counter++;
            }
            if (!field[unit.peek().getY()][unit.peek().getX() + 1].isWall() && !unit.inPath(field[unit.peek().getY()][unit.peek().getX() + 1])) {
                counter++;
            }
            return counter;
    }

    public void buildPath()
    {
   //     int d=0;
        while (!finishBuild())
        {
            for(int i=0;i<paths.size();i++)
            {
                if(variantsDirection(paths.get(i))==1)
                {
                    int c=0;
                    if(!field[paths.get(i).peek().getY()-1][paths.get(i).peek().getX()].isWall() && !paths.get(i).inPath(field[paths.get(i).peek().getY()-1][paths.get(i).peek().getX()]))
                    {
                        paths.get(i).addSpot(field[paths.get(i).peek().getY()-1][paths.get(i).peek().getX()]);
                        c=1;
                    }
                    if(!field[paths.get(i).peek().getY()+1][paths.get(i).peek().getX()].isWall() && !paths.get(i).inPath(field[paths.get(i).peek().getY()+1][paths.get(i).peek().getX()]) && c==0)
                    {
                        paths.get(i).addSpot(field[paths.get(i).peek().getY()+1][paths.get(i).peek().getX()]);
                        c=1;
                    }
                    if(!field[paths.get(i).peek().getY()][paths.get(i).peek().getX()-1].isWall() && !paths.get(i).inPath(field[paths.get(i).peek().getY()][paths.get(i).peek().getX()-1]) && c==0)
                    {
                        paths.get(i).addSpot(field[paths.get(i).peek().getY()][paths.get(i).peek().getX()-1]);
                        c=1;
                    }
                    if(!field[paths.get(i).peek().getY()][paths.get(i).peek().getX()+1].isWall() && !paths.get(i).inPath(field[paths.get(i).peek().getY()][paths.get(i).peek().getX()+1]) && c==0)
                    {
                        paths.get(i).addSpot(field[paths.get(i).peek().getY()][paths.get(i).peek().getX()+1]);
                    }
                }
                if(variantsDirection(paths.get(i))>1)
                {
                    int c=0;
                    Spot newSpot=null;
                    if(!field[paths.get(i).peek().getY()-1][paths.get(i).peek().getX()].isWall() && !paths.get(i).inPath(field[paths.get(i).peek().getY()-1][paths.get(i).peek().getX()]))
                    {
                        newSpot=field[paths.get(i).peek().getY()-1][paths.get(i).peek().getX()];
                        c++;
                    }
                    if(!field[paths.get(i).peek().getY()+1][paths.get(i).peek().getX()].isWall() && !paths.get(i).inPath(field[paths.get(i).peek().getY()+1][paths.get(i).peek().getX()]))
                    {
                        if(c==0)
                            newSpot=field[paths.get(i).peek().getY()+1][paths.get(i).peek().getX()];
                        if(c>0) {
                            Path n=new Path(paths.get(i));
                            n.addSpot(field[paths.get(i).peek().getY()+1][paths.get(i).peek().getX()]);
                            paths.add(n);
                        }
                        c++;
                    }
                    if(!field[paths.get(i).peek().getY()][paths.get(i).peek().getX()-1].isWall() && !paths.get(i).inPath(field[paths.get(i).peek().getY()][paths.get(i).peek().getX()-1]))
                    {
                        if(c==0)
                            newSpot=field[paths.get(i).peek().getY()][paths.get(i).peek().getX()-1];
                        if(c>0)
                        {
                            Path n=new Path(paths.get(i));
                            n.addSpot(field[paths.get(i).peek().getY()][paths.get(i).peek().getX()-1]);
                            paths.add(n);
                        }
                        c++;
                    }
                    if(!field[paths.get(i).peek().getY()][paths.get(i).peek().getX()+1].isWall() && !paths.get(i).inPath(field[paths.get(i).peek().getY()][paths.get(i).peek().getX()+1]))
                    {
                        if(c==0)
                            newSpot=field[paths.get(i).peek().getY()][paths.get(i).peek().getX()+1];
                        if(c>0)
                        {
                            Path n=new Path(paths.get(i));
                            n.addSpot(field[paths.get(i).peek().getY()][paths.get(i).peek().getX()+1]);
                            paths.add(n);
                        }
                    }
                    if(newSpot!=null)
                        paths.get(i).addSpot(newSpot);
                }
          //      if(variantsDirection(paths.get(i))==0)
             //       paths.remove(i);
            }
         //   d++;
        }
        getOptimalPath();
        System.out.println();
    }

}
