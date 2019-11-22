
package copa.mapgraph;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

   /**
     * MapGraph object that creates a 2D array out of map files.
     * @author Jari Salojuuri,
     */

public class MapGraph {
    
    public Node [][] mapGraph = new Node[429][431];
    
    /** Constructor for MapGraph
     * @param mapFile .map file from https://movingai.com/benchmarks/grids.html.
     */
    public MapGraph(File mapFile) throws Exception {
        
        /** creates 2D Node array */
        try (Scanner s = new Scanner(new FileReader(mapFile))) {
            while (s.hasNextLine()) {
                for (int i=0; i<mapGraph.length; i++) {
                    String[] line = s.nextLine().trim().split("");
                    for (int j=0; j<mapGraph[0].length; j++) {
                        mapGraph[i][j] = new Node(i,j,line[j]);
                    }
                }
            }
        }
        
        /** creates node neighbours */
        for (int i=0; i<mapGraph.length; i++) {
            for (int j=0; j<mapGraph[0].length; j++) {
                List<Node> neighbours = new ArrayList<>();
                if (i+1<mapGraph.length) {
                    neighbours.add(mapGraph[i+1][j]);
                }
                if (i-1>=0) {
                    neighbours.add(mapGraph[i-1][j]);
                }
                if (j+1<mapGraph[0].length) {
                    neighbours.add(mapGraph[i][j+1]);
                }
                if (j-1>=0) {
                    neighbours.add(mapGraph[i][j-1]);
                }
                if (i+1<mapGraph.length && j+1<mapGraph[0].length) {
                    neighbours.add(mapGraph[i+1][j+1]);
                }
                if (i-1>=0 && j-1>=0) {
                    neighbours.add(mapGraph[i-1][j-1]);
                }
                if (i-1>=0 && j+1<mapGraph[0].length) {
                    neighbours.add(mapGraph[i-1][j+1]);
                }
                if (i+1<mapGraph.length && j-1>=0) {
                    neighbours.add(mapGraph[i+1][j-1]);
                }
                mapGraph[i][j].setNeighbours(neighbours);
            }
        }
        
    }

    /** prints map from 2D-array */
    public void printMapFromGraph() {
        for (int i=0; i<mapGraph.length; i++) {
            for (int j=0; j<mapGraph[0].length; j++) {
                System.out.print(mapGraph[i][j].getType());
            }
            System.out.println("");
        }
    }
   
    public Node [][] getMapGraph() {
        return mapGraph;
    }
    
    /** searches starting Node from mapGraph 
     * @return start node
     */
    public Node searchStartNode() {
        for (int i=0; i<mapGraph.length; i++) {
            for (int j=0; j<mapGraph[0].length; j++) {
                if (mapGraph[i][j].getType().equals("S")) {
                    return mapGraph[i][j];
                }   
            } 
        }
        return null;
    }
    
    /** searches finish Node from mapGraph 
     * @return finish node
     */
    public Node searchFinishNode() {
        for (int i=0; i<mapGraph.length; i++) {
            for (int j=0; j<mapGraph[0].length; j++) {
                if (mapGraph[i][j].getType().equals("F")) {
                    return mapGraph[i][j];
                }   
            } 
        }
        return null;
    }
}
