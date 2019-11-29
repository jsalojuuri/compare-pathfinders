
package copa.mapgraph;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

   /**
     * MapGraph object that creates a 2D array out of map files.
     * @author Jari Salojuuri,
     */

public final class MapGraph {
    
    public Node [][] mapGraph = new Node[429][431];
    public Node start;
    public Node finish;
    
    /** Constructor for MapGraph
     * @param mapFile .map file from https://movingai.com/benchmarks/grids.html.
     * @throws java.lang.Exception
     */
    public MapGraph(File mapFile) throws Exception {
        create2DNodeArray(mapFile);
        createNodeNeigbours();
        setRandomPassableTerrainNodeType(mapGraph.length, mapGraph[0].length, "S");
        setRandomPassableTerrainNodeType(mapGraph.length, mapGraph[0].length, "F");
    }
 
    /** Creates 2D Node array from map file 
     * @param mapFile map file
     * @throws java.lang.Exception
     */
    public void create2DNodeArray(File mapFile) throws Exception {
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
    }
    
    public void createNodeNeigbours() {    
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
        for (Node[] mapGraph1 : mapGraph) {
            for (int j = 0; j<mapGraph[0].length; j++) {
                System.out.print(mapGraph1[j].getType());
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
        return this.start;
    }
    
    /** searches finish Node from mapGraph 
     * @return finish node
     */
    public Node searchFinishNode() {
        return this.finish;
    }
    
    /** sets 
     * @param maxRow max array length
     * @param maxCol max array[0] length
     * @param nodeType node type
     * random start and finish nodes */
    private void setRandomPassableTerrainNodeType(int maxRow, int maxCol, String nodeType) {     
        int row;
        int col;
        while (true) {
            row = new Random().nextInt(maxRow);
            col = new Random().nextInt(maxCol);
            if (mapGraph[row][col].getType().equals(".")) {
                mapGraph[row][col].setType(nodeType);
                if (nodeType.equals("S")) {
                    this.start = new Node(row, col, nodeType);
                }
                if (nodeType.equals("F") && (this.start.getCol() != col || this.start.getRow() != row)) {
                    this.finish = new Node(row, col, nodeType);
                }
                break;
            }         
        }
    }
    
    
}
