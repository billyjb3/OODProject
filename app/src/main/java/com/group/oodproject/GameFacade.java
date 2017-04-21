package com.group.oodproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by User on 4/2/2017.
 */

public class GameFacade
{
    //Game objects are all contained here
    private int shipChoice;
    protected ArrayList<Asteroid> asteroidList;
    protected ArrayList<Projectile> projectileList;
    protected MotherShip ship;
    protected int gameLevel, killCount;
    protected ScreenManager screenManager;
    protected Context context;
    protected DynamicCoordinate shipPos;
    public GameFacade(Context context, int shipChoice)
    {

        asteroidList = new ArrayList<>();
        projectileList = new ArrayList<>();
        this.context = context;
        screenManager = new ScreenManager(this.context);
        ship = new BaseShip(screenManager);
        gameLevel = 1;

        //Decorate players ship
        switch(shipChoice){
            case 1:
                BattleShipDecorator Battleship = new BattleShipDecorator(ship);

                break;
            case 2:
                CruiserDecorator Cruiser = new CruiserDecorator(ship);

                break;
            default:
                break;
        }

/*
        Random r = new Random();
        int low, high;
        double randomA, randomB;

            low = 10;
            high = 400;
            randomA = r.nextInt(high-low) + low;
            randomB = r.nextInt(high-low) + low;
            DynamicCoordinate dynamicStart = new DynamicCoordinate(randomA, 0);
            DynamicCoordinate dynamicEnd = new DynamicCoordinate(randomB, 2560);

            AsteroidDemo asteroid = new AsteroidDemo(dynamicStart,dynamicEnd,30);
            asteroidList.add(asteroid);
       */
    }

    public void update(Canvas canvas)
    {
        //call update methods of all game objects
        for (Asteroid astro:asteroidList
                ) {
            astro.update();
        }

        //check the asteroid list and add another asteroid if there are less asteroid than the game level
        Random r = new Random();
        int low, high;
        double randomA, randomB;
        if(asteroidList.size() < gameLevel){

            //generate an asteroid randomly positioned on the x-axis
            low = 20;
            if(canvas.getWidth() > 10) {
                high = canvas.getWidth();
            }
            else{
                high = 1000;
            }
            randomA = r.nextInt(high-low) + low;
            randomB = r.nextInt(high-low) + low;
            DynamicCoordinate dynamicStart = new DynamicCoordinate(randomA, 0);
            DynamicCoordinate dynamicEnd = new DynamicCoordinate(randomB, 2000);

            Asteroid asteroid = new Asteroid(dynamicStart,dynamicEnd,10);
            asteroid.setImage(screenManager.getImage(R.drawable.asteroid_a_100, 50, 50));
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

        /**
         * TESTING CODE HERE -- create an asteroid
         */
        ScreenManager screenManager1 = new ScreenManager(context);
        screenManager1.setCanvas(canvas);
        screenManager.setCanvas(canvas);
        Bitmap shipBitmap = screenManager1.getImage(R.drawable.spaceship14, 60, 60);
        DynamicCoordinate astroLocation, projectileLocation;
        shipPos = new DynamicCoordinate(350, (canvas.getHeight() - 350)); //TODO just using these coords for testing, need to base off of fullscreen canvas size
        screenManager.render(shipBitmap, shipPos);
        for (Asteroid astro:asteroidList
             ) {
            //astro.setImage(astroBitmap);
            astroLocation = astro.getLocation();
            screenManager.render(astro.getImage(), astroLocation );
        }
        for (Projectile projectile:projectileList
                ) {
            projectile.render(); //TODO do we want to pass ship a screen manager as well?
            //screenManager.render(projectile.getImg(),projectile.getLocation());
        }

    }
    public void touchEvent(MotionEvent event) //this may need to be altered.
    {
        if (event.getAction() == MotionEvent.ACTION_UP) { //only fire once per touch

            int low, high, resultx, resulty;
            Random random = new Random();
            //get the touch coordinates
            float target_x, target_y;
            target_x = event.getX();
            target_y = event.getY();

            //fire a projectile at them
            //Projectile weapon = ship.getWeapon();

            /*generate a set of "random" coordinates near teh touch event, prevents evey touch from being successful
            low = (int) target_x - 20;
            high = (int) target_x + 20;
            resultx = random.nextInt(high - low) + low;

            low = (int) target_y - 20;
            high = (int) target_y + 20;
            resulty = random.nextInt(high - low) + low;

            */

            Log.d(TAG, "touchEvent: " + target_x + "  " + target_y);

            //create dynamic coordinates
            DynamicCoordinate target = new DynamicCoordinate(target_x, target_y);

            //send one of those explosive things over there
            Projectile projectile = new BaseProjectile(screenManager);
            BigRocketDecorator brd = new BigRocketDecorator(projectile);
            projectile.setStartPos(shipPos);
            projectile.setSpeed(50);
            projectile.target(target);
            projectileList.add(projectile);

            //create a projectile and target the coordinates

            //if the targeted coordinates are inside of an asteroid damage it
            for (Asteroid astro : asteroidList
                    ) {
                if (astro.checkHitbox(target)) {
                    Log.d(TAG, "HIT HIT HIT HIT HIT HIT!!!!!!!!!");


                    //damage the asteroid
                    int health = astro.getHealth();
                    astro.setHealth(health - 20);
                    health = health - 40;
                    if (health < 1) {
                        asteroidList.remove(astro);
                        killCount++;
                    } else if (health < 20) {
                        astro.setImage(screenManager.getImage(R.drawable.asteroid_a_20, 50, 50));
                    } else if (health < 40) {
                        astro.setImage(screenManager.getImage(R.drawable.asteroid_a_40, 50, 50));
                    } else if (health < 60) {
                        astro.setImage(screenManager.getImage(R.drawable.asteroid_a_60, 50, 50));
                    } else if (health < 80) {
                        astro.setImage(screenManager.getImage(R.drawable.asteroid_a_80, 50, 50));
                    }

                }
            }

        }
    }

}
