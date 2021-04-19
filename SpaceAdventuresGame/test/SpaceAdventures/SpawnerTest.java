package SpaceAdventures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SpawnerTest {
    public static final int WIDTH = 1280, HEIGHT = WIDTH/12 *9;
    Dimensions dimensions;
    LinkedList<MovableHealthyObject> objectList;
    LinkedList<UFO> ufoList;

    private Spawner spawner;

    @BeforeEach
    void initSpawner()
    {
        dimensions = new Dimensions(WIDTH,HEIGHT);
        objectList = new LinkedList<>();
        ufoList = new LinkedList<>();
        dimensions = new Dimensions(WIDTH,HEIGHT);
        spawner = new Spawner(objectList,ufoList, dimensions );

    }

    @AfterEach
    void cleanList()
    {
        objectList.clear();
        ufoList.clear();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Asserts ID of spawned object is in fact Asteroid")
    void spawnAsteroid_check_ID() {

        spawner.spawnAsteroid();
        assert (objectList.get(0).getId() == ID.Asteroid);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Asserts that an object is added to the list")
    void spawnAsteroid_addsToList()
    {
        spawner.spawnAsteroid();
        assert(objectList.size() > 0);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Asserts that x position of asteroid is within valid range")
    void spawnAsteroid_valid_x_position()
    {
        spawner.spawnAsteroid();

        MovableHealthyObject testAsteroid = spawner.getObjectList().get(0);

        assert (testAsteroid.getxPosition() > dimensions.MIN_X_SPAWN && testAsteroid.getxPosition() < dimensions.MAX_X_SPAWN);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Asserts that y position of asteroid is within range")
    void spawnAsteroid_valid_y_position()
    {
        spawner.spawnAsteroid();

        MovableHealthyObject testAsteroid = spawner.getObjectList().get(0);

        assert (testAsteroid.getyPosition() > dimensions.MIN_SURVIVABLE_Y && testAsteroid.getyPosition() < dimensions.MAX_SURVIVABLE_Y);
    }
}