package game.ufo;

import game.canon.bullet.Bullet;
import game.earth.Earth;
import game.meteorite.Meteorite;
import hit.RunHitObject;

public class RocketHit {
    private RunHitObject[] arrays;

    public RocketHit() {
        this.arrays = new RunHitObject[]{
                new RunHitObject(Earth.class),
                new RunHitObject(Bullet.class),
                new RunHitObject(Meteorite.class),
        };
    }
    public void run(Rocket rocket){
        for (RunHitObject runHitObject : arrays) {
            runHitObject.run(rocket);
        }
    }
}
