
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
            System.out.println("Options: \n[1] Print map \n[2] Breadth-First Search \n[3] Uniform Cost Search \n[4] Greedy Best First Search \n[5] A* Search \n[q] Quit");
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
                UCS ucs = new UCS(mapGraph);
                ucs.startAlgorithm();
            }
            
            if (input.equals("4")) {
                GBF gbf = new GBF(mapGraph);
                gbf.startAlgorithm();
            }
            
            if (input.equals("5")) {
                AStar astar = new AStar(mapGraph);
                astar.startAlgorithm();
            }
            
            if (input.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }
        }    
    } 
}
