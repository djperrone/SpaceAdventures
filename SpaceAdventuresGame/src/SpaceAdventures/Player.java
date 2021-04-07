package SpaceAdventures;

public class Player extends MovableHealthyObject{
    public Player(Team team, ID id, float xPosition, float yPosition, int width, int height, String textureName, float scale, float speed, float xVector, float yVector, float damage, float health) {
        super(team, id, xPosition, yPosition, width, height, textureName, scale, speed, xVector, yVector, damage, health);
    }

    @Override
    public void accept(CollideVisitor visitor) {

    }

    @Override
    public CollideVisitor getCollideHandler() {
        return null;
    }
}
