
package copa.mapgraph;

import copa.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;


   /**
     * MapGraph object that creates a 2D array out of map files.
     * @author Jari Salojuuri,
     */

public class MapGraph {
    
    public Node [][] mapGraph = new Node[429][431];
    public Node start;
    public Node finish;
    
    /** 
     * Constructor for MapGraph instance
     * @param mapFile .map file from https://movingai.com/benchmarks/grids.html.
     * @throws java.lang.Exception
     */
    public MapGraph(File mapFile) throws Exception {
        create2DNodeArray(mapFile);
        createNodeNeigbours();
        setRandomPassableTerrainNodeType(mapGraph.length, mapGraph[0].length, "S");
        setRandomPassableTerrainNodeType(mapGraph.length, mapGraph[0].length, "F");
    }
 
    /**  
     * Creates 2D Node array from map file
     * @param mapFile map file
     * @throws java.lang.Exception
     */
    public void create2DNodeArray(File mapFile) throws Exception {
        try (Scanner s = new Scanner(new FileReader(mapFile))) {
            while (s.hasNextLine()) {
                for (int i = 0; i < mapGraph.length; i++) {
                    String[] line = s.nextLine().trim().split("");
                    for (int j = 0; j < mapGraph[0].length; j++) {
                        mapGraph[i][j] = new Node(i, j, line[j]);
                    }
                }
            }
        }
    }
    
    /** Creates neighbouring nodes for all map nodes */
    public void createNodeNeigbours() {    
        for (int i = 0; i < mapGraph.length; i++) {
            for (int j = 0; j < mapGraph[0].length; j++) {
                ArrayList<Node> neighbours = new ArrayList<>();
                
                if (i + 1 < mapGraph.length) {
                    neighbours.add(mapGraph[i + 1][j]);
                }
                if (i - 1 >= 0) {
                    neighbours.add(mapGraph[i - 1][j]);
                }
                if (j + 1 < mapGraph[0].length) {
                    neighbours.add(mapGraph[i][j + 1]);
                }
                if (j - 1 >= 0) {
                    neighbours.add(mapGraph[i][j - 1]);
                }          
                mapGraph[i][j].setNeighbours(neighbours);
            }
        }
    }
    
    /** Prints map from 2D-array */
    public void printMapFromGraph() {
        for (Node[] mapGraph1 : mapGraph) {
            for (int j = 0; j < mapGraph[0].length; j++) {
                System.out.print(mapGraph1[j].getType());
            }
            System.out.println("");
        }
    }
   
    public Node [][] getMapGraph() {
        return mapGraph;
    }
    
    /** 
     * Searches starting Node from mapGraph 
     * @return start node
     */
    public Node searchStartNode() {
        return this.start;
    }
    
    /** 
     * Searches finish Node from mapGraph 
     * @return finish node
     */
    public Node searchFinishNode() {
        return this.finish;
    }
    
    /** 
     * Sets random start and finish nodes
     * @param maxRow max array length
     * @param maxCol max array[0] length
     * @param nodeType node type
     */
    private void setRandomPassableTerrainNodeType(int maxRow, int maxCol, String nodeType) {     
        int row;
        int col;
        while (true) {
            row = new Random().nextInt(maxRow);
            col = new Random().nextInt(maxCol);
            if (mapGraph[row][col].getType().equals(".")) {
                mapGraph[row][col].setType(nodeType);
                if (nodeType.equals("S")) {
                    Node s = mapGraph[row][col];
                    s.setType(nodeType);
                    this.start = s;
                }
                if (nodeType.equals("F") && (this.start.getCol() != col || this.start.getRow() != row)) {
                    Node f = mapGraph[row][col];
                    f.setType(nodeType);
                    this.finish = f;
                }
                break;
            }         
        }
    } 
}
