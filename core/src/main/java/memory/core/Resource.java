package memory.core;

public enum Resource {
    SANRIO_BACKGROUND("images/bg.png"),
    LOADING_BACKGROUND("images/loadingScreen.png"),
    TITLE_SCREEN("images/titleScreen.png"),
    PLAY_BUTTON("images/playButton.png"),
    PLAY_BUTTON_HOVER("images/playButtonHover.png"),
    ZERO("images/0.png"),
    ONE("images/1.png"),
    TWO("images/2.png"),
    THREE("images/3.png"),
    FOUR("images/4.png"),
    FIVE("images/5.png"),
    SIX("images/6.png"),
    SEVEN("images/7.png"),
    EIGHT("images/8.png"),
    NINE("images/9.png"),
    QUESTION_MARK("images/questionmark.png"),
    BUBBLE("images/bubble.png"),
    BUBBLE0("images/bubble0.png"),
    BUBBLE1("images/bubble1.png"),
    BUBBLE2("images/bubble2.png"),
    BIGBUBBLE("images/bigbubble.png"),
    LEFT_FROG_BUBBLE("images/leftFrogBubble.png"),
    RIGHT_FROG_BUBBLE("images/rightFrogBubble.png");

    private String url;

    Resource(String url) {
        this.url = url;
    }

    public String getName() {
        return url;
    }
}
