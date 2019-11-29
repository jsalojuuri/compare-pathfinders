package copa.algorithm;

import copa.mapgraph.Node;
import copa.mapgraph.MapGraph;
import java.util.PriorityQueue;
import java.util.Queue;

/**
  * A* Algorithm for selected map.
  * @author Jari Salojuuri,
  */
public class AStar {
    
    /** map as a graph */
    private MapGraph mapGraph;
    
    public AStar(MapGraph mapGraph) {   
        this.mapGraph = mapGraph;
    }

    /** starts A* algorithm */
    public void startAlgorithm() {

        /** initialise algorithm  */
        int nodesVisited = 0;
        Node start = mapGraph.searchStartNode();
        Node finish = mapGraph.searchFinishNode();
        boolean [][] visited = new boolean[mapGraph.mapGraph.length][mapGraph.mapGraph[0].length];
        boolean [][] noticed = new boolean[mapGraph.mapGraph.length][mapGraph.mapGraph[0].length];
        /** A* priority queue uses AstarNodeComparator class to prioritise nodes */
        Queue<Node> queue = new PriorityQueue<>(new AStarNodeComparator());
        Node currentNode;
        
        /** set starting node distance from finish node and add it to priority queue */
        start.setDistanceFromFinish(finish);
        queue.add(start);
        /** set starting node as noticed */
        noticed[start.getRow()][start.getCol()] = true;
        
        
        while (!queue.isEmpty()) {
            
            /** check if too many nodes are being visited */
            if (nodesVisited > 100000) {
                System.out.println("Something went wrong, too many nodes visited!");
                break;
            }
            /** take next node from queue and set as current node */
            currentNode = queue.poll();
            
            /** if node is not yet visited, set as visited */
            if (!visited[currentNode.getRow()][currentNode.getCol()]) {
                visited[currentNode.getRow()][currentNode.getCol()] = true;
                /** if current node equals to finish node, report statistics and end loop */
                if (currentNode.getType().equals("F")) {
                    System.out.println("GOAL " + currentNode + " REACHED! " 
                            + "\nNodes visited: " +nodesVisited 
                            + "\nPath cost: " +currentNode.getPathCost() 
                            + "\nPath length: " +currentNode.getPathLength());
                    break;
                /** if current node does not equal to finish node, check its neighbours and continue processing them only if they have not been noticed before */
                } else {
                    for (Node neighbour: currentNode.getNeighbours()) {
                        if (!noticed[neighbour.getRow()][neighbour.getCol()]) {
                            /** if neighbour locates in impassable terrain, mark it as noticed BUT do not add to queue */
                            if (neighbour.getType().equals("@")) {
                                noticed[neighbour.getRow()][neighbour.getCol()] = true;
                            /** if neighbour locates in timbered terrain, mark it as noticed AND set its distance from finish node AND add to queue AND increase path length by 1, cost by 5 */    
                            } else if(neighbour.getType().equals("T")) {
                                neighbour.setPathLength(currentNode.getPathLength() +1);
                                neighbour.setPathCost(currentNode.getPathCost() +5);
                                neighbour.setDistanceFromFinish(finish);
                                queue.add(neighbour);
                                noticed[neighbour.getRow()][neighbour.getCol()] = true;
                            /** if neighbour locates in passable terrain, mark it as noticed AND set its distance from finish node AND add to queue AND increase path length by 1, cost by 1 */    
                            } else {
                                neighbour.setPathLength(currentNode.getPathLength() +1);
                                neighbour.setPathCost(currentNode.getPathCost() +1);
                                neighbour.setDistanceFromFinish(finish);
                                queue.add(neighbour);
                                noticed[neighbour.getRow()][neighbour.getCol()] = true;
                            }
                        }
                    }
                    /** increase count of nodes visited by 1 */   
                    nodesVisited += 1;
                }
            } 
        }   
    } 
}
