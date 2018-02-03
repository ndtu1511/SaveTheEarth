package action;

import Core.GameObject;

import java.util.Arrays;
import java.util.List;

public class GroupAction implements Action {

    private List<Action> list;

    public GroupAction(Action... actions){
        this.list = Arrays.asList(actions);
    }

    @Override
    public boolean run(GameObject ownner) {
////        for (Action action:this.list){
////            action.run(ownner);
////        }
////        return false;
//        return this.list.removeIf(action -> action.run(ownner));
        this.list.removeIf(action -> action.run(ownner));
        return this.list.size() == 0;
    }

    @Override
    public void reset() {
//        for (Action action: this.list){
//            action.reset();
//        }
    }
}
