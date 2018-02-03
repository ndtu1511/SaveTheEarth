import Input.MouseInput;
import Input.MouseMotionInput;
import constants.Constant;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    private GameCanvas gameCanvas;
    private long lasttime=0;
    public GameWindow(){
        this.setSize(Constant.Windows.WIDTH,Constant.Windows.HEIGHT);
        this.setupGameCanvas();
        this.setVisible(true);
        this.event();
    }
    private void setupGameCanvas(){
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }
    private void event(){
        this.addMouseMotionListener(MouseMotionInput.instance);
        this.addMouseListener(MouseInput.instance);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
    public void gameLoop(){
        while (true){
            long currentTime = System.nanoTime();
            if (currentTime-this.lasttime>=Constant.Windows.DELAY_NANO_SECOND){
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lasttime=currentTime;
            }
        }
    }
}
