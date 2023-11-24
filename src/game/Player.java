package game;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    String name;
    int score;

    public void setName(String name){
        this.name = name;
    }
    public void setScore(int score){
        this.score = score;
    }

    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }

    public static List<Player> newPlayer()
    {
        List<Player> players = FileUtil.importPlayers("players.csv");

        Scanner input = new Scanner(System.in);
        Player newPlayer = new Player();

        /*for (Player player : players) {
            System.out.println(player.getName() + " " + player.getScore());
        }*/

        System.out.println("Enter your name:");
        String inName = input.nextLine();

        //checking if name already exits
        for (Player player : players) {
            if (Objects.equals(player.getName(), inName)) {
                System.out.println("Welcome back: " + inName + "! Your score is: " + player.getScore() + " Do you to delete your scores? (Y/N)");
                if (Objects.equals(input.nextLine(), "Y")) {
                    player.setScore(0);
                    return players;
                }else {
                    return players;
                }
            }
        }
        newPlayer.setName(inName);
        newPlayer.setScore(0);
        players.add(newPlayer);

        return players;

    }
    //public static List<Words>
}
