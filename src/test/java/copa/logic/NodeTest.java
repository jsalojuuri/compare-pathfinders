/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copa.logic;

import copa.mapgraph.Node;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
    public void basicGettersAndToStringWork() {
        Node node = new Node(1,2,".");
        assertEquals(1,node.getRow());
        assertEquals(2,node.getCol());
        assertEquals(".",node.getType());
        assertEquals("(1,2) .",node.toString());
    }
    
    
    
    
}
