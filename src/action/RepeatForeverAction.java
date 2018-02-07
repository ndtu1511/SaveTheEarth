package action;

import core.GameObject;

public class RepeatForeverAction implements Action {

    private Action action;

    public RepeatForeverAction(Action action) {
        this.action = action;
    }

    @Override
    public boolean run(GameObject ownner) {
//        this.action.run(ownner);
//        return false;
        if (this.action.run(ownner))
            this.action.reset();
        return false;
    }

    @Override
    public void reset() {
//        this.action.reset();
    }
}
