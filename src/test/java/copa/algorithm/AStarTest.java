package copa.algorithm;

import copa.mapgraph.MapGraph;
import java.io.File;
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
    public void constructorWorksifmapGraphOk() throws Exception {
        assertNotNull(astar);
    }
}
