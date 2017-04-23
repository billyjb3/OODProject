package com.group.oodproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.Image;

import static java.lang.Math.abs;

public class Asteroid {

    private int level, health;
    private DynamicCoordinate location;
    private Bitmap image;
    private int width, height;

    public Asteroid(DynamicCoordinate start, DynamicCoordinate end, int speed)
    {
        this.health = 100;
        this.location = start;
        start.setDestination(end, speed);
        this.location.setHitBox(50, 50);
    }

    public void update()
    {
        location.update();
    }

    public DynamicCoordinate getLocation()
    {
        return location;
    }
    public void setImage(Bitmap image)
    {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.location.setHitBox(width, height);
    }
    public Bitmap getImage()
    {
        return image;
    }
    public boolean isHit(DynamicCoordinate coordinate)
    {
        return location.isHit(location);
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
