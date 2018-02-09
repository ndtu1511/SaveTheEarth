package game.meteorite;

import constants.Constant;
import core.GameObjectManager;
import Physic.BoxCollider;
import game.canon.Rocket;
import game.earth.Earth;
import hit.RunHitObject;
import utils.AudioUtils;

import javax.sound.sampled.Clip;

public class MeteoriteHit {
    private RunHitObject[] arrays;

    public MeteoriteHit() {
        this.arrays = new RunHitObject[]{
                new RunHitObject(Earth.class),
                new RunHitObject(Rocket.class)
        };

    }

    public void run(Meteorite meteorite) {
        for (RunHitObject runHitObject : arrays) {
            runHitObject.run(meteorite);
        }
    }
}
