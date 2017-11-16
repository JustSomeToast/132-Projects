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
public class OutputWriter {

    private static String outputFile = "LinkedListProgram.txt";
    
    public static void fileWriter(String in) { //writing basic lines
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
            bw.write(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveToFile1(String inFile, String inText, boolean ap) {  //writes number then a space
        try {
            File f = new File(inFile);
            FileWriter fw = new FileWriter(f, ap);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(inText);
            pw.close();
        } catch (IOException e){
            System.out.println("Error: Could not save");
            e.printStackTrace();
        }
    }
    public static void saveToFile2(String inFile, String inText, boolean ap){ //writes number then new line
        try {
            File f = new File(inFile);
            FileWriter fw = new FileWriter(f, ap);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(inText);
            pw.close();
        } catch (IOException e){
            System.out.println("Error: could not save");
            e.printStackTrace();
        }
    }
}
