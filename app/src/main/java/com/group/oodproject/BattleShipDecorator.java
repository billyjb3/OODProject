package com.group.oodproject;

import android.content.res.Resources;

/**
 * Created by Andrew on 4/4/17.
 */
public class BattleShipDecorator extends ShipDecorator
{
    public BattleShipDecorator(MotherShip ship)
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
        this.name = "Battle Ship";
    }

    @Override
    public void setHealth()
    {
        this.health = 1000;//change number as necessary;
    }

    @Override
    public void setWeapon()
    {
        //this.weapon = new BigRocketDecorator(new BaseProjectile(this.screenManager));
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
    @Override
    public void render()
    {
        screenManager.render(this.image, this.location);
    }
}
