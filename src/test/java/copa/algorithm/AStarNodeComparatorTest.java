package copa.algorithm;

import copa.mapgraph.MapGraph;
import copa.mapgraph.Node;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author salojuur
 */
public class AStarNodeComparatorTest {
    private File mapFile;
    private MapGraph mapGraph;
    private AStar astar;
    private AStarNodeComparator aStarNodeComparator;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
        aStarNodeComparator = new AStarNodeComparator();
    }
    
    @Test
    public void compareWorks() throws Exception {
        Node finish = mapGraph.searchFinishNode();
        Node node1 = mapGraph.searchStartNode();
        Node node2 = mapGraph.searchFinishNode();
        node1.setDistanceFromFinish(finish);
        node2.setDistanceFromFinish(finish);
        node2.setPathCost(1);
        assertEquals(1,aStarNodeComparator.compare(node1, node2));
    }
}
