package game.meteorite;

import Physic.BoxCollider;
import Renderer.ImageRenderer;
import constants.Constant;
import core.GameObject;
import explosionpackage.ExplosionMaker;
import game.canon.Rocket;

public class MeteoMedium extends Meteorite {
    private ExplosionMaker explosionMaker;
    public MeteoMedium() {
        this.renderer = new ImageRenderer(Constant.Meteorite.PATH_METEO_MEDIUM);
        this.boxCollider = new BoxCollider(40,40);
        explosionMaker=new ExplosionMaker();
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive=false;
        if (gameObject instanceof Rocket){
            explosionMaker.position.set(this.position);
            explosionMaker.config(2);
        }
        else{
            super.getHit(gameObject);
        }
    }
}
