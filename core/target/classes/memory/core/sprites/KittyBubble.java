package memory.core.sprites;

import memory.core.Resource;
import playn.core.GroupLayer;
import playn.core.Image;

import java.util.Random;

import static playn.core.PlayN.assets;

public class KittyBubble extends Sprite {

    /**
     * Handles different speech bubble messages.
     */
    private enum KittyBubbleType {
        BUBBLE0(assets().getImage(Resource.BUBBLE0.getName())),
        BUBBLE1(assets().getImage(Resource.BUBBLE1.getName())),
        BUBBLE2(assets().getImage(Resource.BUBBLE2.getName()));

        private Image image;

        KittyBubbleType(Image image) {
            this.image = image;
        }

        public Image getImage() {
            return image;
        }
    }

    private Random r = new Random();

    public KittyBubble(GroupLayer groupLayer, int x, int y) {
        super(groupLayer, x, y);

        loadImage(Resource.BUBBLE0.getName());

        // Hide as default
        setVisible(false);
    }

    private Image getRandomImage() {
        return KittyBubbleType.values()[r.nextInt(2)].getImage();
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        if (isActive() && getTimer() > getLimit()) {
            setVisible(false);
            setActive(false);
            setTimer(0);
            setLimit(0);
        }
    }

    @Override
    public void show(float limit) {
        // Get random message bubble and set
        if (!isActive()) {
            getImageLayer().setImage(getRandomImage());
        }
        // Show it
        super.show(limit);
    }
}
