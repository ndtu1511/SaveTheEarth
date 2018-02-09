package game.meteorite;

import game.canon.Rocket;
import hit.RunHitObject;

import javax.sound.sampled.Clip;

public class RocketHit {
    private RunHitObject[] arrays;
    private Clip clip;

    public RocketHit() {
        this.arrays = new RunHitObject[]{
                new RunHitObject(Meteorite.class),
//                new RunHitObject(SquareBullet.class)
        };
    }

    public void run(Rocket rocket) {
        for (RunHitObject runHitObject : arrays) {
            runHitObject.run(rocket);
        }
    }
}
