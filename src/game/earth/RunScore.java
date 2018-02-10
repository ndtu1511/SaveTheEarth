package game.earth;

import Physic.BoxCollider;
import Physic.PhysicBody;
import core.GameObject;
import hit.HitObject;

public class RunScore extends GameObject implements PhysicBody, HitObject {
    public Score score;
    public RunScore(){
        this.score = new Score();
    }
    @Override
    public void run(){
        super.run();
//        this.score.paintComponent(graphics);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}
