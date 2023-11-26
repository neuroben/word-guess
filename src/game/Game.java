package game;

import java.util.*;

import static java.lang.Math.round;


public class Game {

    private static final List<Character> charArray = new ArrayList<>();
    private static String stringValue = "";
    private static final String baseWord = selectWord();



    //private static String word;
    public static String selectWord(){
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        List<String> words = FileUtil.importWords("wordList.txt");
        char difficulty;

        System.out.println("Choose difficulty: easy --> 'E' / medium --> 'M' / hard --> 'H'");

        //testing input while not correct
        do {
            difficulty = input.next().toUpperCase().charAt(0);
            System.out.println("easy --> 'E' / medium --> 'M' / hard --> 'H'");
        }while (difficulty != 'E' && difficulty != 'M' && difficulty != 'H');
        System.out.println(difficulty);

        //changing the words list to the matching diff
        //hidding letters in the word, using enchanced switch
        words = switch (difficulty) {
            case 'E' -> FileUtil.importWords("easy.txt");
            case 'M' -> FileUtil.importWords("medium.txt");
            case 'H' -> FileUtil.importWords("hard.txt");
            default -> words;
        };

        //randomly choosing a word

        //System.out.println(""random.nextInt(words.size()));
        return words.get(random.nextInt(words.size()));
    }

    public static void hiddenWord() {
        List<Integer> replacedIndices = new ArrayList<>();
        StringBuilder hidWord = new StringBuilder(baseWord);

        for (int i = 0; i < baseWord.length() / 2; i++) {
            int randomIndex = getRandomIndex(baseWord.length(), replacedIndices);

            replacedIndices.add(randomIndex);
            charArray.add(baseWord.charAt(randomIndex));
            hidWord.setCharAt(randomIndex, '_');
        }


        stringValue = hidWord.toString();


    }
    public static void guessing(){
        Scanner input = new Scanner(System.in);
        hiddenWord();
        System.out.println(baseWord);

        System.out.println("You have to fill the empy letters: " + stringValue);
        int guessCount = (int) round(charArray.size() * 1.5);
        /*System.out.println("Base word: " + baseWord);
        System.out.println("CharArray: " + charArray);
        System.out.println("geussCount: " + guessCount);
        System.out.println("hidden word: " + stringValue);*/
        //cycle while the user make the word
        while (!Objects.equals(baseWord, stringValue) && guessCount > 0) {
            System.out.println("Guess count: " + guessCount);
            System.out.print("Make a guess: \n");
            char inGuess = input.next().toLowerCase().charAt(0);
            boolean correctGuess = false;
            //iterating on the letters in the string
            for (int i = 0; i < baseWord.length(); i++){
                if(baseWord.charAt(i) == inGuess && stringValue.charAt(i) == '_'){
                    stringValue = stringValue.substring(0, i) + inGuess + stringValue.substring(i + 1);
                    
                    System.out.println("Thats right! The new word is: " + stringValue);
                    guessCount--;
                    correctGuess = true;
                }
            }
            if(!correctGuess) {
                System.out.println("Not right! " + stringValue);
                guessCount--;
            }

        }
        if(guessCount > 0){
            System.out.println("win");
        } else if (guessCount == 0) {
            System.out.println("lose");
        }


    }
    private static int getRandomIndex(int maxValue, List<Integer> excludedIndices) {
        Random random = new Random();

        int randomIndex;
        do {
            randomIndex = random.nextInt(maxValue);
        } while (excludedIndices.contains(randomIndex));

        return randomIndex;
    }

    /*
        int PINA;


        String hidWordS = null;
        if (baseWord.length() == 3) {
            PINA = random.nextInt(3);
            char originalChar = baseWord.charAt(PINA);
            originalCharacters.add(originalChar);
            hidWord.setCharAt(PINA, '_');
        } else {
            char[] replacement = baseWord.toCharArray();
            for (int i = 0; i < hidWord.length() / 2; i++) {

                PINA = random.nextInt(baseWord.length());
                char originalChar2 = baseWord.charAt(PINA);

                // Convert the word to a char array
                replacement[PINA] = '_';

                // Replace the characters in the StringBuilder
                while (replacement[PINA] == '_') {
                    PINA = random.nextInt(baseWord.length());
                    replacement[PINA] = '_';

                }


                hidWordS = new String(replacement);

                // Print the modified StringBuilder


                originalCharacters.add(originalChar2);
            }


        }
*/
}
