package action;

import core.FrameCounter;
import core.GameObject;

public class WaitAction implements Action {
    private FrameCounter frameCounter;

    public WaitAction(int max){
        this.frameCounter = new FrameCounter(max);
    }
    @Override
    public boolean run(GameObject ownner) {
        return this.frameCounter.run();
    }

    @Override
    public void reset() {
        this.frameCounter.reset();
    }
}
