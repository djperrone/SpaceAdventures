package MyGame;

public class DefaultSpaceShipGun implements Gun{
    private SpaceShip owner;

    DefaultSpaceShipGun(SpaceShip owner)
    {
        this.owner = owner;
    }

    @Override
    public void spawnProjectile(SpaceShip owner)
    {
        owner.manager.spawner.spawnProjectile(this.owner);
    }
}
