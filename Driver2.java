/*
 * Property of no one in particular. Open Project Properties to change this.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab2;

import java.io.*;

/**
 *
 * @author Tyler
 */
public class Driver2 {

    private static int index = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        InputFile file = new InputFile();
        OutputWriter.fileWriter("Program 4");
        OutputWriter.fileWriter("\n---------\n");

        while (file.getInts(index) != 0) {
            LinkedList list = new LinkedList(1);
            int n = file.getInts(index);
            index++;
            int k = file.getInts(index);
            index++;
            int m = file.getInts(index);
            index++;
            for (int i = n; i > 1; i--) {
                list.add(new Node(i));
            }
            OutputWriter.fileWriter("\nN = " + n + ", k = " + k + ", m = " + m + "\n");
            OutputWriter.fileWriter("\nOutput");
            OutputWriter.fileWriter("\n---------\n");
            list.Selector(k, m);
            OutputWriter.fileWriter("---------\n");
        }
        OutputWriter.fileWriter("\nEnd of Program 4\n");
    }
}
