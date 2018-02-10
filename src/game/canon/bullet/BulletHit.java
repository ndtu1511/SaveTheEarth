package game.canon.bullet;

import game.meteorite.Meteorite;
import game.ufo.Rocket;
import game.ufo.Ufo;
import hit.RunHitObject;

public class BulletHit {
    private RunHitObject[] arrays;

    public BulletHit() {
        this.arrays = new RunHitObject[]{
                new RunHitObject(Meteorite.class),
                new RunHitObject(Rocket.class),
                new RunHitObject(Ufo.class)
        };
    }

    public void run(Bullet bullet) {
        for (RunHitObject runHitObject : arrays) {
            runHitObject.run(bullet);
        }
    }
}
