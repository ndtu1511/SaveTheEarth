package game.ufo;

import Physic.BoxCollider;
import Renderer.ImageRenderer;
import core.GameObject;
import core.GameObjectManager;

public class UfoShoot {
    private boolean shooted;
    public UfoShoot() {
        this.shooted=false;
    }

    public void run(Ufo ufo){
        if (ufo.position.x<=400 && ufo.position.x>=398 &&!this.shooted){
            Rocket rocket = GameObjectManager.instance.recycle(Rocket.class);
            rocket.position.set(ufo.position);
            rocket.boxCollider = new BoxCollider(18,38);
            if (ufo.position.y<=400) {
                rocket.renderer = new ImageRenderer("resources/rocket/rocket_down.png");
                rocket.velocity.set(0.0f, 1.0f);
            }
            else {
                rocket.renderer = new ImageRenderer("resources/rocket/rocket_up.png");
                rocket.velocity.set(0.0f, -1.0f);
            }
            this.shooted=true;
        }
        else this.shooted=false;
        if (ufo.position.y <= 400 && ufo.position.y>=398 && !this.shooted){
            Rocket rocket = GameObjectManager.instance.recycle(Rocket.class);
            rocket.position.set(ufo.position);
            rocket.boxCollider = new BoxCollider(38,18);
            if (ufo.position.x>=400) {
                rocket.renderer = new ImageRenderer("resources/rocket/rocket_left.png");
                rocket.velocity.set(-1.0f, 0.0f);
            }
            else {
                rocket.renderer = new ImageRenderer("resources/rocket/rocket_right.png");
                rocket.velocity.set(1.0f, 0.0f);
            }
            this.shooted=true;
        }
        else this.shooted=false;
    }
}
