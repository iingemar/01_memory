package memory.core;

import playn.core.Game;

import static playn.core.PlayN.graphics;

public class Memory implements Game {
    public static int GAME_WIDTH = 700;
    public static int GAME_HEIGHT = 525;
    private GameEngine game;

    @Override
    public void init() {
        graphics().setSize(GAME_WIDTH, GAME_HEIGHT);
        game = new GameEngine();
    }

    @Override
    public void paint(float alpha) {
        // the background automatically paints itself, so no need to do anything here!
    }

    @Override
    public void update(float delta) {
        game.update(delta);
    }

    @Override
    public int updateRate() {
        return 25;
    }
}
