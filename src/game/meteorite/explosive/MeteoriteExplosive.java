package game.meteorite.explosive;

import action.Action;
import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;

import java.util.Random;

public class MeteoriteExplosive extends GameObject {
    private Random random = new Random();
    public MeteoriteExplosive() {

    }

    public void config() {
        for (double i = 0; i <= 360 ; i += 360/30 ) {
            MeteoriteParticleExplosive meteoriteParticleExplosive = GameObjectManager.instance.recycle(MeteoriteParticleExplosive.class);
            meteoriteParticleExplosive.position.set(this.position);
            meteoriteParticleExplosive.velocity.set((new Vector2D(0,1)).rotate(i).multiply(random.nextInt(3)+2));
            meteoriteParticleExplosive.frameCounter = new FrameCounter(random.nextInt(1) + 100);
        }
    }
}
