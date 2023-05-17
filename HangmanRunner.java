import java.util.*;
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
    public static void main(String[] args) {
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
        while (!blanks.equals(letters) && tries < 8) {
            System.out.println(stages[tries] + "\n");
            for (String s : blanks) {
                System.out.print(s + " ");
            }
            System.out.println("\nEnter Letter:");
            String nextln = scan.nextLine();
            //UNIT 3 - Boolean Expressions
            if (nextln.length() != 1) {
                System.out.println("Only type one letter!");
            } else {
                if (letters.contains(nextln)) {
                    for (int i = 0; i < letters.size(); i++) {
                        if (letters.get(i).equals(nextln)) {
                            blanks.set(i, nextln);
                        }
                    }
                } else {
                    tries++;                 
                }
            }
        }
        if (tries >= 8) {
            System.out.println(stage8 + "\nYOU LOST!");
        } else {
            System.out.println("YOU WON! Word was: " + word + ".\nYou had " + tries + " false attempts.");
        }
        System.out.println("Would you like to play again? y / n");
        String nextln2 = scan.nextLine();
        if (nextln2.equals("y")) {
            // UNIT 10 : RECURSION
            main(null);
        } else {
            return;
        }
    }
}
