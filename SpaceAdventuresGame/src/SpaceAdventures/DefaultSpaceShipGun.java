package SpaceAdventures;

public class DefaultSpaceShipGun extends Gun{
    private SpaceShip owner;

    float xPosition;
    float yPosition;
    Team team;
    float direction;

    DefaultSpaceShipGun(float xPosition, float yPosition, Team team, float direction)
    {
        super();
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.team = team;
        this.direction = direction;



    }

    //@Override
    public void spawnProjectile(float xPosition, float yPosition, Team team, float direction)
    {
        owner.manager.spawner.spawnProjectile(xPosition,yPosition,team,direction);
    }
}
