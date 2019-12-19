package copa.algorithm;

import copa.mapgraph.Node;
import java.util.Comparator;

/** 
 * Node comparator for A* Search. Uses both path cost from start node and distance to finish node metrics to rank nodes.
 * @author salojuur
 */
public class AStarNodeComparator implements Comparator<Node> {
    
    /** 
     * Compares two nodes based on the sum of path cost from start node and Manhattan distance to finish node.
     * @param node1 first node
     * @param node2 second node
     * @return returns 1 if node 1 sum value is greater than node 2, return -1 if vice versa and 0 if sum values are equal
     */
    @Override
    public int compare(Node node1, Node node2) {
        if ((node1.getDistanceFromFinish() + node1.getPathCost()) > (node2.getDistanceFromFinish() + node2.getPathCost())) {
            return 1;
        }
        if ((node1.getDistanceFromFinish() + node1.getPathCost()) < (node2.getDistanceFromFinish() + node2.getPathCost())) {
            return -1;
        }
        return 0;
    }
}
