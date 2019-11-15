/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copa.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salojuur
 */
public class Node {
    
    private int row;
    private int col;
    private String type;
    private int pathLength;
    private double distanceFromFinish;
    private List<Node> neighbours;
    
    public Node (int row, int col, String type) {
        
        this.row = row;
        this.col = col;
        this.type = type;
        this.pathLength = 0;
        this.distanceFromFinish = Double.MAX_VALUE;
        this.neighbours = new ArrayList<>();
        
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

    public double getDistanceFromFinish() {
        return distanceFromFinish;
    }

    public void setDistanceFromFinish(double distanceFromFinish) {
        this.distanceFromFinish = distanceFromFinish;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public String toString() {
        return "("+row+","+col+") " +type;
    }

    
    
    
    
}
