package game.meteorite;

import game.canon.Rocket;
import hit.RunHitObject;

public class RocketHit {
    private RunHitObject[] arrays;

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
