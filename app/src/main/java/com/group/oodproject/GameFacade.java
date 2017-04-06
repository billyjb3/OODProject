package com.group.oodproject;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by User on 4/4/2017.
 */

public class GameFacade
{
    //Game objects are all contained here

    public GameFacade()
    {

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
        //call render methods of all game objects and pass the canvas around

    }
    public void touchEvent(MotionEvent event) //this may need to be altered.
    {
        //pass around the touch event to all game objects? so they can handle if within their hitbox

    }
}
