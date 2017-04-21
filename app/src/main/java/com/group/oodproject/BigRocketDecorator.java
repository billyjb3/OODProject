package com.group.oodproject;

import android.graphics.Bitmap;

public class BigRocketDecorator extends ProjectileDecorator {
	protected Projectile decoratedProjectile;
	
	public BigRocketDecorator(Projectile decoratedProjectile){
		super(decoratedProjectile);
		decoratedProjectile.setMult(2);

	}

	@Override
	public void setStartPos(double x, double y){
		decoratedProjectile.setStartPos(x,y);
	}

	@Override
	public void setStartPos(DynamicCoordinate d){
		decoratedProjectile.setStartPos(d);
	}

	@Override
	public void target(double x_pos, double y_pos) {
		decoratedProjectile.target(x_pos,y_pos);
	}

	@Override
	public void target(DynamicCoordinate d) {
		decoratedProjectile.target(d);
	}

	@Override
	public void setSpeed(int x) {
		decoratedProjectile.setSpeed(x);
	}

	@Override
	public void render() {
		decoratedProjectile.render();
	}

	@Override
	public void update() {
		decoratedProjectile.update();
	}

	@Override
	public void setMult(double x) {
		decoratedProjectile.setMult(x);
	}

	@Override
	public void setImg(Bitmap bitmap){
		decoratedProjectile.setImg(bitmap);
	}

	@Override
	public void setImg(int id){
		decoratedProjectile.setImg(id);
	}

	@Override
	public Bitmap getImg(){
		return decoratedProjectile.getImg();
	}

	@Override
	public double getDamage() {
		return decoratedProjectile.getDamage();
	}

}
