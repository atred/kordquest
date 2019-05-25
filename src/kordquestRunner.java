import java.util.Scanner;

public class kordquestRunner
{
    private static Scanner userIn = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(" _                 _                       _    ");
        System.out.println("| |               | |                     | |   ");
        System.out.println("| | _____  _ __ __| | __ _ _   _  ___  ___| |_  ");
        System.out.println("| |/ / _ \\| '__/ _` |/ _` | | | |/ _ \\/ __| __| ");
        System.out.println("|   < (_) | | | (_| | (_| | |_| |  __/\\__ \\ |_  ");
        System.out.println("|_|\\_\\___/|_|  \\__,_|\\__, |\\__,_|\\___||___/\\__| ");
        System.out.println("                        | |                     ");
        System.out.println("                        |_|                     ");

        play();
    }

    private static void play()
    {
        System.out.println("You wake up in a small bed inside a hut.");
        System.out.println("There is an old man sitting in a chair, waiting for you to wake up.");
        System.out.println("When the man see's you've woken up, he helps you out of the bed and gives you");
        System.out.println("your sword.");

        boolean difficultySelect = true;
        int diff = 0;
        while (difficultySelect)
        {
            System.out.println("\n\"Hello, my name's Dungarth. How experienced are you with that sword of yours?\"");
            System.out.println("(select difficulty)");
            System.out.println("1 - You've barely used it");
            System.out.println("2 - You've used it a few times");
            System.out.println("3 - You're extremely proficient");

            diff = userIn.nextInt();
            if (diff > 0 && diff < 4) difficultySelect = false;
            else System.out.println("Invalid input - please try again.");
        }

        kordquestPlayer player = new kordquestPlayer(diff);

        if (diff == 1)
            System.out.println("\"Well, I'm sure you'll be fine.\"");
        else if (diff == 2)
            System.out.println("\"Great! You're just who I've been looking for!\"");
        else
            System.out.println("\"Spectacular! You're the perfect man to help me!\"");

        System.out.println("\"You see, I've been having trouble with an evil sorcerer named Kord.\"");
        System.out.println("\"He lives atop Grand Mountain, which is 2 miles directly north along the main path.");
        System.out.println("\"I need you to go defeat him for me. Now, there's a town meeting soon. Off you go!\"");

        // Main gameplay loop
        boolean fighting = false;
        Explore:
        while (!fighting)
        {
            // Get output
            switch(player.getLocation())
            {
                case 0:
                    System.out.println("There is a town here, but the gates are shut. A sign on the gates reads");
                    System.out.println("\"Town closed for meeting. Come back later.\" The town sprawls out to the");
                    System.out.println("south and west, blocking your path.");
                    break;
                case 1:
                    System.out.println("You are outside a hut on a hill overlooking the county of Ostana.");
                    System.out.println("South of you is the ocean, and there are paths to the north, east, and west.");
                    break;
                case 2:
                    System.out.println("Your paths to the south and east and south are blocked by a swamp.");
                    System.out.println("There is nothing else of interest here.");
                    break;
                case 3:
                    System.out.println("To the west lies a vast forest, with trees so densely packed you cannot");
                    System.out.println("proceed through them.");
                    break;
                case 4:
                    System.out.println("You arrive at a crossroads, with a path going in each direction.");
                    break;
                case 5:
                    System.out.println("You reach an old abandoned mine, heavily barricaded to the east.");
                    break;
                case 6:
                    System.out.println("To the north and west the path crumbles away to a ragged cliff.");
                    break;
                case 7:
                    System.out.println("You climb up Grand Mountain and see an evil old sorcerer at the top.");
                    fighting = true;
                    break Explore;
                case 8:
                    System.out.println("To the north and east the path crumbles away to a ragged cliff.");
                    break;
            }

            // Get input
            System.out.println();
            System.out.println("[n]orth -- [s]outh -- [e]ast -- [w]est");
            System.out.print("Enter command: ");
            char movement = userIn.next().toLowerCase().charAt(0);

            // Move player
            if (movement == 'n') player.moveNorth();
            else if (movement == 's') player.moveSouth();
            else if (movement == 'e') player.moveEast();
            else if (movement == 'w') player.moveWest();
            else System.out.println("Invalid input - please try again");
        }

        kordquestEnemy kord = new kordquestEnemy("Kord", 60);
        System.out.println("\nCombat begins! Kord moves first.");

        // Combat loop
        while (fighting)
        {
            player.damage(kord.attack());
            if (player.currentHP() <= 0) break;

            System.out.println("What do you do?");
            System.out.println("[1] Stab -- [2] Cut -- [3] Slap");
            System.out.print("Enter command: ");
            kord.damage(player.attack(userIn.nextInt(), kord));
            System.out.println();
            if (kord.currentHP() <= 0)
                fighting = false;
        }

        System.out.println("\n\n");
        if (player.currentHP() > 0)
            System.out.println(" ---YOU WON---");
        else
            System.out.println(" --- YOU LOST---");

        System.out.println("Final score: " + player.score());
    }




}
