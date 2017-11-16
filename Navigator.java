/*
 * Property of no one in particular. Open Project Properties to change this.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab.pkg3;

import java.io.IOException;

/**
 *
 * @author Tyler
 */
public class Navigator {

    public Navigator() {
    }

    public void navigate(char[][] maze, int xLoc, int yLoc, int xHandLoc, int yHandLoc) {
        pressEnter(); //waits for user to press enter before advancing to next step
        
        Maze.print(); //print the maze after each step
        
        if (maze[xLoc][yLoc] == 'F') {
            System.out.println("You are a winner!");
            return;
        }
        //2d array - y coords are rows, x coords are columns (changing y - moves left and right, changing x - moves up and down)
        
        maze[xLoc][yLoc] = 'X';  //sets traversed spaces to 'X', so we know where we've been
        
        //recursive calls for navigation
        if (xLoc < xHandLoc && yLoc == yHandLoc) { //if we are facing east
            if (xLoc < xHandLoc && yLoc == yHandLoc && maze[xHandLoc][yHandLoc] == '.' || maze[xHandLoc][yHandLoc] == 'X' || maze[xHandLoc][yHandLoc] == 'F') { //turn right and step one
                navigate(maze, xLoc + 1, yLoc, xHandLoc, yHandLoc - 1);
            } else if (maze[xHandLoc][yHandLoc] == '#' && maze[xLoc][yLoc + 1] == '.' || maze[xLoc][yLoc + 1] == 'X' || maze[xLoc][yLoc + 1] == 'F') { // step foward while facing east //first two methods are causing infinite loop
                navigate(maze, xLoc, yLoc + 1, xHandLoc, yHandLoc + 1);
            } else if (maze[xHandLoc][yHandLoc] == '#' && maze[xLoc][yLoc + 1] == '#') { //turn left
                navigate(maze, xLoc, yLoc, xHandLoc - 1, yHandLoc + 1);
            }
        }
        if (xLoc > xHandLoc && yLoc == yHandLoc) {//if we are facing west
            if (xLoc > xHandLoc && yLoc == yHandLoc && maze[xHandLoc][yHandLoc] == '.' || maze[xHandLoc][yHandLoc] == 'X' || maze[xHandLoc][yHandLoc] == 'F') {
                navigate(maze, xLoc - 1, yLoc, xHandLoc, yHandLoc + 1);//turn right and step one
            } else if (maze[xHandLoc][yHandLoc] == '#' && maze[xLoc][yLoc - 1] == '.' || maze[xLoc][yLoc - 1] == 'X' || maze[xLoc][yLoc - 1] == 'F') { //step forward while facing west
                navigate(maze, xLoc, yLoc - 1, xHandLoc, yHandLoc - 1);
            } else if (maze[xHandLoc][yHandLoc] == '#' && maze[xLoc][yLoc - 1] == '#') {
                navigate(maze, xLoc, yLoc, xHandLoc + 1, yHandLoc - 1); //turn left
            }
        }
        if (yLoc < yHandLoc && xLoc == xHandLoc) {//if we are facing north
            if (yLoc < yHandLoc && xLoc == xHandLoc && maze[xHandLoc][yHandLoc] == '.' || maze[xHandLoc][yHandLoc] == 'X' || maze[xHandLoc][yHandLoc] == 'F') {
                navigate(maze, xLoc, yLoc + 1, xHandLoc + 1, yHandLoc); //turn right and step one
            } else if (maze[xHandLoc][yHandLoc] == '#' && maze[xLoc - 1][yLoc] == '.' || maze[xLoc - 1][yLoc] == 'X' || maze[xLoc - 1][yLoc] == 'F') { //step forward while facing north
                navigate(maze, xLoc - 1, yLoc, xHandLoc - 1, yHandLoc);
            } else if (maze[xHandLoc][yHandLoc] == '#' && maze[xLoc - 1][yLoc] == '#') {
                navigate(maze, xLoc, yLoc, xHandLoc - 1, yHandLoc - 1); //turn left
            }
        }
        if (yLoc > yHandLoc && xLoc == xHandLoc) {//if we are facing south
            if (yLoc > yHandLoc && xLoc == xHandLoc && maze[xHandLoc][yHandLoc] == '.' || maze[xHandLoc][yHandLoc] == 'X' || maze[xHandLoc][yHandLoc] == 'F') {
                navigate(maze, xLoc, yLoc - 1, xHandLoc - 1, yHandLoc); //turn right and step one
            } else if (maze[xHandLoc][yHandLoc] == '#' && maze[xLoc + 1][yLoc] == '.' || maze[xLoc + 1][yLoc] == 'X' || maze[xLoc + 1][yLoc] == 'F') { //step forward while facing south
                navigate(maze, xLoc + 1, yLoc, xHandLoc + 1, yHandLoc);
            } else if (maze[xHandLoc][yHandLoc] == '#' && maze[xLoc + 1][yLoc] == '#') {
                navigate(maze, xLoc, yLoc, xHandLoc + 1, yHandLoc + 1); //turn left
            }
        }
    }
    
    public void pressEnter(){ // for advancing step by step
        System.out.println();
        try{
            System.in.read();
        } catch(IOException e){
            
        }
    }
}
