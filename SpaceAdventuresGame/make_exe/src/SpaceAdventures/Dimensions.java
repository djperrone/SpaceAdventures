package SpaceAdventures;

public class Dimensions
{
    public final int WIDTH, HEIGHT;
    public final int DEFAULT_SPRITE_WIDTH, DEFAULT_SPRITE_HEIGHT;
    public final int MIN_X_SPAWN, MAX_X_SPAWN;
    public final int MIN_SURVIVABLE_Y, MAX_SURVIVABLE_Y;

    public Dimensions(int width, int height)
    {
        WIDTH = width;
        HEIGHT = height;

        DEFAULT_SPRITE_WIDTH = DEFAULT_SPRITE_HEIGHT = 128;

        MIN_X_SPAWN = 0;
        MAX_X_SPAWN = WIDTH - DEFAULT_SPRITE_WIDTH-50;

        MIN_SURVIVABLE_Y = -DEFAULT_SPRITE_HEIGHT;
        MAX_SURVIVABLE_Y = HEIGHT + DEFAULT_SPRITE_HEIGHT;
    }
}