package Renderer;

import Core.FrameCounter;
import Core.Vector2D;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AnimationRenderer implements Renderer {
    private boolean isRepeat;
    private List<BufferedImage> list;
    private int currentIndex;
    public boolean disable;
    private FrameCounter frameCounter;
    public AnimationRenderer(boolean isRepeat,int timeInterval, String... urls){
        this.isRepeat=isRepeat;
        this.list = new ArrayList<>();
        this.disable=false;
        Arrays.asList(urls).stream().forEach(url -> {
            list.add(Utils.loadImage(url));
        });
        this.frameCounter = new FrameCounter(timeInterval);
    }
    @Override
    public void render(Graphics graphics, Vector2D position) {
        if (this.disable) return;
        BufferedImage image = this.list.get(this.currentIndex);
        Vector2D origin = position.subtract( image.getWidth() / 2, image.getHeight() / 2);
        graphics.drawImage(image,
                (int)origin.x,
                (int) origin.y,
                null
        );
        if (this.currentIndex == this.list.size() - 1 && !this.isRepeat) {
            this.disable = true;
        } else {
            if (this.frameCounter.run()) {
                this.changeFrame();
                this.frameCounter.reset();
            }
        }
    }
    private void changeFrame() {
        if (this.currentIndex >= this.list.size() - 1) {
            this.currentIndex = 0;
        } else {
            this.currentIndex += 1;
        }
    }

    public void reset() {
        this.currentIndex = 0;
    }
}
