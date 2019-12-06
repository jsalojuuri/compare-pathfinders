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
public class AStarTest {
    private File mapFile;
    private MapGraph mapGraph;
    private AStar astar;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
        astar = new AStar(mapGraph);
    }
    
    @Test
    public void constructorWorks() throws Exception {
        assertNotNull(astar);
    }
    
    @Test
    public void algoSetupWorks() {
        astar.algoSetup();
        assertEquals(true, astar.noticed[astar.start.getRow()][astar.start.getCol()]);
    }
    
    @Test
    public void currentNodeNotNullWhenAlgoStarted() {
        astar.startAlgorithm();
        assertNotNull(astar.currentNode);
    }

}
