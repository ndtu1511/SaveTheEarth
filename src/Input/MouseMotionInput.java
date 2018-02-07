package Input;

import core.Vector2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionInput implements MouseMotionListener {
    public Vector2D position;

    public static MouseMotionInput instance = new MouseMotionInput();
    private MouseMotionInput() {
        this.position = new Vector2D(400.0f,100.0f);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.position.set(clamp(e.getX(),20.0f,780.0f),clamp(e.getY(),0.0f,780.0f));
    }
    private float clamp(float value, float min, float max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
}
