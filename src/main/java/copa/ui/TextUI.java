
package copa.ui;

import copa.logic.BFS;
import copa.logic.MapGraph;
import copa.logic.Node;
import java.util.List;
import java.util.Scanner;

   /**
     * Textual user interface to compare algorithms and print map.
     * @author Jari Salojuuri,
     */
public class TextUI implements UI {
    
    private Scanner scanner;
    private MapGraph mapGraph;
    
    public TextUI(Scanner scanner, MapGraph mapGraph) {
        this.scanner = scanner;
        this.mapGraph = mapGraph;
    }
    
    @Override
    public void start() {
        System.out.println("Compare Pathfinder Algorithms");
        
        while (true) {
            System.out.println("Options: \n[1] Print map \n[2] BFS \n[3] Test \n[q] Quit");
            String input = scanner.nextLine();

            /** prints map */
            if (input.equals("1")) {
                mapGraph.printMapFromGraph();
            }   
            
            /** Breadth-First-Search algorithm */
            if (input.equals("2")) {
                BFS bfs = new BFS(mapGraph);
                bfs.startAlgorithm();

            }
            
            if (input.equals("3")) {
                Node start = mapGraph.searchStartNode();
                List<Node> neighbours = start.getNeighbours();
                for (Node neighbour: neighbours) {
                    System.out.println(neighbour.getType() + " ");
                }

            }
            
            if (input.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }
        }    
    } 
}
