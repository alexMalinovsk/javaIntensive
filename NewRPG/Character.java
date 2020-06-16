package NewRPG;

import java.util.Random;

public class Character {
    protected int hp;
    protected int complexity;
    protected Random r;

    public Character(int hp,int complexity)
    {
        r=new Random();
        this.hp=hp;
        this.complexity=complexity;
    }

    public void heal()
    {
        hp+=r.nextInt(40/complexity);
    }

    public int attack()
    {
        return r.nextInt(40/complexity);
    }

    public void getDamage(int value)
    {
        hp-=value;
    }
    public boolean isLive()
    {
        if(hp>0)
            return true;
        return false;
    }
    public int getExp()
    {
        return r.nextInt(250*complexity);
    }
    public int getMoney()
    {
        return r.nextInt(50*complexity);
    }
}
