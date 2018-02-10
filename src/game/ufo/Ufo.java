package game.ufo;

import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;
import constants.Constant;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.meteorite.DeadAni;
import hit.HitObject;

public class Ufo extends GameObject implements PhysicBody, HitObject {
    public Vector2D velocity;
    private BoxCollider boxCollider;
    private int count;
    private UfoShoot ufoShoot;
    public Ufo() {
        this.renderer = new ImageRenderer(Constant.UFO.PATH);
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(25,25);
        this.ufoShoot = new UfoShoot();
        this.count =0;
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        if (this.position.x<=0||this.position.y<=0||this.position.x>=800||this.position.y>=800){
            this.isAlive=false;
        }
        this.ufoShoot.run(this);
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
        this.position.set(0,0);
    }
}
