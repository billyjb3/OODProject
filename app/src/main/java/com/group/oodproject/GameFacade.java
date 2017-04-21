package com.group.oodproject;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * Created by User on 4/2/2017.
 */

public class GameFacade
{
    //Game objects are all contained here
    private int shipChoice;
    protected ArrayList<Asteroid> asteroidList;
    protected MotherShip ship;
    protected int gameLevel, killCount;

    public GameFacade(Context context, int shipChoice) {

        ship = new baseShip();
        ScreenManager sm = new ScreenManager(context);

        //Decorate players ship
        switch(shipChoice){
            case 1:
                BattleShipDecorator Battleship = new BattleShipDecorator(ship);
                //TODO set name for the resource folder to hold images
                //sm.getImage()
                break;
            case 2:
                CruiserDecorator Cruiser = new CruiserDecorator(ship);
                //ship = Cruiser;
                break;
            default:
                break;
        }

        //add an asteroid to the array
        Asteroid asteroid = new Asteroid(1,300,200,100,100);
        asteroidList.add(asteroid);

    }

    public void update()
    {
        //call update methods of all game objects

        //check the astroid list and add another asteroid if there are less asteroid than the game level
        if(asteroidList.size() < gameLevel){
            //randomize the asteroid start x and y
            //TODO asteroid start and y rand
            Asteroid asteroid = new Asteroid(1,300,200,100,100);
            asteroidList.add(asteroid);
        }

        //level up at 10 asteroid kills
        if(killCount > 10){
            gameLevel++;
            killCount = 0;
        }

    }
    public void render(Canvas canvas) //be aware that canvas coords are raw pixels. not dp units
    {
        ship.render(canvas);
        for (Asteroid astro:asteroidList
             ) {
            astro.render(canvas);
        }

    }
    public void touchEvent(MotionEvent event) //this may need to be altered.
    {
        //get the touch coordinates
        float target_x, target_y;
        target_x = event.getX();
        target_y = event.getY();

        //fire a projectile at them
        Projectile weapon = ship.getWeapon();
        //TODO add a target coordinates random modifier here to give chance of a hit
        weapon.target(target_x, target_y);

        //if the targeted coordinates are inside of an asteroid damage it
        for (Asteroid astro:asteroidList
                ) {
                    //check if the touch event is inside any of the hit boxes for any asteroid
                    if(target_x == astro.getCurrent_x() && target_y == astro.getCurrent_y()){
                        astro.setHealth(astro.getHealth() - (int)weapon.getDamage());
                    }
        }
    }

}
