package com.group.oodproject;

import android.graphics.Bitmap;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class BaseProjectile implements Projectile {

	double damage;
	double dammult=1.5;
	DynamicCoordinate dm;
	ScreenManager sm;
	int speed;
	Bitmap img;
	//Sound sound=something;
	int bmW,bmH;
	public BaseProjectile(ScreenManager sm){
		this.sm = sm;
		damage=Projectile.baseDamage*dammult;
		bmW = bmH = 50;
		speed = 40;

	}

	@Override
	public void setStartPos(double x, double y){
		dm = new DynamicCoordinate(x,y);
	}

	@Override
	public void setStartPos(DynamicCoordinate d){
		dm = d;
	}

	@Override
	public void target(double x_pos, double y_pos) {
		dm.setDestination(new DynamicCoordinate(x_pos,y_pos), speed);
	}

	@Override
	public void target(DynamicCoordinate d) {
		dm.setDestination(d, speed);
	}

	@Override
	public void setSpeed(int x) {
		this.speed = x;
		dm.setSpeed(this.speed);
	}

	@Override
	public void render() {
		sm.render(img,dm);
		update();
		Log.d(TAG, "RENDER PROJECTILE");
	}

	@Override
	public void update() {
		dm.update();
	}

	@Override
	public void setMult(double x) {
		dammult=dammult*x;
	}
	
	@Override
	public void setImg(Bitmap bitmap){
		img = bitmap;
	}

	@Override
	public void setImg(int id){
		img = sm.getImage(id, bmW,bmH);
	}

	@Override
	public Bitmap getImg(){
		return this.img;
	}

	@Override
	public double getDamage() {
		return 0;
	}

}
