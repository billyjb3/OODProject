package com.group.oodproject;

import android.graphics.Bitmap;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class BigRocketDecorator extends ProjectileDecorator
{
    public BigRocketDecorator(Projectile projectile)
    {
        super(projectile);
    }

    @Override
    public void setImage()
    {
        this.image = screenManager.getImage(R.drawable.rocket2, 10, 50);
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.location.setHitBox(width, height);
    }

    @Override
    public void setSpeed()
    {
        this.speed = 20;
    }

    @Override
    public void setDamage()
    {
        this.damage = 5;
    }

    @Override
    public void setMultiplier()
    {
        this.multiplier = 1;
    }
}
