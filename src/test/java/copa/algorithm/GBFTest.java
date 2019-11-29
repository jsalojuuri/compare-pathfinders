package copa.algorithm;

import copa.mapgraph.MapGraph;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author salojuur
 */
public class GBFTest {
    private File mapFile;
    private MapGraph mapGraph;
    private GBF gbf;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
        gbf = new GBF(mapGraph);
    }
    
    @Test
    public void constructorWorks() throws Exception {
        assertNotNull(gbf);
    }
    
    @Test
    public void algoSetupWorks() {
        gbf.algoSetup();
        assertEquals(1,gbf.queue.size());
        assertEquals(true,gbf.noticed[gbf.start.getRow()][gbf.start.getCol()]);
    }
    
    @Test
    public void currentNodeNotNullWhenAlgoStarted() {
        gbf.algoSetup();
        gbf.startAlgorithm();
        assertNotNull(gbf.currentNode);
    }
}
