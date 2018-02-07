package game.canon;

import constants.Constant;
import core.GameObject;
import core.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class Rocket extends GameObject implements PhysicBody {
    public Vector2D velocity;
    private BoxCollider boxCollider;

    public Rocket() {
        this.isAlive = true;
        this.renderer = new ImageRenderer(Constant.Rocket.PATH);
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,35);
        this.deactiveIfNeeded();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        if (this.position.y >= 800||this.position.y<=0||this.position.x>=800||this.position.x<=0) {
            this.isAlive = false;
        }
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
}
