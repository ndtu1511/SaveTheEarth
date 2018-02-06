package game.meteorite.explosive;

import action.Action;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;

import java.util.Random;

public class MeteoriteExplosive extends GameObject {
    public void configAction() {
        Action action = new Action() {
            @Override
            public boolean run(GameObject owner) {
                for (Double i = 0.0; i <= 360.0; i+= 5.0) {
                    MeteoriteParticleExplosive meteoriteParticleExplosion = GameObjectManager.instance.recycle(MeteoriteParticleExplosive.class);
                    meteoriteParticleExplosion.position.set(position);
                    Random random = new Random();
                    meteoriteParticleExplosion.velocity.set
                            ((new Vector2D((float) 0.0, random.nextInt(3) + 1)).rotate(i));
                    meteoriteParticleExplosion.configAction();
                }
                return true;
            }

            @Override
            public void reset() {

            }
        };
        this.add(action);
    }
}
