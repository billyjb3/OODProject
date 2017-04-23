package com.group.oodproject;

import android.graphics.Bitmap;

/**
 * Created by Andrew on 4/4/17.
 */
public abstract class ShipDecorator extends MotherShip
{
    protected MotherShip ship;

    public ShipDecorator(MotherShip ship)
    {
        this.ship = ship;
        this.screenManager = ship.screenManager;
        //this.location = ship.location;
    }

    public abstract void setSize();
    public abstract void setName();
    public abstract void setHealth();
    public abstract void setWeapon();
    public abstract void setLevel();
    public abstract void setImage();
}
