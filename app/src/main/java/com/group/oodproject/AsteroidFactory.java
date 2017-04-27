package com.group.oodproject;

import java.util.Random;

/**
 * Created by User on 4/26/2017.
 */

//Randomly constructs different classes of asteroids; as the game gets harder, faster asteroids with harder behaviors appear.
public class AsteroidFactory
{
    //The game level
    private int level = 1;

    //The constructor method.
    public Asteroid CreateAsteroid(DynamicCoordinate start, DynamicCoordinate end)
    {
        Random r = new Random();

        //Depending on the level and a random roll, CreateAsteroid selects which subclass of asteroid to construct.
        int roll = r.nextInt()/10 + level;

        if (roll  < 5) {
            return new BasicAsteroid(start, end);
        }
        else if (roll  >= 5 && roll <= 9) {
            return new AcceleratingAsteroid(start, end);
        }
        else  {
            return new AcceleratingFastAsteroid(start, end);
        }
    }

    public void update(int level)
    {
        this.level = level;
    }
}
