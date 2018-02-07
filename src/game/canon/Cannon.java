package game.canon;

import Core.GameObject;
import Core.Vector2D;
import Input.MouseMotionInput;
import Renderer.ImageRenderer;
import constants.Constant;

public class Cannon extends GameObject {
    Vector2D v;
    Vector2D axis;
    public static double angle;
    public Cannon() {
        this.angle=0.0;
        v=new Vector2D(Constant.TheEarth.positionX,Constant.TheEarth.positionY);
        axis = new Vector2D(Constant.TheEarth.positionX,0.0f).subtract(this.v).normalize().add(v);
        this.renderer = new ImageRenderer(Constant.Cannon.PATH);
        this.position.set(Constant.Windows.WIDTH/2,Constant.Windows.HEIGHT/2-55);
    }

    @Override
    public void run() {
        super.run();
        this.position.set(MouseMotionInput.instance.position.subtract(v).normalize().multiply(45).add(v));
        this.angle=this.axis.angleWithAVector(MouseMotionInput.instance.position);
//        System.out.println(angle);
    }
}
