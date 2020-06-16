package NewRPG;

import java.util.Random;

public class Knight extends Character {
    private int money;
    private int healCounter;
    private int exp;
    private int level;

    public Knight(int hp,int money,int complexity,int startHeal,int startExp)
    {
        super(hp,complexity);
        this.money=money;
        healCounter=startHeal;
        exp=startExp;
        level=1;
    }

    public void addMoney(int value)
    {
        money+=value;
    }
    public void buyHeal()
    {
        int healPrice=1000/complexity;
        if(money>healPrice) {
            money-=healPrice;
            System.out.println("You buy heal");
            healCounter++;
        }
        else
        {
            System.out.println("You haven't money");
        }
    }

    public void addHeal(int value)
    {
        healCounter+=value;
    }

    @Override
    public int getMoney()
    {
        return money;
    }

    public int attack()
    {
        return r.nextInt(10)*complexity*level;
    }

    @Override
    public void heal()
    {
        hp+=r.nextInt(5)*complexity*level;
    }

    public int getLevel() {
        return level;
    }

    public void addExp(int value)
    {
        exp+=value;
    }

    public void levelUp()
    {
        while (exp>=1000) {
            level++;
            exp-=1000;
            System.out.println("Level up to"+level);
        }
    }

    public int getHealCounter() {
        return healCounter;
    }
}
