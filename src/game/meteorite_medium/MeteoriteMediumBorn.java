package game.meteorite_medium;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.meteorite.Meteorite;

import java.util.Random;

public class MeteoriteMediumBorn extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
    private Integer count;

    public MeteoriteMediumBorn() {
        this.frameCounter = new FrameCounter(100);
        this.random = new Random();
        this.count = 0;
    }
    public void run(){
        int maxvelocity = 1;
        if(this.frameCounter.run()) {
            MeteoriteMedium meteoriteMedium = new MeteoriteMedium();
            int rd;
            rd = random.nextInt(3)+1;
            if (rd == 1) {
                meteoriteMedium.position.set(new Vector2D(5,random.nextInt(790)+5));
                meteoriteMedium.velocity.set(new Vector2D(random.nextInt(maxvelocity+1),
                        random.nextInt(2*maxvelocity+1) - maxvelocity));
            } else if (rd == 2) {
                meteoriteMedium.position.set(new Vector2D(795,random.nextInt(790)+5));
                meteoriteMedium.velocity.set(new Vector2D(-random.nextInt(2*maxvelocity+1)+maxvelocity,
                        random.nextInt(2*maxvelocity+1) - maxvelocity));
            } else if (rd == 3) {
                meteoriteMedium.position.set(new Vector2D(random.nextInt(795)+5,5));
                meteoriteMedium.velocity.set(new Vector2D(random.nextInt(2*maxvelocity+1)-maxvelocity,
                        random.nextInt(maxvelocity+1)));
            } else if (rd == 4) {
                meteoriteMedium.position.set(new Vector2D(random.nextInt(795)+5,795));
                meteoriteMedium.velocity.set(new Vector2D(random.nextInt(2*maxvelocity+1)-maxvelocity,
                        -random.nextInt(2*maxvelocity+1) + maxvelocity));
            }
            GameObjectManager.instance.add(meteoriteMedium);
            this.frameCounter.reset();
        }
    }
}