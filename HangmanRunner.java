import java.util.*;
/**
 * Write a description of class HangmanRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HangmanRunner
{
    public static String stage1 = "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========";
    public static String stage2 = "  +---+\n  |   |\n  o   |\n      |\n      |\n      |\n=========";
    public static String stage3 = "  +---+\n  |   |\n  o   |\n  |   |\n      |\n      |\n=========";
    public static String stage4 = "  +---+\n  |   |\n  o   |\n \\|   |\n      |\n      |\n=========";
    public static String stage5 = "  +---+\n  |   |\n  o   |\n \\|/  |\n      |\n      |\n=========";
    public static String stage6 = "  +---+\n  |   |\n  o   |\n \\|/  |\n      |\n      |\n=========";
    public static String stage7 = "  +---+\n  |   |\n  o   |\n \\|/  |\n      |\n      |\n=========";
    
    public static void main(String[] args) {
        ArrayList<String> list = ListClass.getWordList();
        int result = (int) (Math.random() * ((list.size() - 1) - 0 + 1)) + 0;
        String word = list.get(result);
        System.out.println(stage2);
    }
}
