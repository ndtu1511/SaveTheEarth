package game.earth;

import Renderer.AnimationRenderer;
import core.GameObject;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;
import constants.Constant;
import hit.HitObject;

public class Earth extends GameObject implements PhysicBody, HitObject{
    private BoxCollider boxCollider;
    private EarthHP earthHP;
    private ImageRenderer imageRenderer;
    private AnimationRenderer animationRenderer;
    private EarthHit earthHit = new EarthHit();


    public Earth() {
        this.position.set(Constant.Windows.WIDTH/2,Constant.Windows.HEIGHT/2);
        this.renderer = new ImageRenderer(Constant.TheEarth.PATH);
        this.earthHP = new EarthHP(5);

        this.boxCollider = new BoxCollider(100,100);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
        earthHP.showHP();
        this.earthHit.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = this.earthHP.run();

    }
}
