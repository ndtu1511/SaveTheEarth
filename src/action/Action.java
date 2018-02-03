package action;

import Core.GameObject;

public interface Action {
    boolean run(GameObject ownner);
    void reset();
}
