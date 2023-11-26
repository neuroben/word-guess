package game;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    String name;
    int score;
    static Player activePlayer = new Player();

    static List<Player> players = FileUtil.importPlayers("players.csv");

    public static Player getActivePlayer() {
        return activePlayer;
    }

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

    public static void newPlayer()
    {


        Scanner input = new Scanner(System.in);
        Player newPlayer = new Player();


        /*for (Player player : players) {
            System.out.println(player.getName() + " " + player.getScore());
        }*/

        System.out.print("Enter your name: ");
        String inName = input.nextLine();
        Format.hLine();

        //checking if name already exits
        for (Player player : players) {
            if (Objects.equals(player.getName(), inName)) {
                System.out.println("Welcome back: " + inName + "! Your score is: " + player.getScore() + " Do you to delete your scores? (Y/N)");
                if (Objects.equals(input.nextLine().toUpperCase().charAt(0), 'Y')) {
                    player.setScore(0);
                    activePlayer = player;
                    System.out.println("Score set to: 0");
                    Format.hLine();
                    return;
                }else {
                    activePlayer = player;
                    System.out.println("Score unchanged.");
                    Format.hLine();
                    return;
                }
            }
        }
/*
        for (int i = 0; i < players.size(); i++){
            System.out.println(i + ". játékos neve: " + players.get(i).getName() + " játékos pontszáma: " + players.get(i).getScore());
        }
*/
        newPlayer.setName(inName);
        newPlayer.setScore(0);
        players.add(newPlayer);
        activePlayer = newPlayer;
    }
}
