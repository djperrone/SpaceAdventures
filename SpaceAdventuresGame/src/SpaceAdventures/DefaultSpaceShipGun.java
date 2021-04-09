package SpaceAdventures;

public class DefaultSpaceShipGun extends Gun{
    private SpaceShip owner;

    DefaultSpaceShipGun(SpaceShip owner)
    {
        super(owner);
        this.owner = owner;

    }

    @Override
    public void spawnProjectile(SpaceShip owner)
    {
        owner.manager.spawner.spawnProjectile(this.owner);
    }
}
