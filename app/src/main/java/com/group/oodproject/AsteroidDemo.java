package com.group.oodproject;

import android.graphics.Bitmap;

/**
 * Created by User on 4/19/2017.
 */

public class AsteroidDemo
{
    private DynamicCoordinate location;
    private Bitmap image;

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
}
