package game.earth;

import core.GameObject;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;
import constants.Constant;

public class Earth extends GameObject implements PhysicBody{
    private BoxCollider boxCollider;
    public Earth() {
        this.renderer = new ImageRenderer(Constant.TheEarth.PATH);
        this.position.set(Constant.Windows.WIDTH/2,Constant.Windows.HEIGHT/2);
        this.boxCollider = new BoxCollider(60,60);
    }

    public void getHit() {
//        this.isAlive = false;
////        PlayerExplosion playerExplosion = GameObjectManager.instance.recycle(PlayerExplosion.class);
//        playerExplosion.position.set(this.position);
//        playerExplosion.configAction();
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
