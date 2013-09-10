package memory.core.screen;

import memory.core.GameEngine;
import memory.core.Input;
import memory.core.Resource;
import memory.core.sprites.BigBubble;
import playn.core.*;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

public class EndScreen implements Screen {

    private GameEngine game;
    private float timer;
    private int clicks;
    private GroupLayer spriteLayer;
    private ImageLayer backgroundLayer;

    public EndScreen(GameEngine game, float timer, int clicks) {
        this.game = game;
        this.timer = timer;
        this.clicks = clicks;
        init();
    }

    @Override
    public void init() {
        // Create a background layer
		Image backgroundImage = assets().getImage(Resource.SANRIO_BACKGROUND.getName());
		backgroundLayer = graphics().createImageLayer(backgroundImage);
		graphics().rootLayer().add(backgroundLayer);

        // Create a group layer to hold the sprites, texts and buttons
		spriteLayer = graphics().createGroupLayer();
		graphics().rootLayer().add(spriteLayer);

        // Add results
        CanvasImage canvasImage = graphics().createImage(203, 176);
        Canvas canvas = canvasImage.canvas();
        float seconds = timer / 1000;
        String timer = "Timer = ";
        if (seconds > 60) {
            float minutes = seconds / 60;
            timer += (int)minutes + " minutes";
        } else {
            timer += (int)seconds + " seconds";
        }
        canvas.drawText(timer, 40, 85);
        canvas.drawText("Clicks = " + clicks, 40, 100);

        ImageLayer resultLayer = graphics().createImageLayer(canvasImage);
        resultLayer.setTranslation(349, 214);
        graphics().rootLayer().add(resultLayer);

        // Kitty speech bubble
        new BigBubble(spriteLayer, 349, 214);
    }

    @Override
    public void cleanup() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void pause() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resume() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleMouseUpEvent(Mouse.ButtonEvent buttonEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleMouseDownEvent(Mouse.ButtonEvent buttonEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(final float delta) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void draw() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleMouseMovedEvent(Mouse.MotionEvent event) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleKeyboardEvents(float delta, Input input) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
