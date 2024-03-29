package copa.algorithm;

import copa.mapgraph.Node;
import copa.mapgraph.MapGraph;
import copa.util.PriorityQueue;

   /** 
     * Uniform Cost Search PathAlgorithm for selected map.
     * @author Jari Salojuuri,
     */
public class UCS implements PathAlgorithm {
    
    private MapGraph mapGraph;
    int nodesVisited;
    Node start;
    Node finish;
    boolean [][] visited;
    boolean [][] noticed;
    PriorityQueue<Node> queue;
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
    @Override
    public void algoSetup() {             
        start.setDistanceFromFinish(finish);
        queue.add(start);
        noticed[start.getRow()][start.getCol()] = true;
    }

    /** starts UCS algorithm */
    @Override
    public void startAlgorithm() {    

        algoSetup();
        
        while (!queue.isEmpty()) {
            /** take next node from queue and set as current node */
            currentNode = queue.poll();
            
            /** if node is not yet visited, set as visited */
            if (!visited[currentNode.getRow()][currentNode.getCol()]) {
                visited[currentNode.getRow()][currentNode.getCol()] = true;
                /** if current node equals to finish node, report statistics and end loop */
                if (currentNode.getType().equals("F")) {
                    System.out.println("GOAL " + currentNode + " REACHED! " 
                            + "\nNodes visited: " + nodesVisited 
                            + "\nPath cost: " + currentNode.getPathCost());
                    break;
                /** if current node does not equal to finish node, check its neighbours and continue processing them only if they have not been noticed before */
                } else {
                    for (int i = 0; i < currentNode.getNeighbours().size(); i++) {
                        Node neighbour = currentNode.getNeighbour(i);
                        if (!noticed[neighbour.getRow()][neighbour.getCol()]) {
                            /** if neighbour locates in impassable terrain, mark it as noticed BUT do not add to queue */
                            if (neighbour.getType().equals("@")) {
                                noticed[neighbour.getRow()][neighbour.getCol()] = true;
                            /** if neighbour locates in timbered terrain, mark it as noticed AND set its distance from finish node AND add to queue AND increase path length by 1, cost by 5 */    
                            } else if (neighbour.getType().equals("T")) {
                                neighbour.setPathLength(currentNode.getPathLength() + 1);
                                neighbour.setPathCost(currentNode.getPathCost() + 5);
                                queue.add(neighbour);
                                noticed[neighbour.getRow()][neighbour.getCol()] = true;
                            /** if neighbour locates in passable terrain, mark it as noticed AND set its distance from finish node AND add to queue AND increase path length and cost by 1 */    
                            } else {
                                neighbour.setPathLength(currentNode.getPathLength() + 1);
                                neighbour.setPathCost(currentNode.getPathCost() + 1);
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

