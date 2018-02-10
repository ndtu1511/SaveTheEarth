
package game.meteorite;

import constants.Constant;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;
import hit.HitObject;

import javax.swing.*;
import java.awt.*;

public class Meteorite extends GameObject implements PhysicBody, HitObject{
    protected BoxCollider boxCollider;
    private ImageRenderer imageRenderer;
    private MeteoriteHit meteoriteHit;
    public int highScore = 0;
    public Vector2D velocity;
//    private Clip clip;
    public Meteorite(){
        this.imageRenderer = new ImageRenderer(Constant.Meteorite.PATH);
        this.renderer = this.imageRenderer;
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,20);
        meteoriteHit = new MeteoriteHit();
    }
    @Override
    public void run(){
        super.run();
        this.velocity.gravity(this.position.x,this.position.y,this.velocity.x,this.velocity.y);
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        if (this.position.x<=0||this.position.y<=0||this.position.x>=800||this.position.y>=800){
            this.isAlive = false;
        }
        this.meteoriteHit.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive=false;
        DeadAni deadAni = GameObjectManager.instance.recycle(DeadAni.class);
        deadAni.position.set(this.position);
        deadAni.run();
//        this.clip = AudioUtils.instance.loadSound("resources/Sound/sfx/explosiveEnemy.wav");
//        this.clip.start();
    }
    public void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.setFont(new Font("NewellsHand", Font.ITALIC, 30));
        g2d.setColor(Color.white);
        g2d.drawString(String.valueOf(highScore), 660, 30);
    }
    public void plusScore(){
        this.highScore +=10;
    }

}
