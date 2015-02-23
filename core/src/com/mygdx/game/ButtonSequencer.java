package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Brandon on 2/19/2015.
 */
public class ButtonSequencer {

    public Random rand;
    private int turn = 0;
    private int count;


    public static void addPlayerNums (int code) {
        XimonGame.playerList.add(code);
    }

    public int getCount () {
        return count;
    }

    public void incrementCount () {
        count++;
    }

    public void appendRandomNumber (int min, int max, ArrayList<Integer> computerList) {
        rand = new Random();
        int random = rand.nextInt((max - min) + 1) + min;
        computerList.add(random);
        turn++;

    }

    public void performComputerSequence () {

    }

    public int getRandomInt (int min, int max) {
        rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }


    public void clearPlayerList () {
        XimonGame.playerList.clear();
    }

    public void printMoveList (ArrayList<Byte> computerList) {
        for (byte i : computerList) {
            System.out.println(computerList.get(i));
        }

    }


}
