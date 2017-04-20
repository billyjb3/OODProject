package com.group.oodproject;

import android.graphics.Canvas;

public class baseShip implements MotherShip {

	private String name, img;
	private Projectile thisWeapon;
	private int health, level, hitBoxWidth, hitBoxHeight;

	public baseShip() {
		this.name = "Super Awesome Space Ship Alpha";
		this.hitBoxHeight = 100;
		this.hitBoxWidth = 100;
		this.level = 1;
		this.img = "PUT THE IMAGE LINK HERE"; //TODO Place the image link here for this ship
		this.thisWeapon = new Rocket();
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
	public String getImg() {
		return img;
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
	public void setImg(String img) {
		this.img = img;
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
		System.out.println(name + " is firing at cordinates X:"+ xCord + " Y:" +yCord);
		Rocket rocket = new Rocket();
		rocket.target(xCord, yCord);	}
}
