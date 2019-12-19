package copa.utils;

import copa.mapgraph.MapGraph;
import copa.mapgraph.Node;
import copa.util.ArrayDeque;
import java.io.File;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests for own ArrayDeque class
 * @author salojuur
 */
public class ArrayDequeTest {
    private File mapFile;
    private MapGraph mapGraph;
    private ArrayDeque<Node> bfsArrayDeque;
    private Node node1;
    private Node node2;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
        this.bfsArrayDeque = new ArrayDeque<>();
        this.node1 = mapGraph.searchStartNode();
        this.node2 = mapGraph.searchFinishNode();
    }
    
    @Test
    public void queueIsEmptyAndItsSizeIsZeroWhenInstanceCreated() {
        assertEquals(0, bfsArrayDeque.size());
        assertEquals(true, bfsArrayDeque.isEmpty());
    }
    
    @Test
    public void addAndPollNodes() {
        node1.setDistanceFromFinish(node2);
        node2.setDistanceFromFinish(node2);
        bfsArrayDeque.add(node1);
        bfsArrayDeque.add(node2);
        assertEquals(2, bfsArrayDeque.size());
        Node node3 = bfsArrayDeque.poll();
        assertEquals(1, bfsArrayDeque.size());
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pollThrowsExceptionIfQueueIsEmpty() {
        bfsArrayDeque = new ArrayDeque<>();
        bfsArrayDeque.poll();
    }
}
