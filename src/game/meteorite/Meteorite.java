
package game.meteorite;

import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;
import game.earth.Earth;
import game.earth.EarthHP;
import game.meteorite.explosive.MeteoriteExplosive;
import hit.HitObject;

public class Meteorite extends GameObject implements PhysicBody, HitObject {
    private BoxCollider boxCollider;
    public Vector2D velocity;

    public Meteorite(){
        this.renderer = new ImageRenderer("resources/meteorite/meteorite_small.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,20);
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
        if(this.position.khoangcach(this.position.x,this.position.y)<=70){
            this.isAlive = false;
            this.velocity = new Vector2D();
            MeteoriteExplosive meteoriteExplosive = GameObjectManager.instance.recycle(MeteoriteExplosive.class);
            meteoriteExplosive.position.set(this.position);
            meteoriteExplosive.config();

        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        this.velocity = new Vector2D();
        MeteoriteExplosive meteoriteExplosive = GameObjectManager.instance.recycle(MeteoriteExplosive.class);
        meteoriteExplosive.position.set(this.position);
        meteoriteExplosive.config();
    }
}
