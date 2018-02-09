package game.earth;

import Renderer.AnimationRenderer;
import com.sun.deploy.util.SessionState;
import core.GameObject;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;
import constants.Constant;
import hit.HitObject;
import utils.AudioUtils;

import javax.sound.sampled.Clip;

public class Earth extends GameObject implements PhysicBody, HitObject{
    private BoxCollider boxCollider;
    private EarthHP earthHP;
    private ImageRenderer imageRenderer;
    private AnimationRenderer animationRenderer;
    private EarthHit earthHit = new EarthHit();
    public int hit = 1;
    private Clip clip;


    public Earth() {
        this.position.set(Constant.Windows.WIDTH/2,Constant.Windows.HEIGHT/2);
        this.renderer = new ImageRenderer(Constant.TheEarth.PATH);
        this.earthHP = new EarthHP(5);

        this.boxCollider = new BoxCollider(50,50);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
        earthHP.showHP();
        this.earthHit.run(this);

        if(hit==0){
            this.isAlive = this.earthHP.run();
            hit = 1;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = this.earthHP.run();

//        this.clip = AudioUtils.instance.loadSound("resources/Sound/sfx/explosiveEarth.wav");
//        this.clip.start();
    }
}
