/*
 * Property of no one in particular. Open Project Properties to change this.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab.pkg4;

/**
 *
 * @author Tyler
 */
public class PixelRegion {
    
    private int pixelX;
    private int pixelY;
    private int counter;  // will be used in switch statement to know what pixel to check
    
    public PixelRegion(int x, int y){  //constructor that takes the x,y location and starts the counter for pixel checking
        pixelX = x;
        pixelY = y;
        counter = 1;
    }
    
    public int getPixelX(){ //get the pixel's x location
        return pixelX;
    }
    
    public int getPixelY(){  //get the pixel's y location
        return pixelY;
    }
    
    public int getCounter(){ //get the current counter to determine what pixel to check
        return counter;
    }
    
    public void count(){  //increment pixel counter when done with current pixel to check next pixel
        counter++;
    }
}
