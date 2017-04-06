package com.group.oodproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class GameActivity extends AppCompatActivity implements View.OnClickListener
{
    private RelativeLayout gameLayout;
    private RelativeLayout menuLayout;
    private Button newButton;
    private Button continueButton;
    private Button menuButton;
    private Game game;

    private boolean started = false;
    private boolean gameCreated = false;

    private float density;
    private float spw;
    private float sdpw;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);

        menuLayout = (RelativeLayout) findViewById(R.id.menuLayout);

        newButton = (Button) findViewById(R.id.newButton);
        newButton.setOnClickListener(this);
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this);

        density = this.getResources().getDisplayMetrics().density;
        spw = this.getResources().getDisplayMetrics().widthPixels;
        sdpw = spw / density;

        game = new Game(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == newButton.getId())
        {

            if(gameCreated == false)
            {
                setContentView(R.layout.game_screen);
                menuButton = (Button) findViewById(R.id.menuButton);
                gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);
                gameLayout.addView(game);
                menuButton.setOnClickListener(this);
                started = true;
                gameCreated = true;
                game.start();
            }
            else
            {
                gameLayout.removeView(game);
                game = new Game(this);
                gameLayout.addView(game);
                setContentView(gameLayout, gameLayout.getLayoutParams());
                started = true;
                game.start();
            }
        }
        if(v.getId() == continueButton.getId())
        {
            setContentView(gameLayout);
            started = true;
            game.start();
        }
        if(v.getId() == menuButton.getId())
        {
            game.stop();
            started = false;
            setContentView(menuLayout);

            continueButton.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        if(started)
        {
            game.stop();
        }
    }
    @Override
    public void onStart()
    {
        super.onStart();
    }

    public void onResume()
    {
        super.onResume();
        if(started)
        {
            game.start();
        }
    }
    public void onStop()
    {
        super.onStop();
        if(started)
        {
            game.stop();
        }
    }
}
