package memory.core.sprites;

public enum TileType {
    ZERO("images/0.png"),
    ONE("images/1.png"),
    TWO("images/2.png"),
    THREE("images/3.png"),
    FOUR("images/4.png"),
    FIVE("images/5.png"),
    SIX("images/6.png"),
    SEVEN("images/7.png"),
    EIGHT("images/8.png"),
    NINE("images/9.png");

    private String url;

    TileType(String url) {
        this.url = url;
    }

    public String getName() {
        return url;
    }
}
