import java.util.*;
/**
 * Final project, who knows what this does?
* Joshua Alessi - APCSA
 */
public class BrowserStuff
{
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome - type help");
        String nextLine = scan.nextLine();
        if (nextLine.equals("help")) { helpCmd(); }
    }
    public void helpCmd() {
        
        System.out.println("--- Help ---");
        System.out.println("login <username>");

    }
    public void clearConsole() {
        for (int i = 0; i < 1000; i++) {
            System.out.println();
        }
    }
}
