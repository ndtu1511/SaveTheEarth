package game.meteorite;

import action.*;
import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.earth.Score;
import game.ufo.Rocket;
import game.ufo.Ufo;

import java.util.Random;

public class MeteoriteBorn extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
    private Integer count;
    private int countMeteoSmall;
    private int countMeteoMedium;
    private int countUfo;
    private int maxvelocity;
    private int numberMeteoSmall;

    public MeteoriteBorn() {
        this.frameCounter = new FrameCounter(40);
        this.random = new Random();
        this.count = 0;
        this.countMeteoSmall=0;
        this.countMeteoMedium=0;
        this.countUfo=0;
        this.numberMeteoSmall=20;
        maxvelocity=2;
        this.configAction();
    }
//    public void run(){
//        if(this.frameCounter.run()) {
////            Meteorite meteorite = new Meteorite();
//            int rd;
//            rd = random.nextInt(5)+1;
//            if (rd == 1) {
//                MeteoMedium meteorite = GameObjectManager.instance.recycle(MeteoMedium.class);
//                meteorite.position.set(new Vector2D(5, random.nextInt(790) + 5));
//                meteorite.velocity.set(new Vector2D(random.nextInt(maxvelocity + 1),
//                        random.nextInt(2 * maxvelocity + 1) - maxvelocity));
//            }
//              else if (rd == 2) {
//                  Meteorite meteorite = GameObjectManager.instance.recycle(Meteorite.class);
//                  meteorite.position.set(new Vector2D(795, random.nextInt(790) + 5));
//                  meteorite.velocity.set(new Vector2D(-random.nextInt(2 * maxvelocity + 1) + maxvelocity,
//                          random.nextInt(2 * maxvelocity + 1) - maxvelocity));
//            } else if (rd == 3) {
//                Meteorite meteorite = GameObjectManager.instance.recycle(Meteorite.class);
//                meteorite.position.set(new Vector2D(random.nextInt(795)+5,5));
//                meteorite.velocity.set(new Vector2D(random.nextInt(2*maxvelocity+1)-maxvelocity,
//                        random.nextInt(maxvelocity+1)));
//            } else if (rd == 4) {
//                Meteorite meteorite = GameObjectManager.instance.recycle(Meteorite.class);
//                meteorite.position.set(new Vector2D(random.nextInt(795)+5,795));
//                meteorite.velocity.set(new Vector2D(random.nextInt(2*maxvelocity+1)-maxvelocity,
//                        -random.nextInt(2*maxvelocity+1) + maxvelocity));
//            }
//            else if (rd==5){
//                Ufo ufo = GameObjectManager.instance.recycle(Ufo.class);
//                int rUfo = random.nextInt(4);
//                if (rUfo==0){
//                    ufo.position.set(random.nextInt(200)+50,20.0f);
//                    ufo.velocity.set(0.0f,3.0f);
//                }
//                if (rUfo==1){
//                    ufo.position.set(random.nextInt(200)+550,780.0f);
//                    ufo.velocity.set(0.0f,-3.0f);
//                }
//                if (rUfo==2){
//                    ufo.position.set(20.0f,random.nextInt(200)+550);
//                    ufo.velocity.set(3.0f,0.0f);
//                }
//                if (rUfo==3){
//                    ufo.position.set(780.0f,random.nextInt(200)+50);
//                    ufo.velocity.set(-3.0f,0.0f);
//                }
//            }
//            this.frameCounter.reset();
//        }
//    }
    public void configAction(){
        Action waitAction = new WaitAction(600);
        Action actionMeteoSmall = new Action() {
            @Override
            public boolean run(GameObject ownner) {
                if (countMeteoSmall==200)return true;
                int rd = random.nextInt(4)+1;
                Meteorite meteorite = GameObjectManager.instance.recycle(Meteorite.class);
                Score.highScore++;
                if (rd == 1) {
                    meteorite.position.set(new Vector2D(5, random.nextInt(790) + 5));
                    meteorite.velocity.set(new Vector2D(random.nextInt(maxvelocity+1),
                            random.nextInt(2*maxvelocity+1) - maxvelocity));
                }
                else if (rd == 2) {
                    meteorite.position.set(new Vector2D(795, random.nextInt(790) + 5));
                    meteorite.velocity.set(new Vector2D(-random.nextInt(2 * maxvelocity + 1) + maxvelocity,
                            random.nextInt(2 * maxvelocity + 1) - maxvelocity));
                } else if (rd == 3) {
                    meteorite.position.set(new Vector2D(random.nextInt(795)+5,5));
                    meteorite.velocity.set(new Vector2D(random.nextInt(2*maxvelocity+1)-maxvelocity,
                            random.nextInt(maxvelocity+1)));
                } else if (rd == 4) {
                    meteorite.position.set(new Vector2D(random.nextInt(795)+5,795));
                    meteorite.velocity.set(new Vector2D(random.nextInt(2*maxvelocity+1)-maxvelocity,
                            -random.nextInt(2*maxvelocity+1) + maxvelocity));
                }
                countMeteoSmall++;
                return true;
            }

            @Override
            public void reset() {

            }
        };
        Action actionMeteoMedium = new Action() {
            @Override
            public boolean run(GameObject ownner) {
//                if (countMeteoSmall!=200) return true;
                if (countMeteoMedium==50) return true;
                int rd = random.nextInt(4)+1;
                MeteoMedium meteorite = GameObjectManager.instance.recycle(MeteoMedium.class);
                Score.highScore++;
                if (rd == 1) {
                    meteorite.position.set(new Vector2D(5, random.nextInt(790) + 5));
                    meteorite.velocity.set(new Vector2D(random.nextInt(maxvelocity+1),
                            random.nextInt(2*maxvelocity+1) - maxvelocity));
                }
                else if (rd == 2) {
                    meteorite.position.set(new Vector2D(795, random.nextInt(790) + 5));
                    meteorite.velocity.set(new Vector2D(-random.nextInt(2 * maxvelocity + 1) + maxvelocity,
                            random.nextInt(2 * maxvelocity + 1) - maxvelocity));
                } else if (rd == 3) {
                    meteorite.position.set(new Vector2D(random.nextInt(795)+5,5));
                    meteorite.velocity.set(new Vector2D(random.nextInt(2*maxvelocity+1)-maxvelocity,
                            random.nextInt(maxvelocity+1)));
                } else if (rd == 4) {
                    meteorite.position.set(new Vector2D(random.nextInt(795)+5,795));
                    meteorite.velocity.set(new Vector2D(random.nextInt(2*maxvelocity+1)-maxvelocity,
                            -random.nextInt(2*maxvelocity+1) + maxvelocity));
                }
                countMeteoMedium++;
                return true;
            }

            @Override
            public void reset() {

            }
        };
        Action actionUfo = new Action() {
            @Override
            public boolean run(GameObject ownner) {
                if (countUfo==10) return true;
                Ufo ufo = GameObjectManager.instance.recycle(Ufo.class);
                Score.highScore++;
                int rUfo = random.nextInt(4);
                if (rUfo==0){
                    ufo.position.set(random.nextInt(200)+50,20.0f);
                    ufo.velocity.set(0.0f,3.0f);
                }
                if (rUfo==1){
                    ufo.position.set(random.nextInt(200)+550,780.0f);
                    ufo.velocity.set(0.0f,-3.0f);
                }
                if (rUfo==2){
                    ufo.position.set(20.0f,random.nextInt(200)+550);
                    ufo.velocity.set(3.0f,0.0f);
                }
                if (rUfo==3){
                    ufo.position.set(780.0f,random.nextInt(200)+50);
                    ufo.velocity.set(-3.0f,0.0f);
                }
                countUfo++;
                return true;
            }

            @Override
            public void reset() {

            }
        };
        this.add(new RepeatForeverAction(
                new SequenceAction(
                new WaitAction(100),
                actionMeteoSmall
                )
            )
        );
        this.add(new SequenceAction(
                waitAction,
                new GroupAction(
                        new RepeatForeverAction(
                                new SequenceAction(
                                        new WaitAction(350),
                                        actionMeteoMedium
                                )
                        ),
                        new RepeatForeverAction(
                              new SequenceAction(
                                      new WaitAction(600),
                                      actionUfo
                              )
                        ),
                        new RepeatForeverAction(
                                new SequenceAction(
                                        new WaitAction(200),
                                        actionMeteoSmall
                                )
                        )
                )
        ));
        this.add(new SequenceAction(
                new WaitAction(5000),
                new GroupAction(
                        new RepeatForeverAction(
                                new SequenceAction(
                                        new WaitAction(300),
                                        actionMeteoMedium
                                )
                        ),
                        new RepeatForeverAction(
                                new SequenceAction(
                                        new WaitAction(500),
                                        actionUfo
                                )
                        )
                )
        ));
//        this.numberMeteoSmall=20;
//        this.add(new RepeatForeverAction(
//                new SequenceAction(
//                        new WaitAction(50),
//                        actionMeteoSmall
//                )
//        ));
    }
}
