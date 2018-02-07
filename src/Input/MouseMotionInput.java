package Input;

import Core.Vector2D;
import constants.Constant;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionInput implements MouseMotionListener {
    public Vector2D position;

    public static MouseMotionInput instance = new MouseMotionInput();
    private MouseMotionInput() {
        this.position = new Vector2D(Constant.Windows.WIDTH/2,Constant.Windows.HEIGHT/2-55);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.position.set(this.clamp(e.getX(),20.0f,780.0f),this.clamp(e.getY(),20.0f,780.0f));
    }
    private float clamp(float value, float min, float max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
}
