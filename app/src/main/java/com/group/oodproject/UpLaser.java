package com.group.oodproject;

public class UpLaser extends ProjectileDecorator {
	protected Projectile decoratedProjectile;
	
	public UpLaser(Projectile decoratedProjectile){
		super(decoratedProjectile);
		decoratedProjectile.setMult(2);
	}

	@Override
	public void target(float x_pos, float y_pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Object canvas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void setImg(Object thing){
		//change the image to something else
	}

	@Override
	public double getDamage() {
		return 0;
	}

}
