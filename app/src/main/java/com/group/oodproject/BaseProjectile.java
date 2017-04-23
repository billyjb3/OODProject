package com.group.oodproject;

import android.graphics.Bitmap;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class BaseProjectile extends Projectile
{
	public BaseProjectile(ScreenManager screenManager, DynamicCoordinate location, DynamicCoordinate destination)
	{
		this.screenManager = screenManager;
        this.location = location;
        this.destination = destination;
	}
}
