package com.group.oodproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.MotionEvent;

import java.util.Random;

/**
 * Created by User on 4/2/2017.
 */

public class GameFacade
{
    //Game objects are all contained here
    private Handler handler;
    private EngineContainer container;
    private ScreenManager screenManager;
    private Background background;

    private MotherShip ship;
    private AsteroidGroup asteroids;
    private ProjectileGroup projectiles;

    private int gameLevel, score, shipChoice;
    private Random r = new Random();

    public GameFacade(EngineContainer container)
    {
        this.container = container;
        container.setGameFacade(this);
        screenManager = new ScreenManager(container.getGameActivity());
        background = new Background(screenManager);

        handler = new Handler();
        gameLevel = 1;
        asteroids = new AsteroidGroup(screenManager);

        ship = new BaseShip(screenManager);

        shipChoice = 1; //get rid of this once game menues are added
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
        if(ship.getHealth() <= 0)
        {
            handler.post(new Runnable()
            {
                public void run()
                {
                    container.getGameActivity().gameOver();
                }
            });
        }
        else
        {
            handler.post(new Runnable()
            {
                public void run()
                {
                    container.getGameActivity().setHealth(ship.getHealth());
                    container.getGameActivity().setScore(score);
                }
            });

            background.update();
            projectiles.update();
            for(int i = 0; i < asteroids.getSize(); i++)
            {
                for(int j = 0; j < projectiles.getSize(); j++)
                {
                    if(asteroids.getSize() != 0 && projectiles.getProjectile(j).getLocation().isHit(asteroids.getAsteroid(i).getLocation()))
                    {
                        projectiles.removeProjectile(projectiles.getProjectile(j));
                        asteroids.removeAsteroid(asteroids.getAsteroid(i));
                        score += 10 + gameLevel;
                        gameLevel = score/100 + 1;
                        if(i > 0)
                            i--;
                    }
                }
            }
            asteroids.update(gameLevel);
            for(int i = 0; i < asteroids.getSize(); i++)
            {
                if(ship.getLocation().isHit(asteroids.getAsteroid(i).getLocation()))
                {
                    asteroids.removeAsteroid(asteroids.getAsteroid(i));
                    ship.damage(50);
                    if(i > 0)
                        i--;
                }
                for(int j = 0; j < projectiles.getSize(); j++)
                {
                    if(asteroids.getSize() != 0 && projectiles.getProjectile(j).getLocation().isHit(asteroids.getAsteroid(i).getLocation()))
                    {
                        projectiles.removeProjectile(projectiles.getProjectile(j));
                        asteroids.removeAsteroid(asteroids.getAsteroid(i));
                        score += 10 + gameLevel;
                        gameLevel = score/100 + 1;
                        if(i > 0)
                            i--;
                    }
                }
            }
            ship.update();
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
