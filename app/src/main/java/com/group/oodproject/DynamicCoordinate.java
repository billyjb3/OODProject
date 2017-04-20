package com.group.oodproject;

/**
 * Created by User on 4/13/2017.
 */

public class DynamicCoordinate
{
    private float x;
    private float y;
    private DynamicCoordinate destination;
    private float speed;
    private double sx;
    private double sy;
    private double dx;
    private double dy;

    public DynamicCoordinate(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void update()
    {
        if(destination != null || sx != dx || sy != dy)
        {
            if(dx < sx || dy < sy)
            {
                x = (float) dx;
                y = (float) dy;
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
    public void setDestination(DynamicCoordinate destination)
    {
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
    public void setSpeed(float speed)
    {
        this.speed = speed;
    }
    public float getSpeed()
    {
        return speed;
    }
    public float getX()
    {
        return x;
    }
    public float getY()
    {
        return y;
    }
}
