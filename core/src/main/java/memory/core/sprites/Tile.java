package memory.core.sprites;

import memory.core.Resource;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

public class Tile extends Sprite {
    public static int SIZE = 70;

    private TileType type;
    private ImageLayer questionMarkLayer;

    public Tile(GroupLayer groupLayer, int x, int y, TileType type) {
        super(groupLayer, x, y);
        this.type = type;

        loadImage(type.getName());

        // Question mark above
        Image image = assets().getImage(Resource.QUESTION_MARK.getName());
        questionMarkLayer = graphics().createImageLayer(image);
        questionMarkLayer.setSize(SIZE, SIZE);
        questionMarkLayer.setTranslation(x, y);
        groupLayer.add(questionMarkLayer);
    }

    public boolean isTarget(float buttonX, float buttonY) {
        return buttonX > getX() && buttonX < getX() + SIZE
                && buttonY > getY() && buttonY < getY() + SIZE;
    }

    public TileType getType() {
        return type;
    }

    public void clear() {
        removeImageLayer();
        getGroupLayer().remove(questionMarkLayer);
    }

    public void showQuestionMark(boolean show) {
        questionMarkLayer.setVisible(show);
    }
}
