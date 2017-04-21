package com.group.oodproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


/**
 * Created by User on 3/28/2017.
 */

public class Game extends SurfaceView implements Runnable
{
    private GameFacade gameFacade;
    private Thread gameThread;
    private Canvas canvas;
    private Boolean running;
    private int shipChoice;

    private long UPS = 60;
    private float density;
    private SurfaceHolder holder;
    private Paint paint;

    private long displayFPS;
    private long displayUPS;

    private float testX;
    private float testY;
    private float dx;
    private float dy;

    public Game(Context context)
    {
        super(context);
        gameFacade = new GameFacade(context, shipChoice);

        canvas = new Canvas();
        running = false;
        holder = getHolder();
        paint = new Paint();
        density = getResources().getDisplayMetrics().density;

        testX = this.getX();
        testY = this.getY();
        dx = 5;
        dy = 5;

    }
    @Override
    public void run()
    {
        long nano = (long)1e9;
        long updateNano = nano / UPS;
        long start = System.nanoTime();
        long now;
        long delta;
        int updates = 0;
        int frames = 0;

        while(running) // game loop
        {
            now = System.nanoTime();
            delta = now - start;
            if (delta >= nano)
            {
                displayFPS = frames;
                displayUPS = updates;
                frames = 0;
                updates = 0;
                start = System.nanoTime();
            }
            render();
            frames++;
            if (delta >= updateNano * updates)
            {
                update();
                updates++;
            }
        }
    }
    private void update()
    {

        gameFacade.update(canvas); //this updates all game objects in facade class
    }
    private void render()
    {
        if(holder.getSurface().isValid())
        {
            canvas = holder.lockCanvas();

            canvas.drawColor(Color.BLACK);
            paint.setColor(Color.WHITE);
            paint.setTextSize(45);
            canvas.drawText("FPS: " + displayFPS + "  |  UPS: " + displayUPS, this.getX(), this.getY() + 25*density, paint);

            gameFacade.render(canvas); //renders all game objects in the facade class

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void start()
    {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void stop()
    {
        running = false;
        try {gameThread.join();}
        catch (Exception e){e.printStackTrace();}
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        gameFacade.touchEvent(event);



        int eventAction = event.getAction();

        float tempDX = 0;
        float tempDY = 0;
        float xPos, yPos;

        if(eventAction == MotionEvent.ACTION_DOWN)//location of initial touch
        {

        }
        else if(eventAction == MotionEvent.ACTION_UP)//location of release
        {

        }


        return true;
    }
}
