package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Brandon on 2/19/2015.
 */
public class ButtonSequencer {

    public static ArrayList<Integer> playerList;
    private ArrayList<Byte> computerList;
    private final Random rand;
    private int turn = 0;
    private int count;

    public ButtonSequencer (ArrayList<Byte> computerList) {
        this.rand = new Random();
    }

    public void buttonGenerator (byte min, byte max, ArrayList<Byte> computerList) {
        int random = rand.nextInt((max - min) + 1) + min;
        computerList.add((byte)random);
        this.turn++;
    }


    public static void clearPlayerList () {
        playerList.clear();
    }
    public void printMoveList (ArrayList<Byte> computerList) {
        for (byte i : computerList) {
            System.out.println(computerList.get(i));
        }
    }


}
