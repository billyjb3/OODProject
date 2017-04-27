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
    private AsteroidFactory asteroidFactory;
    private int maxAsteroids;
    private int asteroidInterval = 25;
    private int intervalCount = 25;
    private int screenWidth, screenHeight;
    private int level = 1;
    private Random r;

    public AsteroidGroup(ScreenManager screenManager)
    {
        this.screenManager = screenManager;
        asteroidFactory = new AsteroidFactory();
        asteroids = new ArrayList<>();
        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        r = new Random();
        maxAsteroids = level;
        asteroidInterval = 120;
        intervalCount = asteroidInterval;
    }

    public void update(int level)
    {
        if(this.level != level)
        {
            this.level = level;
            maxAsteroids = level/2;
            if(asteroidInterval > 30)
                asteroidInterval = 120/(1 + (level/20));
            intervalCount = asteroidInterval;
            asteroidFactory.update(level);
        }
        if(asteroids.size() < maxAsteroids && intervalCount == asteroidInterval)
        {
            Asteroid a = asteroidFactory.CreateAsteroid(new DynamicCoordinate(r.nextInt(screenWidth) + 1, 0), new DynamicCoordinate(r.nextInt(screenWidth) + 1, screenHeight));
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
