package memory.core.sprites;

import memory.core.Resource;
import playn.core.GroupLayer;

public class BigBubble extends Sprite {

    public BigBubble(GroupLayer groupLayer, int x, int y) {
        super(groupLayer, x, y);
        loadImage(Resource.BIGBUBBLE.getName());
        setVisible(true);
    }
}
