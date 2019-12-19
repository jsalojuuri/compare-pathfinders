package copa.utils;

import copa.mapgraph.MapGraph;
import copa.mapgraph.Node;
import copa.util.ArrayDeque;
import copa.util.ArrayList;
import java.io.File;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Tests for own ArrayList class
 * @author salojuur
 */
public class ArrayListTest {
    private File mapFile;
    private MapGraph mapGraph;
    private ArrayList<Node> list;
    private Node node1;
    private Node node2;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
        this.list = new ArrayList<>();
        this.node1 = mapGraph.searchStartNode();
        this.node2 = mapGraph.searchFinishNode();
    }
    
    @Test
    public void listSizeIsZeroWhenInstanceCreated() {
        assertEquals(0, list.size());
    }
    
    @Test
    public void addAndGetNodes() {
        list.add(node1);
        list.add(node2);
        list.add(node1);
        list.add(node2);
        list.add(node1);
        list.add(node2);
        assertEquals(6, list.size());
        assertEquals(node1, list.get(0));
        assertEquals(6, list.size());
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getWithNegativeIndexThrowsException() {
        list = new ArrayList<>();
        list.get(-1);
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getWithBiggerIndexThanSizeThrowsException() {
        list = new ArrayList<>();
        list.get(1);
    }
    
    
}
