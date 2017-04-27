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
            return new BasicAsteroid(start, end, 10);
        }
        else if (roll  >= 5) {
            return new AcceleratingAsteroid(start, end, 10);
        }
        else if (roll  >= 10) {
            return new ToughAsteroid(start, end, 10);
        }
        else
            return new BasicAsteroid(start, end, 10);
    }

    public void update(int level)
    {
        this.level = level;
    }
}
