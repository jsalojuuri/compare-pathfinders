package copa.algorithm;

import copa.mapgraph.MapGraph;
import copa.mapgraph.Node;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for GBFNodeComparator class
 * @author salojuur
 */
public class GBFNodeComparatorTest {
    private File mapFile;
    private MapGraph mapGraph;
    private GBFNodeComparator gbfNodeComparator;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
        gbfNodeComparator = new GBFNodeComparator();
    }
    
    @Test
    public void compareWorks() throws Exception {
        Node node1 = mapGraph.searchFinishNode();
        Node node2 = mapGraph.searchStartNode();
        node1.setDistanceFromFinish(node1);
        node2.setDistanceFromFinish(node1);
        assertEquals(-1, gbfNodeComparator.compare(node1, node2));
        assertEquals(1, gbfNodeComparator.compare(node2, node1));
        assertEquals(0, gbfNodeComparator.compare(node1, node1));
    }
}
