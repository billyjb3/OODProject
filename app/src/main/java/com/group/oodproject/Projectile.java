package com.group.oodproject;

import android.graphics.Bitmap;

public interface Projectile {
	double baseDamage=1;

	public void setStartPos(double x, double y);
	public void setStartPos(DynamicCoordinate d);
	public void target(double x_pos, double y_pos);
	public void target(DynamicCoordinate d);
	public void render();
	public void update();
	public void setMult(double x);
	public void setSpeed(int x);
	public void setImg(int id);
	public void setImg(Bitmap bitmap);
	public Bitmap getImg();
	public double getDamage();
}
