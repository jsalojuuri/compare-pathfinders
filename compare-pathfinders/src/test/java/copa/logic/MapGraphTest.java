package copa.logic;

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
    public void constructorWorksForMapGraph() {
        File mapFile = new File("./static/brc204d_mod.map");
        String [][] mapArray = new String[429][431];
        try (Scanner s = new Scanner(new FileReader(mapFile))) {
            while (s.hasNextLine()) {
                for (int i=0; i<mapArray.length; i++) {
                    String[] line = s.nextLine().trim().split("");
                    for (int j=0; j<mapArray[0].length; j++) {
                        mapArray[i][j] = line[j];
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in reading file");
        }
        
        assertEquals("@", mapArray[0][0]);
        assertEquals("T", mapArray[0][20]);
        
    }
    
}
