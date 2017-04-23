package com.group.oodproject;

import android.graphics.Bitmap;

public abstract class Projectile
{
    protected ScreenManager screenManager;
    protected Bitmap image;
    protected DynamicCoordinate location;
    protected DynamicCoordinate destination;
	protected double damage;
    protected double multiplier;
    protected int speed;
    protected int width, height;


    public Bitmap getImage()
    {
        return image;
    }
    public DynamicCoordinate getLocation()
    {
        return location;
    }
    public DynamicCoordinate getDestination()
    {
        return destination;
    }
    public double getDamage()
    {
        return damage;
    }
    public double getMultiplier()
    {
        return multiplier;
    }
    public int getSpeed()
    {
        return  speed;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
}
