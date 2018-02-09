package game.earth;

import core.GameObjectManager;

import java.util.Vector;

public class EarthHP {
    public int health;
    private Vector<HP> vector = new Vector<>();

    public EarthHP(int health) {
        this.health = health;
        for (int i = 0; i < health; i++) {
            HP hp = GameObjectManager.instance.recycle(HP.class);
            hp.position.set(40 * i + 20, 20);
            this.vector.add(hp);
        }
    }

    public boolean run(){
        if(this.health == 0) {
            return  false;
        } else {
            this.health -= 1;
            vector.elementAt(health).isAlive = false;
            return true;
        }
    }

    public void showHP(){

    }
}
