package org.bowling;

import java.util.ArrayList;

public class Strike extends Frame{

    public Strike(ArrayList<Integer> trys){
        super(trys);
        this.trys.add(10);
    }

    /**
     * Calcul le score du tour Spare, sur deux essais, plus deux essais suivants/bonus
     * @return : le score du frame si nombre d'essais sufisant,
     *          0 sinon
     */
    @Override
    public int calculateFrameScore() {
        if(this.trys.size() > this.indexStartingTry + 2){
            return  this.trys.get(this.indexStartingTry)
                    + this.trys.get(this.indexStartingTry+1)
                    + this.trys.get(this.indexStartingTry+2);
        }
        return 0;
    }
}
