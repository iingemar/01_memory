package memory.core.sprites;

import memory.core.Resource;
import playn.core.GroupLayer;

public class LeftFrogBubble extends Sprite {

    public LeftFrogBubble(GroupLayer groupLayer, int x, int y) {
        super(groupLayer, x, y);

        loadImage(Resource.LEFT_FROG_BUBBLE.getName());

        // Hide as default
        setVisible(false);
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
}
