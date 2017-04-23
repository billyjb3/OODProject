package com.group.oodproject;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.Random;

/**
 * Created by User on 4/2/2017.
 */

public class GameFacade
{
    //Game objects are all contained here
    private Context context;
    private ScreenManager screenManager;
    private Background background;

    private MotherShip ship;
    private AsteroidGroup asteroids;
    private ProjectileGroup projectiles;

    private int gameLevel, killCount, shipChoice;
    private Random r = new Random();
    private int screenWidth, screenHeight;


    public GameFacade(Context context, int shipChoice)
    {
        this.context = context;
        screenManager = new ScreenManager(context);
        background = new Background(screenManager);

        gameLevel = 2;
        this.shipChoice = shipChoice;
        asteroids = new AsteroidGroup(screenManager, gameLevel);

        ship = new BaseShip(screenManager);

        shipChoice = 1;
        if(shipChoice == 1)
        {
            ship = new BattleShipDecorator(ship);
        }
        else if(shipChoice == 2)
        {
            ship = new CruiserDecorator(ship);
        }

        DynamicCoordinate launchPoint = new DynamicCoordinate(ship.getLocation().getX() + ship.width/2, ship.getLocation().getY());
        projectiles = new ProjectileGroup(screenManager, launchPoint);
    }

    public void update()
    {
        background.update();
        asteroids.update();
        projectiles.update();
        ship.update();

        for(int i = 0; i < asteroids.getSize(); i++)
        {
            if(ship.getLocation().isHit(asteroids.getAsteroid(i).getLocation()))
            {
                asteroids.removeAsteroid(asteroids.getAsteroid(i));
                //reduce ship health
                if(i > 0)
                   i--;
            }
            for(int j = 0; j < projectiles.getSize(); j++)
            {
                if(projectiles.getProjectile(j).getLocation().isHit(asteroids.getAsteroid(i).getLocation()))
                {
                    projectiles.removeProjectile(projectiles.getProjectile(j));
                    asteroids.removeAsteroid(asteroids.getAsteroid(i));
                    if(i > 0)
                        i--;
                }
            }
        }
    }
    public void render(Canvas canvas)
    {
        screenManager.setCanvas(canvas); //this must remain the first method called. canvas changes every render.
        background.render();
        ship.render();
        asteroids.render();
        projectiles.render();
    }
    public void touchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_UP)
        { //only fire once per touch
            projectiles.createProjectile(shipChoice, new DynamicCoordinate(event.getX(), event.getY()));
        }
    }
}
