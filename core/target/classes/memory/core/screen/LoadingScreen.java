package memory.core.screen;

import memory.core.GameEngine;
import memory.core.Input;
import memory.core.KickAssetWatcher;
import memory.core.Resource;
import playn.core.*;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

public class LoadingScreen implements Screen {

    private float timer;
    private GameEngine game;
    private boolean done;
    private KickAssetWatcher watcher;
    private Canvas canvas;

    public LoadingScreen(GameEngine game) {
        this.game = game;
        init();
    }

    @Override
    public void init() {
        done = false;

        // Create and add background image layer
		Image image = assets().getImage(Resource.LOADING_BACKGROUND.getName());
		ImageLayer imageLayer = graphics().createImageLayer(image);
		graphics().rootLayer().add(imageLayer);

        // Count down text
        CanvasImage canvasImage = graphics().createImage(160, 70);
        canvas = canvasImage.canvas();
        ImageLayer countDownLayer = graphics().createImageLayer(canvasImage);
        countDownLayer.setTranslation(160, 410);
        graphics().rootLayer().add(countDownLayer);

        // Pre loaf all gfx
        watcher = new KickAssetWatcher(new KickAssetWatcher.Listener() {
            @Override
            public void done() {
                done = true;
            }
            @Override
            public void error(Throwable throwable) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        // Adding assets to watch
        for (Resource resource : Resource.values()) {
            watcher.add(assets().getImage(resource.getName()));
        }

        watcher.start();
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
    public void update(float delta) {
        String result = "Loading " + watcher.getLoaded() + " / " + watcher.getTotal() + " ..";
        canvas.clear().drawText(result, 10, 10);

        if (done) {
            timer += delta;
            // Add some extra time, otherwise next screen wont work if too quick!
            if (timer > 1000) {
                game.setScreen(new TitleScreen(game));
            }
        }
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
