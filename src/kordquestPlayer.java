public class kordquestPlayer
{
    private int healthPoints;
    private int gameDifficulty;
    private int[][] location = {{0,1,2},{3,4,5},{6,7,8}};

    private int x = 1;
    private int y = 0;

    public kordquestPlayer(int difficulty)
    {
        gameDifficulty = difficulty;
        switch (difficulty)
        {
            case 1: healthPoints = 60; break;
            case 2: healthPoints = 50; break;
            case 3: healthPoints = 40; break;
        }
    }

    // Get current health
    public int currentHP()
    {
        return healthPoints;
    }

    // Damage player
    public void damage(int value)
    {
        healthPoints -= value;
    }

    // Attack
    public int attack(int choice, kordquestEnemy enemy)
    {
        switch (choice)
        {
            case 1:
                System.out.println("You stab " + enemy.getName() + "! " + enemy.getName() + " takes 6 damage.");
                return 6;
            case 2:
                System.out.println("You cut " + enemy.getName() + "! " + enemy.getName() + " takes 3 damage.");
                return 3;
            case 3:
                System.out.println("You slap " + enemy.getName() + "! " + enemy.getName() + " takes 1 damage.");
                return 1;
            default:
                System.out.println("Invalid attack! You deal 0 damage.");
                return 0;
        }
    }

    // Get final score
    public int score()
    {
        return healthPoints * gameDifficulty;
    }

    // Get current location
    public int getLocation()
    {
        return location[y][x];
    }

    // Validate location
    private boolean validLocation(int xCoord, int yCoord)
    {
        return (xCoord <= 2 && xCoord >= 0 && yCoord <= 2 && yCoord >= 0);
    }

    // North
    public void moveNorth()
    {
        if (validLocation(x,y+1))
            y += 1;
        else
            System.out.println("Invalid move!");
    }

    // South
    public void moveSouth()
    {
        if (validLocation(x,y-1))
            y -= 1;
        else
            System.out.println("Invalid move!");
    }

    // East
    public void moveEast()
    {
        if (validLocation(x+1,y))
            x += 1;
        else
            System.out.println("Invalid move!");
    }

    // West
    public void moveWest()
    {
        if (validLocation(x-1,y))
            x -= 1;
        else
            System.out.println("Invalid move!");
    }
}
