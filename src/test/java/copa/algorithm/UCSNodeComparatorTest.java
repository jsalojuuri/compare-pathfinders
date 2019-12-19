package copa.algorithm;

import copa.mapgraph.MapGraph;
import copa.mapgraph.Node;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for UCSNodeComparator class
 * @author salojuur
 */
public class UCSNodeComparatorTest {
    private File mapFile;
    private MapGraph mapGraph;
    private UCSNodeComparator ucsNodeComparator;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
        ucsNodeComparator = new UCSNodeComparator();
    }
    
    @Test
    public void compareWorks() throws Exception {
        Node node1 = mapGraph.searchFinishNode();
        Node node2 = mapGraph.searchStartNode();
        node2.setPathCost(10);
        assertEquals(-1, ucsNodeComparator.compare(node1, node2));
        assertEquals(1, ucsNodeComparator.compare(node2, node1));
        assertEquals(0, ucsNodeComparator.compare(node1, node1));
    }
}
