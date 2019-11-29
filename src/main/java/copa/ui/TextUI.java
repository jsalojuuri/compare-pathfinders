
package copa.ui;

import copa.algorithm.AStar;
import copa.algorithm.BFS;
import copa.algorithm.GBF;
import copa.algorithm.UCS;
import copa.mapgraph.MapGraph;
import copa.mapgraph.Node;
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
            System.out.print("Options: "
                    + "\n[1] Print map "
                    + "\n[2] Compare Algorithms "
                    + "\n[q] Quit"
                    + "\n");
            
            String input = scanner.nextLine();

            /** prints map */
            if (input.equals("1")) {
                mapGraph.printMapFromGraph();
                System.out.println("\nMAP SIZE: " + mapGraph.mapGraph.length + " rows, "
                        + mapGraph.mapGraph[0].length + " columns");
                System.out.println("START NODE coordinates: " + mapGraph.searchStartNode().toString());
                System.out.println("FINISH NODE coordinates: " + mapGraph.searchFinishNode().toString() + "\n");        
            }   

            if (input.equals("2")) {
                System.out.println("\nBFS:");
                BFS bfs = new BFS(mapGraph);
                bfs.startAlgorithm();
                System.out.println("\nUCS:");
                UCS ucs = new UCS(mapGraph);
                ucs.startAlgorithm();
                System.out.println("\nGBF:");
                GBF gbf = new GBF(mapGraph);
                gbf.startAlgorithm();
                System.out.println("\nA*");
                AStar astar = new AStar(mapGraph);
                astar.startAlgorithm();
                System.out.println("");
            }
            
            if (input.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }
        }    
    } 
}
