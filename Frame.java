/*
 * Property of no one in particular. Open Project Properties to change this.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab.pkg1;

/**
 *
 * @author Tyler
 */
public class Frame {

    private int rollOne;
    private int rollTwo;
    private int frameScore;        //total score for frame
    public static int totalScore;   //keeps track of total score
    private String string;          //for printing, if frame is scored strike or spare 

    public Frame(int inRollOne, int inRollTwo, int inScore) {   //constructor for building frames, holds both rolls and the frame total score
        rollOne = inRollOne;
        rollTwo = inRollTwo;
        frameScore = inScore;
        makeString();
    }

    public int getRollOne() {
        return rollOne;
    }

    public int getRollTwo() {
        return rollTwo;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public static boolean isStrike(int inRoll) {  //check if input roll is a strike
        if (inRoll == 10) {
            return true;
        }
        return false;
    }

    public static boolean isSpare(int inRoll1, int inRoll2) {  //check if inputs rolls are a spare
        if ((inRoll1 + inRoll2) == 10) {
            return true;
        }
        return false;
    }

    public String makeString() {    //used for printing strikes as "X" and spares as "S" in output
        if (isStrike(rollOne)) {
            string = "X";
        } else if (isSpare(rollOne, rollTwo)) {
            string = "S";
        } else { 
            string = String.valueOf(rollOne);
        }
        return string;
    }
}
