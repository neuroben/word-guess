package game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static game.Player.players;
import static java.lang.Integer.parseInt;

public class FileUtil
{
    /*
    public static void writeToFile(String fileName, String content)
    {
        try (FileWriter writer = new FileWriter(fileName))
        {
            writer.write(content);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
*/
    //create players based on the imported file
    public static List<Player> importPlayers(String fileName)
    {
        List<Player> players = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {

                Player newPlayer = new Player();

                newPlayer.setName(line.split(",",2)[0]);
                newPlayer.setScore(parseInt(line.split(",",2)[1]));

                players.add(newPlayer);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return players;
    }
    public static List<String> importWords(String fileName)
    {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                words.add(line);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        /*
        for (int i = 0; i < words.size(); i++)
        {
            System.out.println(words.get(i));
        }
        */
        return words;
    }
    public static void saveProgress() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("players.csv"))) {
            for (Player player : players) {
                writer.write(player.getName() + "," + player.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing players to file: " + e.getMessage());
        }
    }
}
