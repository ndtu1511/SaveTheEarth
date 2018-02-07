package Renderer;

import Core.Vector2D;
import Input.MouseMotionInput;
import constants.Constant;
import game.canon.Cannon;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRenderer implements Renderer {
    private BufferedImage image;
    private double angle;
    String url;
    public ImageRenderer(String url){
        this.angle=0;
        this.url=url;
        this.image= Utils.loadImage(url);
    }
    @Override
    public void render(Graphics graphics, Vector2D position) {
        if (this.image!=null){
            Graphics2D g2d = (Graphics2D) graphics.create();
            if (this.url==Constant.Cannon.PATH){
                this.angle=360-Cannon.angle;
                g2d.rotate(Math.toRadians(this.angle),position.x,position.y);
                g2d.drawImage(this.image,(int)position.x-this.image.getWidth()/2,(int)position.y-this.image.getHeight()/2,null);
            }
            else {
                g2d.drawImage(this.image, (int) position.x - this.image.getWidth() / 2, (int) position.y - this.image.getHeight() / 2, null);
            }
        }
    }
}
