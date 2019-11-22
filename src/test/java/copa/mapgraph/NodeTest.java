/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copa.mapgraph;

import copa.mapgraph.Node;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author salojuur
 */
public class NodeTest {
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void constructorWorks() {
        Node node = new Node(1,1,".");
        assertNotNull(node);
    }
    
    @Test
    public void basicGettersWorkForNewNode() {
        Node node = new Node(1,2,".");
        assertEquals(1,node.getRow());
        assertEquals(2,node.getCol());
        assertEquals(".",node.getType());
        assertEquals(0,node.getPathLength());
        assertEquals(0,node.getPathCost());
    }
    
    @Test
    public void toStringWorks() {
        Node node = new Node(1,2,".");
        assertEquals("(1,2) .",node.toString());
    }
    
    @Test
    public void distanceToFinishWorks() {
        Node start = new Node(1,2,"S");
        Node finish = new Node(1,3,"F");
        start.setDistanceFromFinish(finish);
        assertEquals(1.0, start.getDistanceFromFinish(), 0.01);
    }
    
    @Test
    public void getNeighboursWorks() {
        Node start = new Node(1,2,"S");
        Node finish = new Node(1,3,"F");
        List<Node> neighbours = new ArrayList<>();
        neighbours.add(finish);
        start.setNeighbours(neighbours);
        assertNotNull(start.getNeighbours());
    }
    
    
    
    
}
