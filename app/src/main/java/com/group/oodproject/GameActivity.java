package com.group.oodproject;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class GameActivity extends AppCompatActivity implements View.OnClickListener
{
    private RelativeLayout gameLayout;
    private RelativeLayout menuLayout;
    private Button newButton;
    private Button continueButton;
    private Button menuButton;
    private Game game;
    private int shipNumber = 0;

    private boolean started = false;
    private boolean gameCreated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);
        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }
        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);



        menuLayout = (RelativeLayout) findViewById(R.id.menuLayout);

        newButton = (Button) findViewById(R.id.newButton);
        newButton.setOnClickListener(this);
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this);

        game = new Game(this, shipNumber);
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == newButton.getId())
        {

            if (gameCreated == false)
            {
                setContentView(R.layout.game_screen);
                menuButton = (Button) findViewById(R.id.menuButton);
                gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);
                gameLayout.addView(game);
                menuButton.setOnClickListener(this);
                started = true;
                gameCreated = true;
                game.start();
            } else
            {
                gameLayout.removeView(game);
                game = new Game(this, shipNumber);
                gameLayout.addView(game);
                setContentView(gameLayout, gameLayout.getLayoutParams());
                started = true;
                game.start();
            }
        }
        if (v.getId() == continueButton.getId())
        {
            setContentView(gameLayout);
            started = true;
            game.start();
        }
        if (v.getId() == menuButton.getId())
        {
            game.stop();
            started = false;
            setContentView(menuLayout);

            continueButton.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
        if (started)
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
        if (started)
        {
            game.start();
        }
    }

    public void onStop()
    {
        super.onStop();
        if (started)
        {
            game.stop();
        }
    }
}
