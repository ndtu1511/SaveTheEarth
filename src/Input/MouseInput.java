package Input;

import Core.Vector2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    public Vector2D position;
    public boolean isClicked=false;
    public boolean isPressed=false;
    public boolean isReleased=false;
    public boolean isEntered=false;
    public boolean isExit=false;
    public static MouseInput instance = new MouseInput();
    private MouseInput(){
        position = new Vector2D();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        this.position.set(e.getX(),e.getY());
        this.isClicked=true;
        this.isPressed=false;
        this.isReleased=false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.position.set(e.getX(),e.getY());
        this.isClicked=false;
        this.isPressed=true;
        this.isReleased=false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.position.set(e.getX(),e.getY());
        this.isClicked=false;
        this.isPressed=false;
        this.isReleased=true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.position.set(e.getX(),e.getY());
        this.isExit=false;
        this.isEntered=true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.position.set(e.getX(),e.getY());
        this.isExit=true;
        this.isEntered=false;
    }
}
