package game.canon.bullet;

import constants.Constant;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;
import hit.HitObject;
import utils.AudioUtils;

import javax.sound.sampled.Clip;

public class Bullet extends GameObject implements PhysicBody, HitObject {
    public Vector2D velocity;
    private BoxCollider boxCollider;
    private Clip clip;

    private BulletHit bulletHit = new BulletHit();
//    private BulletHit hitSquareBullet = new BulletHit();

    public Bullet() {
        this.isAlive = true;
        this.renderer = new ImageRenderer(Constant.Rocket.PATH);

        this.clip = AudioUtils.instance.loadSound("resources/Sound/sfx/shoot.wav");
        this.clip.start();

        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,20);
        this.deactiveIfNeeded();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        bulletHit.run(this);
    }

    private void deactiveIfNeeded() {
        if (this.position.x<=0||this.position.y<=0||this.position.x>=800||this.position.y>=800) {
            this.isAlive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject != null){
            this.isAlive = false;
            this.position.set(0,0);
        }
    }
    public<O extends GameObject> void autoAim(){
        O object = GameObjectManager.instance.autoAim(this);
        if (object != null) {
            this.velocity.gravity2(object.position.x,object.position.y,this.velocity.x,this.velocity.y);
        }
    }
}
