/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copa.logic;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

   /**
     * Breath First Algorithm for selected map.
     * @author Jari Salojuuri,
     */
public class BFS {
    
    private MapGraph mapGraph;
    
    public BFS(MapGraph mapGraph) {
        try {
            this.mapGraph = mapGraph;
        } catch (Exception e) {
            System.out.println("BFS constructor produced an error");
        }
    }
    
    /** starts BFS algorithm */
    public void startAlgorithm() {

        int pathLength = 0;
        Node start = mapGraph.searchStartNode();
        boolean [][] visited = new boolean[mapGraph.mapGraph.length][mapGraph.mapGraph[0].length];
        Queue<Node> queue = new ArrayDeque<>();
        Node currentNode;
        
        queue.add(start);
        
        while (!queue.isEmpty()) {
            
            if (pathLength > 10000) {
                System.out.println("Something went wrong, path too long!");
                break;
            }
            
            currentNode = queue.poll();
            System.out.println(currentNode);
            visited[currentNode.getRow()][currentNode.getCol()] = true;
            
            
            if (currentNode.getType().equals("F")) {
                System.out.println("Path length: " +pathLength);
                break;
            } else {
                for (Node neighbour: currentNode.getNeighbours()) {
                    if (!visited[neighbour.getRow()][neighbour.getCol()]) {
                        queue.add(neighbour);
                    }
                    
                }
                pathLength += 1;
            }
        }   
    } 
}
