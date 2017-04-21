package com.group.oodproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Andrew on 4/4/17.
 */
public class CruiserDecorator extends ShipDecorator {
    public CruiserDecorator(MotherShip shipToBeDecorated) {
        super(shipToBeDecorated);

        //Battle ship is large (bigger hitbox) but has more health
        shipToBeDecorated.setHealth(shipToBeDecorated.getHealth()-10);
        shipToBeDecorated.setHitBoxHeight(shipToBeDecorated.getHitBoxWidth()-20);
        shipToBeDecorated.setHitBoxWidth(shipToBeDecorated.getHitBoxWidth()-20);
        shipToBeDecorated.setName("Super Quick Cruiser" );
        // To Add shipToBeDecorated.setImg( add id when mipmap gets merged with drew's branch) );
    }

    public String getName() {
        return shipToBeDecorated.getName();
    }

    public int getHealth() {
        return shipToBeDecorated.getHealth();
    }

    public Projectile getWeapon() {
        return shipToBeDecorated.getWeapon();
    }

    public int getLevel() {
        return shipToBeDecorated.getLevel();
    }

    public int getHitBoxWidth() {
        return shipToBeDecorated.getHitBoxWidth();
    }

    public int getHitBoxHeight() {
        return shipToBeDecorated.getHitBoxHeight();
    }

    public void setHealth(int health) {
        shipToBeDecorated.setHealth(health);
    }

    public void setLevel(int level) {
        shipToBeDecorated.setLevel(level);
    }

    public void setImg(Bitmap bitmap) {shipToBeDecorated.setImg(bitmap);}

    public void setImg(int id) {shipToBeDecorated.setImg(id);}

    public Bitmap getImg(){return shipToBeDecorated.getImg();}

    public void setHitBoxWidth(int width) {
        shipToBeDecorated.setHitBoxWidth(width);
    }

    public void setHitBoxHeight(int height) {
        shipToBeDecorated.setHitBoxHeight(height);
    }
    public void setName(String name){
        shipToBeDecorated.setName(name);
    }


    @Override
    public void fire(int xCord, int yCord) {

    }

    @Override
    public void damage(int damageAmount) {
        shipToBeDecorated.setHealth(shipToBeDecorated.getHealth() - damageAmount);
    }

    @Override
    public void destroy(){
        System.out.println("BOOOOOM! You are dead!");
    }

    @Override
    public void render(Canvas canvas) {

    }

}
