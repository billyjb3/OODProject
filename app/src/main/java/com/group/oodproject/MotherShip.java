package com.group.oodproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class MotherShip
{
    protected String name;
    protected int health;
    protected Projectile weapon;
    protected int level;
    protected int width, height;

    protected ScreenManager screenManager;
    protected Bitmap image;
    protected DynamicCoordinate location;


    public void update()
    {

    }
    public void render()
    {
        screenManager.render(image, location);
    }
    public DynamicCoordinate getLocation()
    {
        return location;
    }
    public String getName()
    {
        return name;
    }
    public int getHealth()
    {
        return health;
    }
    public Projectile getWeapon()
    {
        return weapon;
    }
    public int getLevel()
    {
        return level;
    }
    public void damage(int damage)
    {
        health -= damage;
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
