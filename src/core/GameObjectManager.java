package core;

import Physic.BoxCollider;
import Physic.PhysicBody;
import game.canon.bullet.Bullet;
import game.earth.Earth;
import game.earth.Score;
import game.meteorite.Meteorite;

import java.awt.*;
import java.util.Vector;

public class GameObjectManager {
    public static GameObjectManager instance = new GameObjectManager();
    private Vector<GameObject> vector;
    private Vector<GameObject> newVector;
    public Vector plus;
    private GameObjectManager() {
        this.vector = new Vector<>();
        this.newVector = new Vector<>();
        this.plus = new Vector();
    }

    public void add(GameObject gameObject){
        newVector.add(gameObject);
    }

    public void runAll(){
        for (GameObject gameObject:vector){
            if (gameObject.isAlive) {
                gameObject.run();
            }
        }
        vector.addAll(newVector);
        newVector.clear();
    }

    public void renderAll(Graphics graphics){
        for (GameObject gameObject: vector){
            if (gameObject.isAlive) {
                gameObject.render(graphics);
            }
        }
    }
    public <T extends GameObject> T checkCollider(BoxCollider boxCollider, Class<T> cls){
        for (GameObject gameObject:vector){
            if (!gameObject.isAlive) continue;
            if (!cls.isInstance(gameObject)) continue;
            if (!(gameObject instanceof PhysicBody)) continue;
            BoxCollider other = ((PhysicBody) gameObject).getBoxCollider();
            if (boxCollider.checkCollider(other)){
                int i = 1;
                plus.add(i);
                return (T) gameObject;
            }
        }
        return null;
    }
    public <T extends GameObject> T autoAim(Bullet bullet){
        for (GameObject gameObject: vector){
            if (!gameObject.isAlive) continue;
            if (!(gameObject instanceof Meteorite)) continue;
            float x = gameObject.position.x - bullet.position.x;
            float y = gameObject.position.y - bullet.position.y;

            if ((int)Math.sqrt(x*x+y*y)<=50){
                bullet.velocity.gravity2(gameObject.position.x,gameObject.position.y, bullet.velocity.x, bullet.velocity.y);
            }

        }

        return null;
    }
    public <T extends  GameObject> T recycle(Class<T> cls){
        for (GameObject gameObject : vector){
            if (gameObject.isAlive) continue;
            if (!cls.isInstance(gameObject)) continue;
            gameObject.isAlive=true;
            gameObject.reset();
            return (T) gameObject;
        }
        try {
            T instance = cls.newInstance();
            this.add(instance);
            return instance;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

    }
    public Earth isEarth(){
        for (GameObject gameObject:vector){
            if (gameObject instanceof Earth){
                return (Earth) gameObject;
            }
        }
        return null;
    }
    public void clear(){
        this.vector.clear();
        this.newVector.clear();
    }

    public Earth hitEarth(){
        for (GameObject gameObject : vector) {
            if (!(gameObject.isAlive)) continue;
            if (!(gameObject instanceof Meteorite)) continue;
            if (gameObject.position.khoangcach(gameObject.position.x,gameObject.position.y)<= 100){
                ((Meteorite) gameObject).getHit(gameObject);
                hitEarth();
            }

        }
        return null;
    }
}
