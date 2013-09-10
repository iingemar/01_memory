package memory.core.sprites;

import memory.core.Resource;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.Mouse;

import java.util.HashMap;
import java.util.Map;

import static playn.core.PlayN.assets;

public class ButtonSprite extends Sprite {

    private Image play;
    private Image playHover;

    public ButtonSprite(final GroupLayer groupLayer, final int x, final int y) {
        super(groupLayer, x, y);
        loadImage(Resource.PLAY_BUTTON.getName());

        play = assets().getImage(Resource.PLAY_BUTTON.getName());
        playHover = assets().getImage(Resource.PLAY_BUTTON_HOVER.getName());
    }

    public boolean isClicked(Mouse.ButtonEvent event) {
        if (event.x() > getX() &&
            event.x() < getX() + getWidth() &&
            event.y() > getY() &&
            event.y() < getY() + getHeight()) {
            return true;
        } else {
            return false;
        }
    }

    public void handleHover(Mouse.MotionEvent event) {
        if (event.x() > getX() &&
            event.x() < getX() + getWidth() &&
            event.y() > getY() &&
            event.y() < getY() + getHeight()) {
            getImageLayer().setImage(playHover);
        } else {
            getImageLayer().setImage(play);
        }
    }
}
