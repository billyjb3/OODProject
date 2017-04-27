package com.group.oodproject;

import java.util.Random;

/**
 * Created by User on 4/26/2017.
 */

public class AsteroidFactory
{
    private int level = 1;

    public Asteroid CreateAsteroid(DynamicCoordinate start, DynamicCoordinate end)
    {
        Random r = new Random();

        int roll = r.nextInt()/10 + level;

        if (roll  < 5) {
            return new BasicAsteroid(start, end);
        }
        else if (roll  >= 5 && roll <= 9) {
            return new FastAsteroid(start, end);
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
