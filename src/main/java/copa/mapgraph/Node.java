package copa.mapgraph;

import copa.util.ArrayList;

/**
 * Node object that is required by MapGraph object
 * @author salojuur
 */
public class Node {   
    private int row;
    private int col;
    private String type;
    private int pathLength;
    private int pathCost;
    private int distanceFromFinish;
    private ArrayList<Node> neighbours;
    
    /**
     * Constructor for Node instance
     * @param row horizontal location on map graph
     * @param col vertical location on map graph
     * @param type Node type, that can be "." (normal terrain), "T" (tree terrain), "@" (impassable terrain), "S" (start node) or "F" (finish node)
     */
    public Node (int row, int col, String type) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.pathLength = 0;
        this.pathCost = 0;
        this.distanceFromFinish = 0;
        this.neighbours = new ArrayList<>();       
    }
  
    /**  
     * Calculates Manhattan distance between current and finish node
     * @param finishNode last node of the path
     */
    public void setDistanceFromFinish(Node finishNode) {
        this.distanceFromFinish = Math.abs(finishNode.getRow() - this.getRow()) + Math.abs(finishNode.getCol() - this.getCol()); 
    }
    
    public void increasePathLength() {
        this.pathLength++;
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPathLength() {
        return pathLength;
    }

    public void setPathLength(int pathLength) {
        this.pathLength = pathLength;
    }
    
    public int getPathCost() {
        return pathCost;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public int getDistanceFromFinish() {
        return distanceFromFinish;
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }
    
    public Node getNeighbour(int i) {
        return this.neighbours.get(i);
    }

    public void setNeighbours(ArrayList<Node> neighbours) {
        this.neighbours = neighbours;
    }
    
    @Override
    public String toString() {
        return "(" + row + "," + col + ") " + type;
    }   
}
