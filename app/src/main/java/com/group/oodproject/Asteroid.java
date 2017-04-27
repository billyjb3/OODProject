package com.group.oodproject;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.Image;

import static java.lang.Math.abs;

//The abstract asteroid class.
public abstract class Asteroid {

    protected int level, health;
    protected DynamicCoordinate location, destination;
    protected Bitmap image;
    protected int width, height;
    protected float density;


    public abstract void update();

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
