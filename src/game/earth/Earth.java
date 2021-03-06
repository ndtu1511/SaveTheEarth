package game.earth;

import Renderer.AnimationRenderer;
import com.sun.deploy.util.SessionState;
import core.GameObject;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;
import constants.Constant;
import core.GameObjectManager;
import game.meteorite.DeadAni;
import game.ufo.Rocket;
import hit.HitObject;
import scene.GameOverviewScene;
import scene.ReplayScreen;
import scene.SceneManager;
import utils.AudioUtils;

import javax.sound.sampled.Clip;

public class Earth extends GameObject implements PhysicBody, HitObject{
    private BoxCollider boxCollider;
    private EarthHP earthHP;
    private ImageRenderer imageRenderer;
    private Clip clip;


    public Earth() {
        this.position.set(Constant.Windows.WIDTH/2,Constant.Windows.HEIGHT/2);
        this.imageRenderer = new ImageRenderer(Constant.TheEarth.PATH);
        this.earthHP = new EarthHP(5);
        this.boxCollider = new BoxCollider(30,30);
        this.renderer = this.imageRenderer;
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x,this.position.y-15);
//        this.earthHP.doDrawing(graphics);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        Score.highScore -= 10;
        this.isAlive = this.earthHP.run();
        if (!this.isAlive) {
//            SceneManager.instance.changeScene(new ReplayScreen());
            DeadAni deadAni = GameObjectManager.instance.recycle(DeadAni.class);
            deadAni.renderer = new AnimationRenderer(false, 5, Constant.TheEarth.PATH_DEAD);
            deadAni.position.set(this.position);
            deadAni.run();

            SceneManager.instance.changeScene(new ReplayScreen());

        }
//        this.clip = AudioUtils.instance.loadSound("resources/Sound/sfx/explosiveEarth.wav");
//        this.clip.start();
    }
}
