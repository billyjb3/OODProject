package com.group.oodproject;

import android.content.res.Resources;
import android.graphics.Bitmap;

public class SmallRocketDecorator extends ProjectileDecorator
{
	protected Projectile projectile;
	
	public SmallRocketDecorator(Projectile projectile)
	{
		super(projectile);

	}

	@Override
	public void setImage()
	{
		this.image = screenManager.getImage(R.drawable.rocket2, 10, 50);
		this.width = image.getScaledWidth(Resources.getSystem().getDisplayMetrics());
		this.height = image.getScaledHeight(Resources.getSystem().getDisplayMetrics());
		this.location.setHitBox(width, height);
	}

	@Override
	public void setSpeed()
	{
		this.speed = 30;
	}

	@Override
	public void setDamage()
	{
		this.damage = 7;
	}

	@Override
	public void setMultiplier()
	{
		this.multiplier = 1;

	}

}

