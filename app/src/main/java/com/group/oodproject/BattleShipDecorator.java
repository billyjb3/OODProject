package com.group.oodproject;

import android.graphics.Canvas;

/**
 * Created by Andrew on 4/4/17.
 */
public class BattleShipDecorator extends shipDecorator{

    public BattleShipDecorator(MotherShip shipToBeDecorated) {
        super(shipToBeDecorated);

        //Battle ship is large (bigger hitbox) but has more health
        shipToBeDecorated.setHealth(shipToBeDecorated.getHealth()+30);
        shipToBeDecorated.setHitBoxHeight(shipToBeDecorated.getHitBoxWidth()+20);
        shipToBeDecorated.setHitBoxWidth(shipToBeDecorated.getHitBoxWidth()+20);
        shipToBeDecorated.setName("Super Bad Ass Battle Ship" );
        shipToBeDecorated.setImg("IMAGE LINK HERE"); //TODO img link for battle ship
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

    public String getImg() {
        return shipToBeDecorated.getImg();
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

    public void setImg(String img) {
        shipToBeDecorated.setImg(img);
    }

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
        System.out.println(shipToBeDecorated.getName()+ " is firing at cordinates X:"+ xCord + " Y:" +yCord);
        Rocket rocket = new Rocket();
        rocket.target(xCord, yCord);
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
