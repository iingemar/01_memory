package memory.core.sprites;

import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

/**
 * Sprite. Base class for
 * Tile
 * KittyBubble
 * ButtonSprite
 * 
 */
public class Sprite {
    private GroupLayer groupLayer;
    private ImageLayer imageLayer;
    private Image image;
    private int x;
    private int y;
    private float width;
    private float height;
    private float timer;
    private float limit;
    private boolean active;

    public Sprite(GroupLayer groupLayer, int x, int y) {
        this.groupLayer = groupLayer;
        this.x = x;  // position
        this.y = y;
    }

    public void loadImage(String imageURL) {
        image = assets().getImage(imageURL);
        width = image.width();
        height = image.height();
        imageLayer = graphics().createImageLayer(image);
        imageLayer.setTranslation(x, y);
        groupLayer.add(imageLayer);
    }

    public GroupLayer getGroupLayer() {
        return groupLayer;
    }

    public void setGroupLayer(GroupLayer groupLayer) {
        this.groupLayer = groupLayer;
    }

    public ImageLayer getImageLayer() {
        return imageLayer;
    }

    public void setImageLayer(ImageLayer imageLayer) {
        this.imageLayer = imageLayer;
    }

    public void removeImageLayer() {
        groupLayer.remove(imageLayer);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setHitBox(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void setVisible(boolean show) {
        getImageLayer().setVisible(show);
    }

    public void show(float limit) {
        setVisible(true);
        active = true;
        this.limit = limit;
        this.timer = 0;  // Restart timer 
    }

    public void update(float delta) {
        timer += delta;
    }

    public float getTimer() {
        return timer;
    }

    public void setTimer(float timer) {
        this.timer = timer;
    }

    public float getLimit() {
        return limit;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
