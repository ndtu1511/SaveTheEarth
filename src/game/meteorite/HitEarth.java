package game.meteorite;

import core.GameObjectManager;
import Physic.BoxCollider;
import game.earth.Earth;

public class HitEarth {
    public void run(Meteorite meteorite) {
        BoxCollider boxCollider = meteorite.getBoxCollider();
        Earth earth = GameObjectManager.instance.checkCollider(boxCollider, Earth.class);
        if (earth != null) {
            earth.getHit();
            meteorite.getHit();
        }
    }
}
