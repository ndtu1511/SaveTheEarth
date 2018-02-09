package game.meteorite.explosive;

import Renderer.ImageRenderer;
import action.Action;
import action.ActionMoveBy;
import core.FrameCounter;
import core.GameObject;
import core.Vector2D;

import java.util.Random;

public class MeteoriteParticleExplosive extends GameObject {
    private Random random = new Random();
    public Vector2D velocity;
    public FrameCounter frameCounter;
    private String[] url = {
            "resources/meteorite/explosion_particle_1.png",
            "resources/meteorite/explosion_particle_2.png",
            "resources/meteorite/explosion_particle_3.png",
            "resources/meteorite/explosion_particle_4.png",
            "resources/meteorite/explosion_particle_5.png"};
    public MeteoriteParticleExplosive() {
        this.renderer = new ImageRenderer(this.url[random.nextInt(5)]);
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        if (frameCounter.run()){
            this.isAlive = false;
        } else {
            this.position.addUp(this.velocity);
        }
    }
}
