package copa.main;

import copa.mapgraph.MapGraph;
import copa.ui.*;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author salojuur
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        File file = new File("./static/brc204d_mod.map");
        MapGraph map = new MapGraph(file);;
        
        UI ui = new TextUI(scanner, map);
        ui.start();
       
    }
}
