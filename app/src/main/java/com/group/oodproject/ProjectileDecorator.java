package com.group.oodproject;

public abstract class ProjectileDecorator extends Projectile
{
	protected Projectile projectile;
	
	public ProjectileDecorator(Projectile projectile)
	{
		this.projectile = projectile;
        this.screenManager = projectile.screenManager;
        this.location = projectile.location;
        this.destination = projectile.destination;
        setImage();
        setSpeed();
        setDamage();
        setMultiplier();

        location.setDestination(destination, speed);
	}

    public abstract void setImage();
    public abstract void setSpeed();
    public abstract void setDamage();
    public abstract void setMultiplier();
}
