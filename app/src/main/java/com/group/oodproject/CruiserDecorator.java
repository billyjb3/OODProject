package com.group.oodproject;

import android.content.res.Resources;

/**
 * Created by Andrew on 4/4/17.
 */
public class CruiserDecorator extends ShipDecorator
{

    public CruiserDecorator(MotherShip ship)
    {
        super(ship);
        setSize();
        setName();
        setHealth();
        setWeapon();
        setLevel();
    }

    @Override
    public void setSize()
    {
        this.width = 50;
        this.height = 50;
        setImage();
        this.width = image.getScaledWidth(Resources.getSystem().getDisplayMetrics());
        this.height = image.getScaledHeight(Resources.getSystem().getDisplayMetrics());
        this.location = new DynamicCoordinate(Resources.getSystem().getDisplayMetrics().widthPixels/2 - width/2, Resources.getSystem().getDisplayMetrics().heightPixels - height);
        this.location.setHitBox(width, height);
    }

    @Override
    public void setName()
    {
        //not needed. delete
    }

    @Override
    public void setHealth()
    {
        this.health = 300;
    }

    @Override
    public void setWeapon()
    {
        //not needed. delete
    }

    @Override
    public void setLevel()
    {
        this.level = 1;
    }

    @Override
    public void setImage()
    {
        this.image = screenManager.getImage(R.drawable.spaceship14, this.width, this.height);
    }

}
