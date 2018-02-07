package core;

import Renderer.Renderer;
import action.Action;

import java.awt.*;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    protected Renderer renderer;
    public boolean isAlive;
    public Graphics graphics;
    private Vector<Action> actions;
    private Vector<Action> newActions = new Vector<>();
    public GameObject() {
        this.position = new Vector2D();
        this.isAlive=true;
        this.actions = new Vector<>();
    }
    public void run(){
        this.actions.removeIf(action -> action.run(this));
        this.actions.addAll(this.newActions);
        this.newActions.clear();
    }

    public void add(Action action){
        this.newActions.add(action);
    }
    public void reset(){
        this.actions.removeAllElements();
    }
    public void render(Graphics graphics){
        if (this.renderer!=null) {
            this.graphics=graphics;
            this.renderer.render(graphics, this.position);
        }
    }
}
