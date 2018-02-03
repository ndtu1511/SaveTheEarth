package action;

import Core.GameObject;

public abstract class ActionAdapter implements Action {
    @Override
    public boolean run(GameObject owner) {
        return false;
    }

    @Override
    public void reset() {

    }
}
