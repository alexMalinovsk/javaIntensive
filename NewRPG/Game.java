package NewRPG;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private boolean crown;
    private int complexity;
    private Knight hero;
    private Random r;
    private EnemyMonster moster;
    private boolean mosterLive;
    private boolean knightLive;
    private EnenmyKnight knight;
    private int inFight;
    private boolean back;

    public void Start(int complexity)
    {
        System.out.println("Привет, дорогой друг! Мне нужна твоя помощь... Этот мир наводнили враги, которые хотят заполучить Корону Священного Пламени. Если они её получат, наш мир не спасти, поэтому все в твоих руках, Рыцарь!");
        System.out.println("На твоем пути тебе встретятся разные враги, побеждая которых, ты сможешь стать сильнее, ну и богаче, но будь осторожнее, ты наша последняя надежда!");

        hero=new Knight(100,100,complexity,(int)(complexity*0.5),0);
        this.complexity=complexity;
        crown=false;
        r=new Random();
        mosterLive=false;
        knightLive=false;
        GameTime();
    }

    public void GameTime()
    {
        int buf;
        while(GameEnd()==0)
        {

            if(hero.getLevel()>=10)
                crown=true;
            buf=r.nextInt(10-inFight)+inFight;
            switch (buf)
            {
                case 0:
                {
                    System.out.println("Вы встретились с монстром, Ваши действия?");
                    moster = new EnemyMonster(100*hero.getLevel(), complexity);
                    mosterLive=true;
                    inFight=2;
                    break;
                }
                case 1:
                {
                    System.out.println("Вы встретились с враждеюбным рыцарем, Ваши действия?");
                    knight = new EnenmyKnight(150* hero.getLevel(),complexity);
                    knightLive=true;
                    inFight=2;
                    break;
                }
                case 2:
                {
                    System.out.println("Вы нашли немного золота, Ваши действия?");
                    break;
                }
                case 3:
                {
                    System.out.println("Вы нашли зелье лечения, Ваши действия?");
                    break;
                }
                case 4:
                {
                    System.out.println("Вы нашли книгу, которая дает дополнительный опыт, Ваши действия?");
                    break;
                }
                default:
                {
                    System.out.println("Пока вы не встретили ничего интересного, Ваши действия");

                    break;
                }
            }
            System.out.println("У вас "+hero.hp+" здоровья, "+hero.getMoney()+" золота и "+hero.getHealCounter()+" зелий");
            heroActions(buf);
            enemyAction();
            back=false;
            hero.levelUp();
        }
    }

    public void heroActions(int buf)
    {
        Scanner sc=new Scanner(System.in);
        int c=1,input;
        int yDamage;
        int money;
        int exp;
        if (inFight==0) {
            System.out.println(c + ". Идти вперед");
            c++;
        } else {
            System.out.println(c + ". Атаковать");
            c++;
            System.out.println(c + ". Отступить");
            c++;
        }
        System.out.println(c + ". Ждать");
        c++;
        System.out.println(c + ". Выпить зелье лечения");
        c++;
        System.out.println(c + ". Забрать");
        c++;
        System.out.println(c + ". Купить зелье");

        input = sc.nextInt();
        switch (input) {
            case 1: {
                if (mosterLive) {
                    yDamage = hero.attack();
                    moster.getDamage(yDamage);
                    if (moster.isLive()) {
                        System.out.println("Вы нанесли " + yDamage + " урона мостру. У него осталось " + moster.hp + " здоровья");
                    }
                    else {
                        money=moster.getMoney();
                        exp= moster.getExp();
                        hero.addExp(exp);
                        hero.addMoney(money);
                        System.out.println("Вы убили мостра и получили "+money+" золота и "+exp+" опыта");
                        return;
                    }
                }
                if (knightLive) {
                    yDamage = hero.attack();
                    knight.getDamage(yDamage);
                    if (knight.isLive()) {
                        System.out.println("Вы нанесли " + yDamage + " урона рыцарю. У него осталось " + knight.hp + " здоровья");
                    } else {
                        money = knight.getMoney();
                        exp = knight.getExp();
                        hero.addMoney(money);
                        hero.addExp(exp);
                        System.out.println("Вы убили рыцаря и получили " + money + " золота и " + exp + " опыта");
                        return;
                    }
                }

                break;
            }
            case 2:
            {
                if (mosterLive)
                {
                    moster.heal();
                    back=true;
                }
                if (knightLive)
                {
                    knight.heal();
                    back=true;
                }
                break;
            }
            case 3:
            {
                if(inFight==0)
                {
                    hero.heal();
                }
                break;
            }
            case 4:
            {
                if(inFight==0)
                {
                    if(buf==2)
                        hero.addMoney(r.nextInt(50)*complexity);
                    if(buf==3)
                        hero.addExp(r.nextInt(150)*complexity);
                    if(buf==4)
                        hero.addHeal(r.nextInt(complexity));
                }
                else
                {
                    hero.heal();
                }
                break;
            }
            case 5:
            {
                if(inFight>0)
                {
                    if(buf==2)
                        hero.addMoney(r.nextInt(50)*complexity);
                    if(buf==3)
                        hero.addExp(r.nextInt(150)*complexity);
                    if(buf==4)
                        hero.addHeal(r.nextInt(complexity));
                }
                else
                    hero.buyHeal();
                break;
            }
            case 6:
            {
                hero.buyHeal();
                break;
            }
        }
    }

    public void enemyAction() {
        int eDamage;
        if (mosterLive && !back) {
            if (hero.isLive() && moster.isLive()) {
                eDamage = moster.attack();
                hero.getDamage(eDamage);
                System.out.println("Мостр нанес вам " + eDamage + " урона");

            } else {
                inFight=0;
            }
        }
        if(knightLive && !back) {
            if (hero.isLive() && knight.isLive()) {
                eDamage = knight.attack();
                hero.getDamage(eDamage);
                System.out.println("Рыцарь нанес вам " + eDamage + " урона");
            } else {
                inFight=0;
            }
        }
    }

    public int GameEnd()
    {
        if(crown)
            return 2;
        if(!hero.isLive())
            return 1;
        return 0;
    }
}
