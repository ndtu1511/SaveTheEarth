
package game.meteorite;

import Core.GameObject;
import Core.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class Meteorite extends GameObject implements PhysicBody {
    private BoxCollider boxCollider;
    public Vector2D velocity;

    public Meteorite(){
        this.boxCollider = new BoxCollider(20,20);
        this.renderer = new ImageRenderer("resources/meteorite/enemy_square_small.png");
        this.velocity = new Vector2D();
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
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

}
