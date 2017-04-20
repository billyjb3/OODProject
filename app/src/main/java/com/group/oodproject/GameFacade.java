package com.group.oodproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Created by User on 4/4/2017.
 */

public class GameFacade
{
    //Game objects are all contained here
    private Context context;
    private Canvas canvas;
    private ScreenManager screenManager;
    private Bitmap shipTest;

    public GameFacade(Context context, Canvas canvas)
    {
        this.context = context;
        this.canvas = canvas;
        screenManager = new ScreenManager(context);
        screenManager.setCanvas(canvas);
        shipTest = screenManager.getImage(R.drawable.spaceship14, 50, 50);
    }

    public void update()
    {
        //call update methods of all game objects, this is responsible for moving objects and updating
        //anything else that needs to change as the game progresses
        //this gets called 60 times per second. so for example if an object needs to move 200pixels
        //every second than every time update is called move the object 200/60 pixels
    }
    public void render(Canvas canvas) //be aware that canvas coords are raw pixels. not dp units
    {
        screenManager.setCanvas(canvas); //this must remain the first method called. canvas changes every render.

        //screen manager will now handle all rendering. Game objects no longer need render method.
        screenManager.render(shipTest, canvas.getWidth()/2 - shipTest.getWidth()/2 , canvas.getHeight() - shipTest.getHeight());
    }
    public void touchEvent(MotionEvent event) //this may need to be altered.
    {
        //pass around the touch event to all game objects? so they can handle if within their hitbox

    }
}
