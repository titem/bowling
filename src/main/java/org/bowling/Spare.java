package org.bowling;

import java.util.ArrayList;
import java.util.Collections;

public class Spare extends Frame{

    public Spare(ArrayList<Integer> trys, int firstTry, int secondTry){
        super(trys);
        Collections.addAll(this.trys, firstTry, secondTry);
    }

    /**
     * Calcul le score du tour Spare, sur deux essais, plus l'essai suivant/bonus
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
