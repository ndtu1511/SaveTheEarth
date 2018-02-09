package Renderer;

import constants.Constant;
import core.Vector2D;
import game.canon.Cannon;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRenderer implements Renderer {
    private BufferedImage image;
    private String url;
    private double angle;
    private boolean rotatedImage;
    public ImageRenderer(String url){
        this.image= Utils.loadImage(url);
        this.url = url;
        this.angle=0;
        this.rotatedImage=false;
    }
    @Override
    public void render(Graphics graphics, Vector2D position) {
        if (this.image!=null){
            Graphics2D g2d = (Graphics2D) graphics.create();
            if (this.url.equalsIgnoreCase(Constant.Cannon.PATH)){
                this.angle=360-Cannon.angle;
                g2d.rotate(Math.toRadians(this.angle),position.x,position.y);
            }
            if (this.url.equalsIgnoreCase(Constant.BackGround.PATH)){
                g2d.drawImage(this.image,(int)position.x-this.image.getWidth()/2,(int)position.y-this.image.getHeight()/2,null);
                graphics.setColor(Color.gray);
                g2d.fillRect(Constant.Windows.WIDTH,Constant.Windows.HEIGHT,70,70);
                graphics.fillRect(Constant.Windows.WIDTH,Constant.Windows.HEIGHT,70,70);
            }
            else g2d.drawImage(this.image,(int)position.x-this.image.getWidth()/2,(int)position.y-this.image.getHeight()/2,null);
        }
    }
}
