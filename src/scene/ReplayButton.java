package scene;

import Input.MouseInput;
import Input.MouseMotionInput;
import Physic.BoxCollider;
import Renderer.ImageRenderer;

public class ReplayButton extends PlayButton {

    public ReplayButton() {
        imageRenderer = new ImageRenderer("resources/replay_icon/replay.png");
        imageRenderer2 = new ImageRenderer("resources/replay_icon/replay2.png");
        this.renderer = imageRenderer;

        this.boxCollider = new BoxCollider(200,200);
        this.position.set(400,400);
        this.boxCollider.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;

    }
    @Override
    public void run() {
        super.run();
        if (MouseMotionInput.instance.position.x >= this.boxCollider.position.x - this.boxCollider.width/2 &&
                MouseMotionInput.instance.position.x <= this.boxCollider.position.x + this.boxCollider.width/2 &&
                MouseMotionInput.instance.position.y <= this.boxCollider.position.y + this.boxCollider.height/2 &&
                MouseMotionInput.instance.position.y >= this.boxCollider.position.y - this.boxCollider.height/2)
        {
            this.renderer = this.imageRenderer2;
            if (MouseInput.instance.isPressed){
                SceneManager.instance.changeScene(new GameOverviewScene());
            }
        } else {
            this.renderer = imageRenderer;
        }

    }
}
