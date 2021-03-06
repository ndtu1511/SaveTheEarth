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
        public static final String[] PATH_DEAD = {
                "resources/end_game_animation/ani01.png",
                "resources/end_game_animation/ani02.png",
                "resources/end_game_animation/ani03.png",
                "resources/end_game_animation/ani04.png",
                "resources/end_game_animation/ani05.png",
                "resources/end_game_animation/ani06.png",
                "resources/end_game_animation/ani07.png",
                "resources/end_game_animation/ani08.png",
                "resources/end_game_animation/ani09.png",
                "resources/end_game_animation/ani10.png",
                "resources/end_game_animation/ani11.png",
                "resources/end_game_animation/ani12.png",
                "resources/end_game_animation/ani13.png",
                "resources/end_game_animation/ani14.png",
        };
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
    public static class Meteorite{
        public static final String PATH = "resources/meteorite/meteorite_small.png";
        public static final String PATH_METEO_MEDIUM = "resources/meteorite/meteorite_medium.png";
        public static final String[] PATH_METEO_DEAD = {
                "resources/get_hit_animation/hitAni01.png",
                "resources/get_hit_animation/hitAni02.png",
                "resources/get_hit_animation/hitAni03.png",
                "resources/get_hit_animation/hitAni04.png",
                "resources/get_hit_animation/hitAni05.png",
                "resources/get_hit_animation/hitAni06.png",
                "resources/get_hit_animation/hitAni07.png",
                "resources/get_hit_animation/hitAni08.png",
                "resources/get_hit_animation/hitAni09.png"
        };
    }
    public static class UFO{
        public static final String PATH = "resources/ufo/ufo3.png";
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
