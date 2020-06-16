package NewRPG;

public class EnenmyKnight extends Character {
    public EnenmyKnight(int hp,int complexity)
    {
        super(hp,complexity);
    }
    @Override
    public int attack(int lvl)
    {
        return r.nextInt(40/complexity +lvl);
    }
}
