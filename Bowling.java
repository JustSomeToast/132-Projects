/*
 * Property of no one in particular. Open Project Properties to change this.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab.pkg1;

import java.util.Random;

/**
 *
 * @author Tyler
 */
public class Bowling {

    public static void main(String[] args) {
        Bowling b1 = new Bowling();
        for (int i = 0; i < 5; i++) {
            b1.play();
        }
    }

    private Frame[] frameScores;     //holds instances of frame class created when ball is rolled
    private int currentFrame;     //current roll, used for indexing scores into array

    public Bowling() {
        frameScores = new Frame[11];  //holds 10 frames and extra frame
    }

    public void play() {  //method for full game
        for (int i = 0; i < 10; i++) {
            roll();
            if (i == 9) {
                tenthFrameBonus();
            }
        }
        printFrames();
        currentFrame = 0;   //reset these two varibables after game finish
        Frame.totalScore = 0;   
    }

    public void roll() {     //method for rolling
        int[] weightedScores = {0, 1, 2, 3, 4, 5, 6, 6, 7, 7, 7, 10, 10, 10, 8, 8, 8, 8, 9, 9, 9, 9};   //array created for weighted rolls, ordered by weight
        int shot = new Random().nextInt(weightedScores.length);
        int rollOne = weightedScores[shot];
        if (Frame.isStrike(rollOne)) {
            frameScores[currentFrame] = new Frame(10, 0, 10);
            currentFrame++;
        } else {
            int rollTwo = (int) (Math.random() * (11 - rollOne));  //random roll weighted equally
            int total = rollOne + rollTwo;
            frameScores[currentFrame] = new Frame(rollOne, rollTwo, total);
            currentFrame++;
        }
    }

    public void tenthFrameBonus() {   //method for bonus roll(s) if 10th frame is strike or spare
        int[] weightedScores = {0, 1, 2, 3, 4, 5, 6, 6, 7, 7, 7, 10, 10, 10, 8, 8, 8, 8, 9, 9, 9, 9};
        if (Frame.isStrike(frameScores[9].getRollOne())) {  //if frame 10 is strike, roll twice
            int total = 0;
            int shot = new Random().nextInt(weightedScores.length);
            int rollOne = weightedScores[shot];
            if (Frame.isStrike(rollOne)) {     //if first bonus roll is strike, roll again with full weigthed scores
                int rollTwo = new Random().nextInt(weightedScores.length);
                total = rollOne + rollTwo;
                frameScores[10] = new Frame(rollOne, rollTwo, total);
            } else if (!Frame.isStrike(rollOne)) {   //if first bonus roll is not strike, roll with remaining pins
                int rollTwo = (int) (Math.random() * (11 - rollOne));
                frameScores[10] = new Frame(rollOne, rollTwo, total);
            }
        } else if (Frame.isSpare(frameScores[9].getRollOne(), frameScores[9].getRollTwo())) {   //if frame 10 is a spare, roll once
            int shot = new Random().nextInt(weightedScores.length);
            int rollOne = weightedScores[shot];
            frameScores[10] = new Frame(rollOne, 0, rollOne);
        } else {
            frameScores[10] = new Frame(0, 0, 0);   //if frame 10 is not a strike/spare, do not roll, bonus frame is empty
        }
    }

    public int spareBonus(int inFrame) {    //bonus for spare
        return frameScores[inFrame + 1].getRollOne();
    }

    public int strikeBonus(int inFrame) {     //bonus for strike
        if (inFrame == 9 && Frame.isStrike(frameScores[inFrame].getRollOne())) {  //if 10th frame is strike, get bonus frame total score, avoids indexOutOfBounds 
            return frameScores[inFrame + 1].getFrameScore();
        } else if (Frame.isStrike(frameScores[inFrame].getRollOne())) {
            if (Frame.isStrike(frameScores[inFrame + 1].getRollOne())) {
                return (frameScores[inFrame + 1].getRollOne() + frameScores[inFrame + 2].getRollOne()); //if next frame is strike, add it and next frame first roll
            } else {
                return (frameScores[inFrame + 1].getFrameScore());  //if next frame is not strike, get next frame total score
            }
        } else {
            return frameScores[inFrame + 1].getFrameScore();
        }
    }

    public void printFrames() {   //method for printing final scoreboard 
        for (int i = 0; i < frameScores.length; i++) {
        }
        for (int i = 0; i < 9; i++) {
            System.out.print("+----Frame " + (i + 1) + "----"); //top row for frames 1 - 9
        }
        System.out.println("+----Frame 10---+---------------+");  //top row for 10th frame and bonus frame

        for (int i = 0; i < 10; i++) {     //loop for printing frames 1 - 10 scores
            if (Frame.isStrike(frameScores[i].getRollOne())) {
                System.out.print("+   " + frameScores[i].makeString() + "   |       ");
            } else if (Frame.isSpare(frameScores[i].getRollOne(), frameScores[i].getRollTwo())) {
                System.out.print("+   " + frameScores[i].getRollOne() + "   |   " + frameScores[i].makeString() + "   ");
            } else {
                System.out.print("+   " + frameScores[i].getRollOne() + "   |   " + frameScores[i].getRollTwo() + "   ");
            }
        }
        if (Frame.isStrike(frameScores[9].getRollOne())) {  //bonus frame rolls
            System.out.print("+   " + frameScores[10].makeString() + "   |   ");
            if (Frame.isStrike(frameScores[10].getRollTwo())) {
                System.out.println(frameScores[10].makeString() + "   +");
            } else {
                System.out.println(frameScores[10].getRollTwo() + "   +");
            }

        } else if (Frame.isSpare(frameScores[9].getRollOne(), frameScores[9].getRollTwo())) {
            System.out.println("+   " + frameScores[10].makeString() + "   |   0   +");
        } else {
            System.out.println("+       |       +");    //empty bonus frame
        }
        for (int i = 0; i < 11; i++) {
            System.out.print("+---------------");  //mid line between rolls and running total score
        }
        System.out.println("+");
        for (int i = 0; i < 10; i++) {
            int frameTotal = 0;
            if (Frame.isStrike(frameScores[i].getRollOne())) {
                frameTotal += frameScores[i].getFrameScore();
                frameTotal += strikeBonus(i);
                Frame.totalScore += frameTotal;
            } else if (Frame.isSpare(frameScores[i].getRollOne(), frameScores[i].getRollTwo())) {
                frameTotal += frameScores[i].getFrameScore();
                frameTotal += spareBonus(i);
                Frame.totalScore += frameTotal;
            } else {
                Frame.totalScore += frameScores[i].getFrameScore();
            }
            int length = String.valueOf(Frame.totalScore).length();   //varying format whitespace depending on length of current total score
            if (length == 1) {
                System.out.print("+       " + Frame.totalScore + "       ");
            } else if (length == 2) {
                System.out.print("+       " + Frame.totalScore + "      ");
            } else {
                System.out.print("+      " + Frame.totalScore + "      ");
            }
        }
        System.out.println("+               +");
        for (int i = 0; i < 11; i++) {
            System.out.print("+---------------");  //bottom line of scoreboard
        }
        System.out.println("+");
        System.out.println();
    }

}
