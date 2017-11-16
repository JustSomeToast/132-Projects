/*
 * Property of no one in particular. Open Project Properties to change this.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab2;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Tyler
 */
public class InputFile {

    private String fileName;
    private static ArrayList<Integer> array;

    public InputFile() {
        array = new ArrayList();
        String newInput = "";
        File file = new File(newInput);
        Scanner f = new Scanner(System.in);

        while (!file.exists()) {
            System.out.print("Please enter the name of the input file > ");
            newInput = f.nextLine();
            file = new File(newInput);

            try {
                Scanner ints = new Scanner(file);

                while (ints.hasNextInt()) {
                    if (ints.hasNextInt()) {
                        int i = ints.nextInt();
                        array.add(i);
                    } else {
                        array.add(0);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("That file cannot be found, please use a valid file");
            }
        }
    }

    public String getFile() {
        return fileName;
    }

    public int getInts(int element) {
        return array.get(element);
    }
}
