/*
 * Property of no one in particular. Open Project Properties to change this.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab.pkg3;


/**
 *
 * @author Tyler
 */
public class Driver3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Maze maze = new Maze();
        maze.findStart();
        Navigator n = new Navigator();
        System.out.println("Press the Enter key to advance to the next step...");
        n.navigate(maze.getMaze(), maze.getStartX(), maze.getStartY(), maze.getHandX(), maze.getHandY());
    }

}

