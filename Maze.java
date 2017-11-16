/*
 * Property of no one in particular. Open Project Properties to change this.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab.pkg3;

import java.io.*;

/**
 *
 * @author Tyler
 */
public class Maze {

    private static char[][] maze;
    private int startX;
    private int startY;
    private int handX;
    private int handY;
    private String file = "maze1.txt";

    public Maze() {  //reading in a maze from a text file
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String readline;
            int j = 0;
            maze = new char[12][12]; //array size is hardcoded to 12x12 as specified by instructions
            while ((readline = in.readLine()) != null) {
                char[] ch = readline.replaceAll(" ", "").toCharArray();
                if (!readline.equals("")) {
                    for (int i = 0; i < ch.length; i++) {
                        maze[j][i] = ch[i];
                    }
                    j++;
                }
            }
        } catch (IOException e) {
            System.out.println("Sorry, that maze file cannot be found, please use a valid file.");
        }
    }

    public static void print() {   //for printing the maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public char[][] getMaze() {  //return the maze
        return maze;
    }

    public boolean findStart() { // method for searching the outside of the maze for the starting point
        char start = '.';
        for (int i = 0; i < maze.length; i++) { // search top row for start point - facing south
            if (maze[0][i] == start) {
                startX = 0;
                startY = i;
                handX = 0;
                handY = i - 1;
                return true;
            }
        }
        for (int i = 0; i < maze.length; i++) {// search bottom row for start - facing north
            if (maze[11][i] == start) {
                startX = 11;
                startY = i;
                handX = 11;
                handY = i + 1;
                return true;
            }
        }
        for (int j = 0; j < maze.length; j++) {  // search leftmost column for start - facing east
            if (maze[j][0] == start) {
                startX = j;
                startY = 0;
                handX = j + 1;
                handY = 0;
                return true;
            }
        }
        for (int j = 0; j < maze.length; j++) {  // search rightmost column for start - facing west
            if (maze[j][11] == start) {
                startX = j;
                startY = 11;
                handX = j - 1;
                handY = 0;
                return true;
            }
        }

        System.out.println("Couldn't find the start position...does one exist?");
        return false;
    }
    
    public int getStartX(){   //get methods for the various aspects of the starting point
        return startX;
    }
    public int getStartY(){
        return startY;
    }
    public int getHandX(){
        return handX;
    }
    public int getHandY(){
        return handY;
    }
}
