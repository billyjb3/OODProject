package com.group.oodproject;

import android.graphics.Bitmap;

import static java.lang.Math.abs;

/**
 * Created by User on 4/19/2017.
 */

public class AsteroidDemo
{
    private DynamicCoordinate location;
    private Bitmap image;
    private double hitboxWidth = 100;
    private double hitboxHeight = 100;


    public AsteroidDemo(DynamicCoordinate start, DynamicCoordinate end, int speed)
    {
        this.location = start;
        start.setDestination(end, speed);
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
    }
    public Bitmap getImage()
    {
        return image;
    }

    public boolean checkHitbox(DynamicCoordinate projectile){
        if(abs(location.getX() - projectile.getX()) < hitboxWidth && abs(location.getY()-projectile.getY()) < hitboxHeight){
            return true;
        }
        else{
            return false;
        }
    }
}
