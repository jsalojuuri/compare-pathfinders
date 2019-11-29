package copa.mapgraph;

import copa.mapgraph.MapGraph;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for MapGraph class
 * @author salojuur
 */
public class MapGraphTest {
    
    private File mapFile;
    private MapGraph mapGraph;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
    }
    
    @Test
    public void constructorWorks() throws Exception {
        assertNotNull(mapGraph);
    }
    
    @Test
    public void searchStartNode() throws Exception {
        assertEquals("S",mapGraph.searchStartNode().getType());
    }
    
    @Test
    public void searchFinishNode() throws Exception {
        assertEquals("F",mapGraph.searchFinishNode().getType());
    }
    
    @Test
    public void getMapGraph() throws Exception {
        assertNotNull(mapGraph.getMapGraph());
    }
    
    /*
    @Test
    public void mapGraphNodesHaveNeighbours() {
        Node start = mapGraph.searchStartNode();
        List<Node> neighbours = start.getNeighbours();
        assertEquals(8,neighbours.size());
    }
     */ 
}
