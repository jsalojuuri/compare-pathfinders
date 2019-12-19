
package copa.ui;

import copa.algorithm.*;
import copa.mapgraph.MapGraph;
import java.util.Scanner;

   /**
     * Textual user interface to compare algorithms and print map.
     * @author Jari Salojuuri,
     */
public class TextUI implements UI {
    
    private final Scanner scanner;
    private final MapGraph mapGraph;
    
    public TextUI(Scanner scanner, MapGraph mapGraph) {
        this.scanner = scanner;
        this.mapGraph = mapGraph;
    }
    
    @Override
    public void start() {
        System.out.println("Compare Pathfinder Algorithms");
        
        while (true) {
            System.out.print("Options: "
                    + "\n[1] Print map "
                    + "\n[2] Compare Algorithms "
                    + "\n[q] Quit"
                    + "\n");
            
            String input = scanner.nextLine();

            if (input.equals("1")) {
                printMap();
            }   


            if (input.equals("2")) {
                compareAlgorithms();
            }
            
            if (input.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }
        }    
    }
    
    /** Prints map */
    public void printMap() {
        mapGraph.printMapFromGraph();
        System.out.println("\nMAP SIZE: " + mapGraph.mapGraph.length + " rows, "
                + mapGraph.mapGraph[0].length + " columns");
        System.out.println("START NODE coordinates: " + mapGraph.searchStartNode().toString());
        System.out.println("FINISH NODE coordinates: " + mapGraph.searchFinishNode().toString() + "\n"); 
    }
    
    /** Compares algorithms */
    public void compareAlgorithms() {                    
        System.out.println("\nBFS:");
        PathAlgorithm bfs = new BFS(mapGraph);
        bfs.startAlgorithm();

        System.out.println("\nUCS:");
        PathAlgorithm ucs = new UCS(mapGraph);
        ucs.startAlgorithm();

        System.out.println("\nGBF:");
        PathAlgorithm gbf = new GBF(mapGraph);
        gbf.startAlgorithm();

        System.out.println("\nA*");
        PathAlgorithm astar = new AStar(mapGraph);
        astar.startAlgorithm();
        System.out.println("");
    }
}
