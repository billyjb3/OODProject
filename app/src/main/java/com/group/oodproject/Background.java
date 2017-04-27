package com.group.oodproject;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 4/13/2017.
 */

public class Background
{
    private ScreenManager screenManager;
    ArrayList<DynamicCoordinate> stars;
    private Paint paint;

    private int screenWidth;
    private int screenHeight;
    private int maxStars = 50;
    private int spawnInterval = 5;
    private int intervalCount = 5;

    private Random r;

    public Background(ScreenManager screenManager)
    {
        this.screenManager = screenManager;
        stars = new ArrayList<>(25);
        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        r = new Random();
        paint = new Paint();
        paint.setColor(Color.WHITE);
        for(int i = 0; i < 240; i++)
            update();
    }

    public void update()
    {
        if(intervalCount == spawnInterval)
        {
            DynamicCoordinate coord = new DynamicCoordinate(r.nextInt(screenWidth) + 1, 0);
            coord.setDestination(new DynamicCoordinate(coord.getX(), screenHeight), r.nextInt(6) + 5);
            stars.add(coord);
            intervalCount = 0;
        }
        for(int i = 0; i < stars.size(); i++)
        {
            stars.get(i).update();
            if(stars.get(i).isDone())
            {
                stars.remove(stars.get(i));
                i -= 1;
            }
        }
        intervalCount++;
    }
    public void render()
    {
        for(int i = 0; i < stars.size(); i++)
        {
            Canvas canvas = screenManager.getCanvas();
            DynamicCoordinate dc = stars.get(i);
            canvas.drawRect((float)dc.getX(), (float)dc.getY(), (float)dc.getX() + r.nextInt(4) + 1, (float)dc.getY() + r.nextInt(6) + 1, paint);
        }
    }

}
