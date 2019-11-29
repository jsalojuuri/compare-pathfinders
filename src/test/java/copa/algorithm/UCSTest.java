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
public class UCSTest {
    private File mapFile;
    private MapGraph mapGraph;
    private UCS ucs;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
        ucs = new UCS(mapGraph);
    }
    
    @Test
    public void constructorWorks() throws Exception {
        assertNotNull(ucs);
    }
}
