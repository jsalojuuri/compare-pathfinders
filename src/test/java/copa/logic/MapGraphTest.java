package copa.logic;

import copa.mapgraph.MapGraph;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for MapGraph class
 * @author salojuur
 */
public class MapGraphTest {
    
    @Before
    public void setUp() {

    }
    
    @Test
    public void constructorWorks() throws Exception {
        File mapFile = new File("./static/brc204d_mod.map");
        MapGraph mapGraph = new MapGraph(mapFile);
        assertNotNull(mapGraph);
    }
    
    @Test
    public void searchStartNode() throws Exception {
        File mapFile = new File("./static/brc204d_mod.map");
        MapGraph mapGraph = new MapGraph(mapFile);
        assertEquals("S",mapGraph.searchStartNode().getType());
    }
    
    @Test
    public void searchFinishNode() throws Exception {
        File mapFile = new File("./static/brc204d_mod.map");
        MapGraph mapGraph = new MapGraph(mapFile);
        assertEquals("F",mapGraph.searchFinishNode().getType());
    }
    
    @Test
    public void getMapGraph() throws Exception {
        File mapFile = new File("./static/brc204d_mod.map");
        MapGraph mapGraph = new MapGraph(mapFile);
        assertNotNull(mapGraph.getMapGraph());
    }
    

    
}
