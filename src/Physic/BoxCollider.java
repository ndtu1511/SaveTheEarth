package Physic;

import core.Vector2D;

import java.awt.*;

public class BoxCollider {
    public Vector2D position;
    private float width;
    private float height;

    public BoxCollider(float width, float height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2D();
    }

    public boolean checkCollider(BoxCollider other){
        Rectangle r1 = new Rectangle
                ((int) (this.position.x - this.width/2), (int) (this.position.y - this.height/2)
                        , (int) this.width, (int) this.height);
        Rectangle r2 = new Rectangle
                ((int) (other.position.x - other.width/2), (int) (other.position.y - other.height/2)
                        , (int) other.width, (int) other.height);
        return r1.intersects(r2);
    }
}
