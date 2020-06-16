package NewRPG;

public class EnemyMonster extends Character {
    public EnemyMonster(int hp, int complexity)
    {
        super(hp,complexity);
    }
    @Override
    public int attack(int lvl)
    {
        return r.nextInt(80/complexity+lvl);
    }
}
