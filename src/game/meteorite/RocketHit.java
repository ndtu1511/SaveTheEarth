package game.meteorite;

import game.canon.Rocket;
import game.meteorite_medium.MeteoriteMedium;
import hit.RunHitObject;

public class RocketHit {
    private RunHitObject[] arrays;

    public RocketHit() {
        this.arrays = new RunHitObject[]{
                new RunHitObject(Meteorite.class),
                new RunHitObject(MeteoriteMedium.class)
        };
    }

    public void run(Rocket rocket) {
        for (RunHitObject runHitObject : arrays) {
            runHitObject.run(rocket);
        }
    }
}
