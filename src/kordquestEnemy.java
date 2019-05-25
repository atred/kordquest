public class kordquestEnemy
{
    private String name;
    private int healthPoints;

    // Constructor
    public kordquestEnemy(String myName, int hp)
    {
        name = myName;
        healthPoints = hp;
    }

    // Damage enemy
    public void damage(int value)
    {
        healthPoints -= value;
    }

    // Attack
    public int attack()
    {
        int num = (int)(Math.random()*3 + 1);
        switch (num)
        {
            case 1:
                System.out.println(name + " shoots a fireball at you! You take 6 damage.");
                return 6;
            case 2:
                System.out.println(name + " shoots an icicle at you! You take 3 damage.");
                return 3;
            case 3:
                System.out.println(name + " hits you with his staff! You take 1 damage.");
                return 1;
            default:
                return 0;
        }
    }

    // Get name
    public String getName()
    {
        return name;
    }

    // Get health
    public int currentHP()
    {
        return healthPoints;
    }
}
