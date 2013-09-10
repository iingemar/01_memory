package memory.core.screen;

import memory.core.GameEngine;
import memory.core.Input;
import memory.core.Resource;
import memory.core.sprites.ButtonSprite;
import playn.core.*;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

public class TitleScreen implements Screen {

    private GroupLayer spriteLayer;
    private GameEngine game;
    private ButtonSprite playButton;
    private ImageLayer backgroundLayer;

    public TitleScreen(GameEngine game) {
        this.game = game;
        init();
    }

    @Override
    public void init() {
        // Create a background layer
		Image backgroundImage = assets().getImage(Resource.TITLE_SCREEN.getName());
		backgroundLayer = graphics().createImageLayer(backgroundImage);
		graphics().rootLayer().add(backgroundLayer);

        // Create a group layer to hold the sprites, texts and buttons
		spriteLayer = graphics().createGroupLayer();
		graphics().rootLayer().add(spriteLayer);
        
        // Create buttons and images
        playButton = new ButtonSprite(spriteLayer, 270, 270);
    }

    @Override
    public void cleanup() {
        graphics().rootLayer().remove(spriteLayer);
        graphics().rootLayer().remove(backgroundLayer);
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
        if (playButton.isClicked(buttonEvent)) {
            game.setScreen(new GameScreen(game));
            cleanup();
        }
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
        playButton.handleHover(event);
    }

    @Override
    public void handleKeyboardEvents(float delta, Input input) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
