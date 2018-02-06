package action;

import core.GameObject;

public class SequenceAction implements Action{
    private Action[] actions;
    private int currentIndex;
    public SequenceAction(Action... actions){
        this.actions = actions;
        this.currentIndex=0;
    }
    @Override
    public boolean run(GameObject ownner) {
        Action currentAction = this.actions[this.currentIndex];
        if (currentAction.run(ownner)){
            if (this.currentIndex == this.actions.length - 1) {
                return true;
            } else {
                this.currentIndex += 1;
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public void reset() {
        this.currentIndex=0;
        for (Action action:this.actions){
            action.reset();
        }
    }
}
