package com.group.oodproject;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 4/22/2017.
 */

public class AsteroidGroup
{
    private ArrayList<Asteroid> asteroids;
    private ScreenManager screenManager;
    private int maxAsteroids;
    private int asteroidInterval = 25;
    private int intervalCount = 25;
    private int screenWidth, screenHeight;
    private Random r;

    public AsteroidGroup(ScreenManager screenManager, int level)
    {
        this.screenManager = screenManager;
        asteroids = new ArrayList<>();
        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        r = new Random();
        maxAsteroids = level;
        asteroidInterval = 60/level;
        intervalCount = asteroidInterval;
    }

    public void update()
    {
        if(asteroids.size() < maxAsteroids && intervalCount == asteroidInterval)
        {
            Asteroid a = new Asteroid(new DynamicCoordinate(r.nextInt(screenWidth) + 1, 0), new DynamicCoordinate(r.nextInt(screenWidth) + 1, screenHeight), 10);
            a.setImage(screenManager.getImage(R.drawable.aestroid, 50, 50));
            asteroids.add(a);
            intervalCount = 0;
        }
        if(asteroids.size() != 0)
        {
            for(int i = 0; i < asteroids.size(); i++)
                asteroids.get(i).update();
            for(int i = 0; i < asteroids.size(); i++)
            {
                if(asteroids.get(i).getLocation().isDone())
                    asteroids.remove(asteroids.get(i));
            }
        }
        if(intervalCount < asteroidInterval)
            intervalCount++;
    }
    public void render()
    {
        for(int i = 0; i < asteroids.size(); i++)
            screenManager.render(asteroids.get(i).getImage(), asteroids.get(i).getLocation());
    }
    public int getSize()
    {
        return asteroids.size();
    }
    public Asteroid getAsteroid(int i)
    {
        return asteroids.get(i);
    }
    public void removeAsteroid(Asteroid asteroid)
    {
        asteroids.remove(asteroid);
    }
}
