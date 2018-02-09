package game.meteorite;

import core.GameObjectManager;
import Physic.BoxCollider;
import game.earth.Earth;
import hit.RunHitObject;

public class HitEarth {
    private RunHitObject[] arrays;

    public HitEarth() {
        this.arrays = new RunHitObject[]{
                new RunHitObject(Meteorite.class),
        };
    }

    public void run(Earth earth) {
        for (RunHitObject runHitObject : arrays) {
            runHitObject.run(earth);
        }
    }
}
