package org.bowling;

import java.util.ArrayList;
import java.util.Collections;

public class OpenFrame extends Frame{

    public OpenFrame(ArrayList<Integer> trys, int firstTry, int secondTry){
        super(trys);
        Collections.addAll(this.trys, firstTry, secondTry);
    }

    /**
     * Calcul le score du tour OpenFrame, sur deux essais
     * @return : le score du frame si nombre d'essais sufisant,
     *          0 sinon
     */
    @Override
    public int calculateFrameScore() {
        if(this.trys.size() > this.indexStartingTry+1){
            return  this.trys.get(this.indexStartingTry)
                    + this.trys.get(this.indexStartingTry+1);
        }
        return 0;
    }
}
