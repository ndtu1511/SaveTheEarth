package explosionpackage;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.meteorite.MeteoMedium;
import game.meteorite.Meteorite;

import java.util.Random;

public class ExplosionMaker extends GameObject{
    private Random random = new Random();
    public String[] url;
    public ExplosionMaker() {
        this.url = url;
    }

    public void config(int number, int liveTime){
        for (int i = 0; i < 360; i+= 360 / number) {
            ExplosionParticle explosionParticle = GameObjectManager.instance.recycle(ExplosionParticle.class);
            explosionParticle.url = this.url;
            explosionParticle.position.set(this.position);
            explosionParticle.velocity.set((new Vector2D(0,1).rotate(i).multiply(random.nextInt(7)+2)));
            explosionParticle.frameCounter = new FrameCounter(random.nextInt(liveTime) + 20);
        }
    }
    public void config(int number){
        int maxvelocity = 2;
        for (int i=0;i<360;i+=360/number){
            Meteorite meteorite = new Meteorite();
            meteorite.position.set(this.position);
            meteorite.velocity.set(meteorite.velocity.set(new Vector2D(random.nextInt(maxvelocity+1),
                    random.nextInt(2*maxvelocity+1) - maxvelocity)));
            GameObjectManager.instance.add(meteorite);
        }
    }
}
