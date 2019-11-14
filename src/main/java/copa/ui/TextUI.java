
package copa.ui;

import copa.logic.MapGraph;
import java.util.Scanner;

/**
 *
 * @author salojuur
 */
public class TextUI implements UI {
    
    private Scanner scanner;
    private MapGraph map;
    
    public TextUI(Scanner scanner, MapGraph map) {
        this.scanner = scanner;
        this.map = map;
    }
    
    @Override
    public void start() {
        System.out.println("Compare Pathfinder Algorithms");
        
        while (true) {
            System.out.println("Options: \n[1] Print map \n[2] Quit");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                map.printMapFromArray();
            }    
            
            if (input.equals("2")) {
                System.out.println("Goodbye!");
                break;
            }
        }    
    } 
}
