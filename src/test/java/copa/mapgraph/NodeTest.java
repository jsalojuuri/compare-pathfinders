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
    
    Node basicNode;
    
    @Before
    public void setUp() {
        basicNode = new Node(1,2,".");
    }
    
    @Test
    public void constructorWorks() {
        assertNotNull(basicNode);
    }
    
    @Test
    public void basicGettersWorkForNewNode() {
        assertEquals(1,basicNode.getRow());
        assertEquals(2,basicNode.getCol());
        assertEquals(".",basicNode.getType());
        assertEquals(0,basicNode.getPathLength());
        assertEquals(0,basicNode.getPathCost());
    }
    
    @Test
    public void basicSettersWork() {
        basicNode.setRow(2);
        basicNode.setCol(3);
        basicNode.setType("S"); 
        
        assertEquals(2,basicNode.getRow());
        assertEquals(3,basicNode.getCol());
        assertEquals("S",basicNode.getType());
    }
    
    @Test
    public void pathLength() {
        int currentPathLength = basicNode.getPathLength();
        basicNode.setPathLength(currentPathLength +1);
        basicNode.increasePathLength();
        assertEquals(2,basicNode.getPathLength());
    }
    
    @Test
    public void pathCost() {
        int currentPathCost = basicNode.getPathCost();
        basicNode.setPathCost(currentPathCost +5);
        assertEquals(5,basicNode.getPathCost());
    }
    
    @Test
    public void toStringWorks() {
        assertEquals("(1,2) .",basicNode.toString());
    }
    
    @Test
    public void distanceToFinishWorks() {
        Node start = new Node(1,3,"S");
        Node finish = new Node(1,4,"F");
        start.setDistanceFromFinish(finish);
        assertEquals(1.0, start.getDistanceFromFinish(), 0.01);
    }
    
    @Test
    public void setAndGetNeighboursWorks() {
        Node start = new Node(1,3,"S");
        Node finish = new Node(1,4,"F");
        List<Node> neighbours = new ArrayList<>();
        neighbours.add(finish);
        start.setNeighbours(neighbours);
        assertNotNull(start.getNeighbours());
    }
    
 
}
