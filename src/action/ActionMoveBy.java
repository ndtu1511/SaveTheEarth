package action;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;

public class ActionMoveBy implements Action {
    private Vector2D velocity;
    private FrameCounter frameCounter;

    public ActionMoveBy(Vector2D velocity, int frameCount) {
        this.velocity = velocity;
        this.frameCounter = new FrameCounter(frameCount);
    }

    @Override
    public boolean run(GameObject owner) {
            if (this.frameCounter.run()) {
                owner.isAlive = false;
                return true;
            } else {
                owner.position.addUp(this.velocity);
            }
            return false;
    }

    @Override
    public void reset() {
        this.frameCounter.reset();
    }
}
