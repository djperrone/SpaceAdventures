package SpaceAdventures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SpawnerTest {
    public static final int WIDTH = 1280, HEIGHT = WIDTH/12 *9;

    Dimensions dimensions;

    LinkedList<MovableHealthyObject> objectList;

    private Spawner spawner;
    @BeforeEach
    void initSpawner()
    {
        dimensions = new Dimensions(WIDTH,HEIGHT);
        objectList = new LinkedList<>();
        //spawner = new Spawner(objectList,dimensions );

    }



    @org.junit.jupiter.api.Test
    void spawnPlayer() {
    }

    @org.junit.jupiter.api.Test
    void spawnUFO() {
    }

    @org.junit.jupiter.api.Test
    void spawnAsteroid() {

        spawner.spawnAsteroid();
        //assert list not empty
        // assert object type
        // assert x, y valid
        objectList.get(0);
    }

    void spawnAsteroid_addsToList()
    {
        //assert list not empty, type
    }

    void spawnAsteroid_valid_x_position()
    {

    }
    void spawnAsteroid_valid_y_position()
    {

    }



    @Test
    @DisplayName("Asteroid x position range test")
    void testAsteroidXposition()
    {
        Asteroid testAsteroid = new Asteroid(1200, 9);
        assert (testAsteroid.xPosition < 1280 && testAsteroid.xPosition > 128);
    }
    @Test
    @DisplayName("Asteroid y position range test")
    void testAsteroidYposition()
    {
        Asteroid testAsteroid = new Asteroid(500, 11);
        assert (testAsteroid.yPosition >=10 && testAsteroid.yPosition < 100);
    }

    @Test
    @DisplayName("UFO x position range test")
    void testUFOxPosition()
    {
        UFO ufo = new UFO(1250, 9);
        assert (ufo.xPosition < 1280 && ufo.xPosition > 128);
    }
    @Test
    @DisplayName("UFO y position range test")
    void testUFOyPosition()
    {
        UFO ufo = new UFO(500, 10);
        assert (ufo.yPosition == 10);
    }


    @Test
    @DisplayName("Player x position range test")
    void testPlayerXPosition()
    {
        Player player = new Player(1200, 9);
        assert (player.xPosition < 1280 && player.xPosition > 0);
    }
    @Test
    @DisplayName("Player y position range test")
    void testPlayeryPosition()
    {
        Player player = new Player(500, 500);
        assert (player.yPosition > 250 && player.yPosition < 750);
    }



    @org.junit.jupiter.api.Test
    void cleanAsteroids() {
    }

    @org.junit.jupiter.api.Test
    void cleanProjectiles() {
    }
}