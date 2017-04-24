package com.group.oodproject;

/**
 * Created by User on 4/22/2017.
 */

public class HitBox
{
    private DynamicCoordinate corner1;
    private DynamicCoordinate corner2;

    public HitBox(DynamicCoordinate corner1, int width, int height)
    {
        this.corner1 = corner1;
        corner2 = new DynamicCoordinate(corner1.getX() + width - 1, corner1.getY() + height - 1);
    }
    public HitBox(DynamicCoordinate corner1, DynamicCoordinate corner2)
    {
        this.corner1 = corner1;
        this.corner2 = corner2;
    }

    public boolean isHit(HitBox box)
    {
        DynamicCoordinate c1 = box.getCorner1();
        DynamicCoordinate c2 = box.getCorner2();
        if((c1.getX() <= corner2.getX() && c1.getX() >= corner1.getX()) | (c2.getX() <= corner2.getX() && c2.getX() >= corner1.getX()) |
                (corner1.getX() <= c2.getX() && corner1.getX() >= c1.getX()))
        {
            if((c1.getY() <= corner2.getY() && c1.getY() >= corner1.getY()) | (c2.getY() <= corner2.getY() && c2.getY() >= corner1.getY()) |
                    (corner1.getY() <= c2.getY() && corner1.getY() >= c1.getY()))
                return true;
        }
        return false;
    }
    public DynamicCoordinate getCorner1()
    {
        return corner1;
    }
    public DynamicCoordinate getCorner2()
    {
        return corner2;
    }
}
