package game.earth;

import game.meteorite.Meteorite;
import hit.RunHitObject;

public class EarthHit {
    private RunHitObject[] arrays;

    public EarthHit() {
        this.arrays = new RunHitObject[]{
                new RunHitObject(Meteorite.class),
//                new RunHitObject(Square.class),
        };
    }

    public void run(Earth earth) {
        for (RunHitObject runHitObject : arrays) {
            runHitObject.run(earth);
        }
    }
}
