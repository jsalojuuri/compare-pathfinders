package copa.algorithm;

import copa.mapgraph.Node;
import copa.mapgraph.MapGraph;
import java.util.PriorityQueue;
import java.util.Queue;

   /** Uniform Cost Search Algorithm for selected map.
     * @author Jari Salojuuri,
     */
public class UCS {
    
    private MapGraph mapGraph;
    int nodesVisited;
    Node start;
    Node finish;
    boolean [][] visited;
    boolean [][] noticed;
    Queue<Node> queue;
    Node currentNode;
    
    public UCS(MapGraph mapGraph) {
        this.mapGraph = mapGraph;
        this.nodesVisited = 0;
        this.start = mapGraph.searchStartNode();
        this.finish = mapGraph.searchFinishNode();
        this.visited = new boolean[mapGraph.mapGraph.length][mapGraph.mapGraph[0].length];
        this.noticed = new boolean[mapGraph.mapGraph.length][mapGraph.mapGraph[0].length];
        this.queue = new PriorityQueue<>(new UCSNodeComparator());  
    }
    
    /** set starting node distance from finish node and it to priority queue, set starting node as noticed */
    public void algoSetup() {             
        start.setDistanceFromFinish(finish);
        queue.add(start);
        noticed[start.getRow()][start.getCol()] = true;
    }

    /** starts UCS algorithm */
    public void startAlgorithm() {    

        algoSetup();
        
        while (!queue.isEmpty()) {
            
            /** check if path is too long */
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
                                queue.add(neighbour);
                                noticed[neighbour.getRow()][neighbour.getCol()] = true;
                            /** if neighbour locates in passable terrain, mark it as noticed AND set its distance from finish node AND add to queue AND increase path length and cost by 1 */    
                            } else {
                                neighbour.setPathLength(currentNode.getPathLength() +1);
                                neighbour.setPathCost(currentNode.getPathCost() +1);
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

