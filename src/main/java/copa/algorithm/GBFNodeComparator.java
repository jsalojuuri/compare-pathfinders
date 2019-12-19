package copa.algorithm;

import copa.mapgraph.Node;
import java.util.Comparator;

/** 
 * Node comparator for Greedy Best First algorithm. Uses distance to finish node metric to rank nodes.
 * @author salojuur
 */
public class GBFNodeComparator implements Comparator<Node> {
    
    /** 
     * Compares two nodes based on Manhattan distance to finish node.
     * @param node1 first node
     * @param node2 second node
     * @return returns 1 if node 1 sum value is greater than node 2, return -1 if vice versa and 0 if sum values are equal
     */
    @Override
    public int compare(Node node1, Node node2) {
        
        if (node1.getDistanceFromFinish() > node2.getDistanceFromFinish()) {
            return 1;
        }
        if (node1.getDistanceFromFinish() < node2.getDistanceFromFinish()) {
            return -1;
        }
        return 0;
        
    }
}
