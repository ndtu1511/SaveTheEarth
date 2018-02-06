package game.canon;

import core.FrameCounter;
import core.GameObject;

public class Canon extends GameObject {
    CanonShoot canonShoot = new CanonShoot();
    FrameCounter frameCounter = new FrameCounter(10);

    public Canon() {

    }

    @Override
    public void run() {
        super.run();
        if (frameCounter.run()) {
            canonShoot.run(this);
            frameCounter.reset();
        }
    }
}
