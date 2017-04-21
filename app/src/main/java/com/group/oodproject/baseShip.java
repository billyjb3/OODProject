package com.group.oodproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class BaseShip implements MotherShip {

	private String name;
	private Projectile thisWeapon;
	private int health, level, hitBoxWidth, hitBoxHeight;
	private ScreenManager sm;
	private int bmH, bmW;
	private Bitmap img;

	public BaseShip(ScreenManager sm) {
		this.name = "Super Awesome Space Ship Alpha";
		this.hitBoxHeight = 100;
		this.hitBoxWidth = 100;

		this.bmH = 50;
		this.bmW = 50;

		this.level = 1;
		//this.thisWeapon = new
		this.health = 100;
	}

	//getters and setters


	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public Projectile getWeapon() {
		return thisWeapon;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public int getHitBoxWidth() {
		return hitBoxWidth;
	}

	@Override
	public int getHitBoxHeight() {
		return hitBoxHeight;
	}

	@Override
	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public void setImg(int id) {
		this.img = sm.getImage(id,bmH,bmW);
	}

	@Override
	public void setImg(Bitmap bitmap) {
		this.img = bitmap;
	}

	@Override
	public Bitmap getImg() {
		return this.img;
	}

	@Override
	public void setHitBoxWidth(int width) {
		this.hitBoxWidth = width;
	}

	@Override
	public void setHitBoxHeight(int height) {
		this.hitBoxHeight = height;
	}

	@Override
	public void setName(String name){
		this.name = name;
	}

	@Override
	public void damage(int damageAmount){
		this.health =- damageAmount;

		if(this.health < 0){
			this.destroy();
		}
	}
	@Override
	public void destroy(){
		System.out.println("BOOOOOM! You are dead!");
	}

	@Override
	public void render(Canvas canvas) {

	}


	@Override
	public void fire(int xCord, int yCord) {

	}
}
