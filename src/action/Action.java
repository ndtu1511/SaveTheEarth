package action;

import core.GameObject;

public interface Action {
    boolean run(GameObject ownner);
    void reset();
}
