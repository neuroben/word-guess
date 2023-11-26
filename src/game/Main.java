package game;

public class Main
{
    public static void main(String[] args)
    {
        /*
        Scanner input = new Scanner(System.in);
        Player[] players;


        System.out.println("How many players do you want to input?");
        int playerCount = parseInt(input.nextLine());

        players = new Player[playerCount];
/*
        for (int i = 0; i < playerCount; i++)
        {
            players[i] = new Player(); //Initializing eac Player object

            System.out.println(i + 1 + ". Player\nname:");
            players[i].setName(input.nextLine());
            System.out.println("score:");
            players[i].setScore(parseInt(input.nextLine()));


        }


        for (int i = 0; i < playerCount; i++)
        {
            System.out.println(i + ". player's name: " + players[i].getName() + " Score: " + players[i].getScore());
        }
*/

        Player.newPlayer();
        Game.guessing();
        FileUtil.saveProgress();


    }
}