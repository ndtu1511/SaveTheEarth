package game.meteorite.explosive;

import Renderer.ImageRenderer;
import action.Action;
import action.ActionMoveBy;
import core.GameObject;
import core.Vector2D;

import java.util.Random;

public class MeteoriteParticleExplosive extends GameObject {
    public Vector2D velocity;
    private int frameCount;
    public MeteoriteParticleExplosive() {
        Random random = new Random();
        this.frameCount = random.nextInt(10);
        this.renderer = new ImageRenderer("resources/meteorite/meteorite_small.png");
        this.velocity = new Vector2D();
    }

    public void configAction() {
        Action action = new ActionMoveBy(this.velocity, this.frameCount);
        this.add(action);
    }
}
