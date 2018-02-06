package game.canon;

import Input.MouseInput;
import core.GameObjectManager;
import core.Vector2D;
import Input.MouseMotionInput;

public class CanonShoot {
    private Vector2D mouse;

    public CanonShoot() {
        this.mouse = new Vector2D(MouseMotionInput.instance.position.x,MouseMotionInput.instance.position.y);
    }

    public void run(Canon canon){
        if(MouseInput.instance.isPressed){
            Rocket rocket = GameObjectManager.instance.recycle(Rocket.class);
//            Rocket rocket = new Rocket();
            rocket.position.set(600,600);
            Vector2D caigido = new Vector2D(MouseMotionInput.instance.position.x-400,
                    MouseMotionInput.instance.position.y-400);
//            vector2D.normalize();
            rocket.velocity.set(new Vector2D(5,0));
            GameObjectManager.instance.add(rocket);


        }

    }
}
