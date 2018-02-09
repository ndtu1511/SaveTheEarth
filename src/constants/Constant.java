package constants;

public class Constant {
    public static class Windows{
        public static final int WIDTH = 800;
        public static final int HEIGHT = 800;
        public static final long DELAY_NANO_SECOND = 17_000_000;
    }
    public static class BackGround{
        public static final String PATH = "resources/background/background.jpg";
        public static final String PATHSUCTION = "resources/background/suction.png";
    }
    public static class TheEarth{
        public static final String PATH ="resources/earth/earth.png";
        public static final int POSITION_X = Windows.WIDTH/2;
        public static final int POSITION_Y = Windows.HEIGHT/2;
    }
    public static class Cannon{
        public static final String PATH = "resources/cannon/cannon.png";
    }
    public static class CrossHair{
        public static final String PATH = "resources/crosshair/cross_hair.png";
    }
    public static class Rocket{
        public static final String PATH = "resources/rocket/bullet.png";
    }
//    public static class Enemy{
//        public static final int WAIT_Frame_COUNTER;
//        public static final constants.Enemy RESOURCES;
//        static {
//            RESOURCES = Utils.parseJsoToObject("resources/json/enemy.json", constants.Enemy.class);
//            WAIT_Frame_COUNTER = (int) (RESOURCES.waitTime*60);
//        }
//    }
}
