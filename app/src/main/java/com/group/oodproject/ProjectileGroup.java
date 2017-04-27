package com.group.oodproject;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by User on 4/22/2017.
 */

public class ProjectileGroup
{
    private ScreenManager screenManager;
    private DynamicCoordinate launchPoint;
    private ArrayList<Projectile> projectiles;

    public ProjectileGroup(ScreenManager screenManager, DynamicCoordinate launchPoint)
    {
        this.screenManager = screenManager;
        this.launchPoint = launchPoint;
        projectiles = new ArrayList<>();
    }

    public void update()
    {
        if(!projectiles.isEmpty())
        {
            for (int i = 0; i < projectiles.size(); i++)
                projectiles.get(i).getLocation().update();
            for (int i = 0; i < projectiles.size(); i++)
            {
                if (projectiles.get(i).getLocation().isDone())
                {
                    projectiles.remove(i);
                }
            }
        }
    }
    public void render()
    {
        for(int i = 0; i < projectiles.size(); i++)
            screenManager.render(projectiles.get(i).getImage(), projectiles.get(i).getLocation());
    }
    public void createProjectile(int shipNumber, DynamicCoordinate destination)
    {
        Projectile projectile = new BaseProjectile(screenManager, new DynamicCoordinate(launchPoint.getX(), launchPoint.getY()), destination);
        if(shipNumber == EngineContainer.BATTLESHIP)
            projectile = new BigRocketDecorator(projectile);
        else if(shipNumber == EngineContainer.CRUISER)
            projectile = new SmallRocketDecorator(projectile);
        projectiles.add(projectile);
    }
    public void removeProjectile(Projectile projectile)
    {
        projectiles.remove(projectile);
    }
    public int getSize()
    {
        return projectiles.size();
    }
    public Projectile getProjectile(int i)
    {
        return projectiles.get(i);
    }
}
