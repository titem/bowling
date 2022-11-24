package org.bowling;

import java.util.ArrayList;

public abstract class Frame {

    protected ArrayList<Integer> trys;
    protected int indexStartingTry;

    public Frame(ArrayList<Integer> trys){
        this.trys = trys;
        this.indexStartingTry = this.trys.size();
    }

    public abstract int calculateFrameScore();

}
