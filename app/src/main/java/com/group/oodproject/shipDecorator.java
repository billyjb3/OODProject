package com.group.oodproject;

import android.graphics.Bitmap;

/**
 * Created by Andrew on 4/4/17.
 */
public abstract class ShipDecorator implements MotherShip{

    protected MotherShip shipToBeDecorated;
    private String name;
    private Projectile thisWeapon;
    private int health, level, hitBoxWidth, hitBoxHeight;
    private Bitmap img;


    public ShipDecorator(MotherShip shipToBeDecorated) {
        this.shipToBeDecorated = shipToBeDecorated;
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
        // Potentially do nothing here because it won't be used every
    }
    @Override
    public void setImg(Bitmap bitmap) {
        this.img = bitmap;
    }

    @Override
    public Bitmap getImg() {
        return img;
    }

    @Override
    public void setHitBoxWidth(int width) {
        this.hitBoxWidth = hitBoxWidth;
    }

    @Override
    public void setHitBoxHeight(int height) {
        this.hitBoxHeight = hitBoxHeight;
    }

    @Override
    public void setName(String name){
        shipToBeDecorated.setName(name);
    }

    @Override
    public void fire(int xCord, int yCord) {
        System.out.println(name + " is firing at cordinates X:"+ xCord + " Y:" +yCord);
        //TODO generate a new projectile and pass it the x and y cordinates
    }

}
