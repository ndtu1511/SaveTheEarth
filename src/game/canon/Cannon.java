package game.canon;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;
import Input.MouseMotionInput;
import Renderer.ImageRenderer;
import constants.Constant;

public class Cannon extends GameObject {
    Vector2D positionEarth;
    Vector2D axis;
    public static double angle;
    CanonShoot canonShoot;
    FrameCounter frameCounter;
    public Cannon() {
        this.angle=0.0;
        this.positionEarth =new Vector2D(Constant.TheEarth.POSITION_X,Constant.TheEarth.POSITION_Y);
        this.axis = new Vector2D(Constant.TheEarth.POSITION_X,0.0f).subtract(this.positionEarth).normalize().add(positionEarth);
        this.renderer = new ImageRenderer(Constant.Cannon.PATH);
        this.position.set(Constant.Windows.WIDTH/2,Constant.Windows.HEIGHT/2-55);
        canonShoot = new CanonShoot();
        frameCounter = new FrameCounter(10);
    }

    @Override
    public void run() {
        super.run();
        this.position.set(MouseMotionInput.instance.position.subtract(positionEarth).normalize().multiply(30).add(positionEarth));
        this.angle=this.axis.angleWithAVector(MouseMotionInput.instance.position);
        canonShoot.run(this);
        if (frameCounter.run()) {
//            canonShoot.run(this);
            frameCounter.reset();
        }
//        System.out.println(angle);
    }
}
