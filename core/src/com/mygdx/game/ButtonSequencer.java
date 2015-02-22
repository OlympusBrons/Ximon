package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Brandon on 2/19/2015.
 */
public class ButtonSequencer {

    public ArrayList<Integer> playerList;
    private ArrayList<Integer> computerList;
    public Random rand;
    private int turn = 0;
    private int count;


    public void addPlayerNums (int code) {
        playerList.add(code);
        count++;
    }

    public int getCount () {
        return count;
    }

    public void incrementCount () {
        count++;
    }

    public void numGenerator (byte min, byte max, ArrayList<Integer> computerList) {
        rand = new Random();
        int random = rand.nextInt((max - min) + 1) + min;
        computerList.add(random);
        turn++;

    }

    public void clearPlayerList () {
        playerList.clear();
    }

    public void printMoveList (ArrayList<Byte> computerList) {
        for (byte i : computerList) {
            System.out.println(computerList.get(i));
        }

    }


}
