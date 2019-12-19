package copa.utils;

import copa.util.PriorityQueue;
import copa.algorithm.GBFNodeComparator;
import copa.algorithm.UCSNodeComparator;
import copa.mapgraph.MapGraph;
import copa.mapgraph.Node;
import java.io.File;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 * tests for own PriorityQueue class
 * @author salojuur
 */
public class PriorityQueueTest {
    private File mapFile;
    private MapGraph mapGraph;
    private PriorityQueue<Node> gbfPriorityQueue;
    private PriorityQueue<Node> ucsPriorityQueue;
    private Node node1;
    private Node node2;
    
    @Before
    public void setUp() throws Exception {
        mapFile = new File("./static/brc204d_mod.map");
        mapGraph = new MapGraph(mapFile); 
        this.gbfPriorityQueue = new PriorityQueue<>(new GBFNodeComparator());
        this.ucsPriorityQueue = new PriorityQueue<>(new UCSNodeComparator());
        this.node1 = mapGraph.searchStartNode();
        this.node2 = mapGraph.searchFinishNode();
    }
    
    @Test
    public void constructorWorks() {
        assertEquals(0, gbfPriorityQueue.size());
        assertEquals(true, gbfPriorityQueue.isEmpty());
    }
    
    @Test
    public void gbfAddAndPollNodes() {
        node1.setDistanceFromFinish(node2);
        node2.setDistanceFromFinish(node2);
        gbfPriorityQueue.add(node1);
        gbfPriorityQueue.add(node2);
        assertEquals(2, gbfPriorityQueue.size());
        Node node3 = gbfPriorityQueue.poll();
        assertEquals(1, gbfPriorityQueue.size());
        assertEquals(0, node3.getDistanceFromFinish());
    }
    
    @Test
    public void ucsAddAndPollNodes() {
        node1.setPathCost(10);
        node2.setPathCost(1);
        ucsPriorityQueue.add(node1);
        ucsPriorityQueue.add(node2);
        assertEquals(2, ucsPriorityQueue.size());
        Node node3 = ucsPriorityQueue.poll();
        assertEquals(1, ucsPriorityQueue.size());
        assertEquals(1, node3.getPathCost());
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pollThrowsExceptionIfQueueIsEmpty() {
        gbfPriorityQueue = new PriorityQueue<>(new GBFNodeComparator());
        gbfPriorityQueue.poll();
    }
}
