package game.meteorite;

import game.canon.bullet.Bullet;
import game.earth.Earth;
import game.ufo.Rocket;
import game.ufo.Ufo;
import hit.RunHitObject;

public class MeteoriteHit {
    private RunHitObject[] arrays;

    public MeteoriteHit() {
        this.arrays = new RunHitObject[]{
                new RunHitObject(Earth.class),
                new RunHitObject(Bullet.class),
//                new RunHitObject(Ufo.class),
                new RunHitObject(Rocket.class)
        };

    }

    public void run(Meteorite meteorite) {
        for (RunHitObject runHitObject : arrays) {
            runHitObject.run(meteorite);
        }
    }
}
