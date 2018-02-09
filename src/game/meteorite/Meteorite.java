
package game.meteorite;

import Renderer.AnimationRenderer;
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

public class Meteorite extends GameObject implements PhysicBody, HitObject {
    protected BoxCollider boxCollider;
    private ImageRenderer imageRenderer;
    private MeteoriteHit meteoriteHit;
    public Vector2D velocity;
//    private Clip clip;
    public Meteorite(){
        this.imageRenderer = new ImageRenderer(Constant.Meteorite.PATH);
        this.renderer = this.imageRenderer;
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,20);
        meteoriteHit = new MeteoriteHit();
    }
    @Override
    public void run(){
        super.run();
        this.velocity.gravity(this.position.x,this.position.y,this.velocity.x,this.velocity.y);
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        if (this.position.x<=0||this.position.y<=0||this.position.x>=800||this.position.y>=800){
            this.isAlive = false;
        }
        this.meteoriteHit.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        MeteoDeadAni meteoDeadAni = GameObjectManager.instance.recycle(MeteoDeadAni.class);
        meteoDeadAni.position.set(this.position);
        meteoDeadAni.run();
//        this.clip = AudioUtils.instance.loadSound("resources/Sound/sfx/explosiveEnemy.wav");
//        this.clip.start();
    }
}
