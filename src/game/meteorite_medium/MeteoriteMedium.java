package game.meteorite_medium;

import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.earth.Earth;
import game.meteorite.Meteorite;
import game.meteorite.explosive.MeteoriteExplosive;
import hit.HitObject;

import java.util.Random;

public class MeteoriteMedium extends GameObject implements PhysicBody, HitObject {
    private BoxCollider boxCollider;
    public Vector2D velocity;

    private Random random;
    public Earth earth;

    public MeteoriteMedium(){
        this.renderer = new ImageRenderer("resources/meteorite/meteorite_medium.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(40,40);
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
        if(this.position.khoangcach(this.position.x,this.position.y)<=50){
            this.isAlive = false;
            this.velocity = new Vector2D();
            MeteoriteExplosive meteoriteExplosive = GameObjectManager.instance.recycle(MeteoriteExplosive.class);
            meteoriteExplosive.position.set(this.position);
            meteoriteExplosive.config();
//            earth.hit = 0;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;

        Meteorite meteorite1 = new Meteorite();
        meteorite1.position.set(this.position.x+10,this.position.y+10);
        meteorite1.velocity.set(new Vector2D(1,1));
        GameObjectManager.instance.add(meteorite1);
        Meteorite meteorite2 = new Meteorite();
        meteorite2.position.set(this.position.x-10,this.position.y-10);
        meteorite2.velocity.set(new Vector2D(-1,-1));
        GameObjectManager.instance.add(meteorite2);

    }
}