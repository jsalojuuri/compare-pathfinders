
package copa.logic;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

   /**
     * MapGraph object that creates a 2D array out of map files.
     * @author Jari Salojuuri,
     */

public class MapGraph {
    
    String [][] mapArray = new String[429][431];
    ArrayList<String> mapArraylist = new ArrayList<>();
    
    /** Constructor for MapGraph
     * @param mapFile .map file from https://movingai.com/benchmarks/grids.html.
     */
    public MapGraph(File mapFile) throws Exception {
        
        /** create 2D Array map */
        try (Scanner s = new Scanner(new FileReader(mapFile))) {
            while (s.hasNextLine()) {
                for (int i=0; i<mapArray.length; i++) {
                    String[] line = s.nextLine().trim().split("");
                    for (int j=0; j<mapArray[0].length; j++) {
                        mapArray[i][j] = line[j];
                    }
                }
            }
        }
        
        /** create ArrayList map */
        try (Scanner s = new Scanner(new FileReader(mapFile))) {
            while (s.hasNext()) {
                mapArraylist.add(s.nextLine());
            }
        }
    }

    /** prints map from 2D-array */
    public void printMapFromArray() {
        for (int i=0; i<mapArray.length; i++) {
            for (int j=0; j<mapArray[0].length; j++) {
                System.out.print(mapArray[i][j]);
            }
            System.out.println("");
        }
    }
    
    /** prints map from ArrayList */
    public void printMapFromArraylist() {
        for (String s: mapArraylist) {
            System.out.println(s);
        }
    }
    
    public ArrayList<String> getMapArraylist() {
        return mapArraylist;
    }
    
    public String [][] getMapArray() {
        return mapArray;
    }
    
    
    
}
