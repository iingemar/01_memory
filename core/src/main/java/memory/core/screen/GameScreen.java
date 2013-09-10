package memory.core.screen;

import memory.core.GameEngine;
import memory.core.Input;
import memory.core.Resource;
import memory.core.sprites.*;
import playn.core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

public class GameScreen implements Screen {
    private static int NUMBER_OF_TILES = 20;
    private static int TILES_PER_ROW = 5;
    private static int PX_BETWEEN_ROWS = 7;
    private static int BOARD_START_X = 160;
    private static int BOARD_START_Y = 70;
    
    private GameEngine game;
    private List<Tile> allTiles;
    private List<Tile> clickedTiles;
    private ImageLayer hoverMarker;
    private Canvas canvas;
    private float pause;
    private float timer;
    private int clicks;
    private List<Sprite> bubbles;
    private Random r = new Random();

    public GameScreen(GameEngine game) {
        this.game = game;
        init();
    }

    @Override
    public void init() {
        // Create and add background ImageLayer
        Image image = assets().getImage(Resource.SANRIO_BACKGROUND.getName());
        ImageLayer imageLayer = graphics().createImageLayer(image);
        graphics().rootLayer().add(imageLayer);

        // Create a GroupLayer to hold the sprites
        GroupLayer groupLayer = graphics().createGroupLayer();
        graphics().rootLayer().add(groupLayer);

        // Collections for tiles
        TileType[] types = TileType.values();
        int[] tiles = new int[NUMBER_OF_TILES];
        allTiles = new ArrayList<Tile>();
        clickedTiles = new ArrayList<Tile>();

        // Create tiles
        for (int i=0; i<NUMBER_OF_TILES; i++) {
            tiles[i] = (int) Math.floor(i/2);
        }

        // Shuffle tiles
        for (int i=NUMBER_OF_TILES-1; i>0; i--) {
            // Switch current item with random picked
            int swap = (int) Math.floor(Math.random() * i);
            int temp = tiles[i];
            tiles[i] = tiles[swap];
            // Set random picked as current
            tiles[swap] = temp;
        }

        // Place tiles
        for (int i=0; i<NUMBER_OF_TILES; i++) {
            TileType tileType = types[tiles[i]];
            int x = BOARD_START_X + (Tile.SIZE + PX_BETWEEN_ROWS) * (i % TILES_PER_ROW);
            int y = BOARD_START_Y + (int) ((Tile.SIZE + PX_BETWEEN_ROWS) * Math.floor(i / TILES_PER_ROW));
            Tile tile = new Tile(groupLayer, x, y, tileType);
            allTiles.add(tile);
        }

        // Random colored hover state
        CanvasImage canvasImage = graphics().createImage(Tile.SIZE, Tile.SIZE);
        canvas = canvasImage.canvas();
        canvas.setStrokeWidth(1);
        Random r = new Random();
        int color = 255 << 24 | r.nextInt(255) << 16 | r.nextInt(255) << 8 | r.nextInt(255);
        canvas.setStrokeColor(color);
        canvas.strokeRect(0, 0, Tile.SIZE-1, Tile.SIZE-1);

        hoverMarker = graphics().createImageLayer(canvasImage);
        hoverMarker.setTranslation(0, 0);
        hoverMarker.setVisible(false);
        graphics().rootLayer().add(hoverMarker);

        // Talk bubbles
        bubbles = new ArrayList<Sprite>() ;
        bubbles.add(new KittyBubble(groupLayer, 580, 317));
        bubbles.add(new LeftFrogBubble(groupLayer, 37, 409));
        bubbles.add(new RightFrogBubble(groupLayer, 185, 418));
    }

    @Override
    public void cleanup() {
        // Not used atm
    }

    @Override
    public void pause() {
        // Not used atm
    }

    @Override
    public void resume() {
        // Not used atm
    }

    @Override
    public void handleMouseUpEvent(Mouse.ButtonEvent buttonEvent) {

    }

    @Override
    public void handleMouseDownEvent(Mouse.ButtonEvent buttonEvent) {
        for (Tile tile : allTiles) {
            // Only register clicks that hit tiles and when less than 2
            if (tile.isTarget(buttonEvent.x(), buttonEvent.y()) && clickedTiles.size() < 2) {
                // Check if current tile already been clicked
                if (! clickedTiles.contains(tile)) {
                    tile.showQuestionMark(false);
                    clickedTiles.add(tile);
                    clicks++;
                }
            }
        }
    }

    @Override
    public void update(float delta) {
        timer += delta;

        boolean checkMatch = clickedTiles.size() == 2;

        if (checkMatch) {
            pause += delta;  // 25 ms
        }

        if (checkMatch && pause > 700) {
            Tile one = clickedTiles.get(0);
            Tile two = clickedTiles.get(1);

            if (one.getType().equals(two.getType())) {
                // Show bubble message when find pair!
                // If one bubble is active, show another one.
                Sprite activeBubble = getRandomActiveBubble();
                activeBubble.show(1200);

                // Clear tile images and remove
                one.clear();
                allTiles.remove(one);
                two.clear();
                allTiles.remove(two);
            } else {
                one.showQuestionMark(true);
                two.showQuestionMark(true);
            }

            clickedTiles.clear();
            pause = 0;
        }

        boolean done = allTiles.size() == 0;

        if (done) {
            // Hide marker
            hoverMarker.setVisible(false);
            // Show all bubbles? wooo
            for (Sprite bubble : bubbles) {
                bubble.show(3000);
            }

            // pause 2 seconds
            pause += delta;  // 25 ms
            if (pause > 1500) {
                // Go to game end screen
                game.setScreen(new EndScreen(game, timer, clicks));
            }
        }

        // Update all objects
        for (Sprite bubble : bubbles) {
            bubble.update(delta);
        }
    }

    /**
     * Returns a random active bubble.
     * @return
     */
    private Sprite getRandomActiveBubble() {
        while (true) {
            Sprite bubble = bubbles.get(r.nextInt(2));
            if (! bubble.isActive()) {
                return bubble;
            }
        }
    }

    @Override
    public void draw() {
        // Not used atm
    }

    @Override
    public void handleMouseMovedEvent(Mouse.MotionEvent event) {
        for (Tile tile : allTiles) {
            if (tile.isTarget(event.x(), event.y())) {
                hoverMarker.setVisible(true);
                hoverMarker.setTranslation(tile.getX(), tile.getY());
            }
        }
    }

    @Override
    public void handleKeyboardEvents(float delta, Input input) {
        // Not used atm
    }
}
