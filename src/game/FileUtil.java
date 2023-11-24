package game;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                String name;
                int score;

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
}
