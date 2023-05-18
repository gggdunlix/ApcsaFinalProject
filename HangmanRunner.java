import java.util.*;
import java.awt.*;
/**
 * Hang man runner class, allows you to play the game of hangman with the computer!
 *
 * Purpose is to allow you to play hangman with yourself 
 * with a list of random words.
 *
 * Version 1.0
 * Written by Joshua Alessi and Ahmet Demirbas
 */
public class HangmanRunner
{
    public static String stage1 = "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========";
    public static String stage2 = "  +---+\n  |   |\n  o   |\n      |\n      |\n      |\n=========";
    public static String stage3 = "  +---+\n  |   |\n  o   |\n  |   |\n      |\n      |\n=========";
    public static String stage4 = "  +---+\n  |   |\n  o   |\n \\|   |\n      |\n      |\n=========";
    public static String stage5 = "  +---+\n  |   |\n  o   |\n \\|/  |\n      |\n      |\n=========";
    public static String stage6 = "  +---+\n  |   |\n  o   |\n \\|/  |\n  |   |\n      |\n=========";
    public static String stage7 = "  +---+\n  |   |\n  o   |\n \\|/  |\n  |   |\n /    |\n=========";
    public static String stage8 = "  +---+\n  |   |\n  o   |\n \\|/  |\n  |   |\n / \\  |\n=========";
    public static String[] stages = {stage1, stage2, stage3, stage4, stage5, stage6, stage7, stage8};
    public static ArrayList<String> usedLetters = new ArrayList<>();
    public static void main(String[] args) {
        usedLetters.clear();
        usedLetters.add("a");
        usedLetters.add("b");
        usedLetters.add("c");
        usedLetters.add("d");
        usedLetters.add("e");
        usedLetters.add("f");
        usedLetters.add("g");
        usedLetters.add("h");
        usedLetters.add("i");
        usedLetters.add("j");
        usedLetters.add("k");
        usedLetters.add("l");
        usedLetters.add("m");
        usedLetters.add("n");
        usedLetters.add("o");
        usedLetters.add("p");
        usedLetters.add("q");
        usedLetters.add("r");
        usedLetters.add("s");
        usedLetters.add("t");
        usedLetters.add("u");
        usedLetters.add("v");
        usedLetters.add("w");
        usedLetters.add("x");
        usedLetters.add("y");
        usedLetters.add("z");
        ArrayList<String> list = ListClass.getWordList();
        //UNIT 1 - Primitive Types
        int result = (int) (Math.random() * ((list.size() - 1) - 0 + 1)) + 0;
        String word = list.get(result);
        ArrayList<String> letters = new ArrayList<>();
        for (int l = 0; l < word.length(); l++) {
            // UNIT 4 - Loops & Iterations
            char o = word.charAt(l);
            letters.add(String.valueOf(o));
        }
        Scanner scan = new Scanner(System.in);
        ArrayList<String> blanks = new ArrayList<>();
        for (int i = 0; i < letters.size(); i++) {
            blanks.add("_");
        }
        int tries = 0;
        while (!blanks.equals(letters) && tries < 7) {
            System.out.println(stages[tries] + "\n\nUnused letters:");
            for (String s : usedLetters) {
                System.out.print(s + " ");
            }
            System.out.println("\n");
            for (String s : blanks) {
                System.out.print(s + " ");
            }
            System.out.println("\n\n\nEnter Letter:");
            String nextln = scan.nextLine();
            //UNIT 3 - Boolean Expressions
            if (nextln.length() != 1) {
                System.out.println("Only type one letter!");
            } else {
                if (usedLetters.contains(nextln)) {
                    if (letters.contains(nextln)) {
                        for (int i = 0; i < letters.size(); i++) {
                            if (letters.get(i).equals(nextln)) {
                                blanks.set(i, nextln);
                            }
                        }
                    } else {
                        tries++;                 
                    }
                    usedLetters.set(usedLetters.indexOf(nextln), "*");
                } else {
                    System.out.println("You already guessed letter \"" + nextln + "\".");
                }
            }
        }
        if (tries >= 7) {
            System.out.println(stage8 + "\nYOU LOST!");
        } else {
            System.out.println("YOU WON! Word was: " + word + ".\nYou had " + tries + " false attempts.");
        }
        System.out.println("Would you like to play again? y / n");
        // USES CLASSES FOUND ONLINE
        Frame againPanel = new Frame("Hangman");
        againPanel.pack();
        againPanel.add(new Button("Quit"));
        againPanel.add(new Button("Play Again"));
        againPanel.setVisible(true);
        String nextln2 = scan.nextLine();
        if (nextln2.equals("y")) {
            againPanel.setVisible(false);
            // UNIT 10 : RECURSION
            main(null);
        } else {
            againPanel.setVisible(false);
            return;
        }
        
        
    }
}
