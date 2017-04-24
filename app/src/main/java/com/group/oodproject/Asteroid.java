package com.group.oodproject;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.Image;

import static java.lang.Math.abs;

public class Asteroid {

    private int level, health;
    private DynamicCoordinate location;
    private Bitmap image;
    private int width, height;
    private float density;

    public Asteroid(DynamicCoordinate start, DynamicCoordinate end, int speed)
    {
        this.health = 100;
        this.location = start;
        start.setDestination(end, speed);
        density = Resources.getSystem().getDisplayMetrics().density;
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
        this.width = image.getScaledWidth(Resources.getSystem().getDisplayMetrics());
        this.height = image.getScaledHeight(Resources.getSystem().getDisplayMetrics());
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
