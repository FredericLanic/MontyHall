package coml.kycox.montyhall.game;

import java.util.Random;

public class Draw {
    private static Random rand = new Random(); ;

    public final static int getDraw(int maxNbr) {
        return rand.nextInt(maxNbr);
    }

    public final static float getStatistics(int specificDrawsNbr, int totalDrawsNbr) {
        return (float) specificDrawsNbr / (float)totalDrawsNbr;
    }

}
