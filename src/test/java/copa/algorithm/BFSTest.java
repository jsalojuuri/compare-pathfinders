package copa.algorithm;

import copa.mapgraph.MapGraph;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for BFS class
 * @author salojuur
 */
public class BFSTest {
    private File mapFile;
    private MapGraph mapGraph;
    private BFS bfs;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
        bfs = new BFS(mapGraph);
    }
    
    @Test
    public void constructorWorks() throws Exception {
        assertNotNull(bfs);
    }
    
    @Test
    public void algoSetupWorks() {
        bfs.algoSetup();
        assertEquals(1, bfs.queue.size());
        assertEquals(true, bfs.noticed[bfs.start.getRow()][bfs.start.getCol()]);
    }
    
    @Test
    public void currentNodeNotNullWhenAlgoStarted() {
        bfs.algoSetup();
        bfs.startAlgorithm();
        assertNotNull(bfs.currentNode);
    }
}
