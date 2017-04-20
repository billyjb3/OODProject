package com.group.oodproject;

public interface Projectile {
	double baseDamage=1;
	
	public void target(float x_pos, float y_pos);
	public void render(Object canvas);
	public void update();
	public void setMult(double x);
	public void setImg(Object thing);
	public double getDamage();
}
