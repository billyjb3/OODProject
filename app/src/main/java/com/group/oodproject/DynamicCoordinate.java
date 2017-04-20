package com.group.oodproject;

/**
 * Created by User on 4/13/2017.
 */

public class DynamicCoordinate
{
    private double x;
    private double y;
    private DynamicCoordinate destination;
    private boolean done = false;
    private double speed;
    private double sx;
    private double sy;
    private double dx;
    private double dy;

    public DynamicCoordinate(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void update()
    {
        if(destination != null && !done)
        {
            if(Math.abs(dx) < Math.abs(sx) || Math.abs(dy) < Math.abs(sy))
            {
                if(dx != 0)
                    x = dx;
                if(dy != 0)
                    y = dy;
                done = true;
            }
            else
            {
                x += sx;
                y += sy;
                dx -= sx;
                dy -= sy;
            }
        }
    }
    public void setDestination(DynamicCoordinate destination, int speed)
    {
        this.speed = speed;
        this.destination = destination;
        dx = destination.getX() - x;
        dy = destination.getY() - y;
        double d = Math.sqrt(dx*dx + dy*dy);

        sx = speed * dx / d;
        sy = speed * dy / d;
    }
    public DynamicCoordinate getDestination()
    {
        return destination;
    }
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }
    public double getSpeed()
    {
        return speed;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public boolean isDone()
    {
        return done;
    }
}
