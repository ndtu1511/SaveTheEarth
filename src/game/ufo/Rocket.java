package game.ufo;

import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.meteorite.DeadAni;
import hit.HitObject;

public class Rocket extends GameObject implements PhysicBody, HitObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RocketHit rocketHit;
    public Rocket() {
        this.renderer = new ImageRenderer("resources/rocket/rocket_up.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(18,38);
        this.rocketHit = new RocketHit();
    }

    @Override
    public void run() {
        super.run();
        this.velocity.addUp(this.velocity.multiply(0.51f));
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position);
        this.rocketHit.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive=false;
        DeadAni deadAni = GameObjectManager.instance.recycle(DeadAni.class);
        deadAni.position.set(this.position);
        deadAni.run();
    }
}
