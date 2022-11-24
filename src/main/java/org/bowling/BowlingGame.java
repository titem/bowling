package org.bowling;

import java.util.ArrayList;

public class BowlingGame {

    private ArrayList<Frame> frames;
    protected ArrayList<Integer> trys;

    public BowlingGame() {
        this.frames = new ArrayList<Frame>();
        this.trys = new ArrayList<>();
    }

    public void addOpenFrame(int firstTry, int secondTry){
        frames.add(new OpenFrame(this.trys, firstTry, secondTry));
    }

    public void addSpare(int firstTry, int secondTry){
        frames.add(new Spare(this.trys, firstTry, secondTry));
    }

    public void addStrike(){
        frames.add(new Strike(trys));
    }

    public void addBonus(int bonus){
        this.trys.add(bonus);
    }

    public int score(){
       return frames.stream().mapToInt(Frame::calculateFrameScore).sum();
    }

}
