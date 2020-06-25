package MazeGenerator;

import java.awt.*;
import java.util.ArrayList;

public class Path {
    private int size;
    private ArrayList<Spot> path;

    public Path(Spot unit)
    {
        path=new ArrayList<>();
        path.add(unit);
        size++;
    }

    public Path(Path motherPath)
    {
        path=new ArrayList<>();
        for(int i=0;i<motherPath.getSize();i++)
        {
            path.add(motherPath.getSpot(i));
        }
        size=motherPath.getSize();
    }

    public boolean inPath(Spot unit)
    {
        for(int i=0;i<size;i++)
        {
            if(path.get(i)==unit)
                return true;
        }
        return false;
    }

    public Spot peek()
    {
        return path.get(size-1);
    }

    public void addSpot(Spot unit)
    {
        path.add(unit);
        size++;
    }

    public Spot getSpot(int index)
    {
        if(index<size)
            return path.get(index);
        return null;
    }

    public int getSize()
    {
        return size;
    }


}
