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
        Node finish = mapGraph.searchFinishNode();
        Node node1 = mapGraph.searchStartNode();
        node1.setDistanceFromFinish(finish);
        assertEquals(1,gbfNodeComparator.compare(node1, finish));
    }
}
