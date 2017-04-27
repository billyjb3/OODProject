package com.group.oodproject;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class GameActivity extends AppCompatActivity implements View.OnClickListener
{
    private EngineContainer container;
    private Game game;

    private RelativeLayout gameLayout;
    private RelativeLayout menuLayout;
    private Button newButton;
    private Button continueButton;
    private Button menuButton;
    private Button restartButton;
    private Button mainMenuButton;
    private TextView score;
    private TextView health;
    private TextView gameOverMessage;
    private LinearLayout gameOverButtonLayout;
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
            //newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }
        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);

        container = new EngineContainer(this);

        menuLayout = (RelativeLayout) findViewById(R.id.menuLayout);

        newButton = (Button) findViewById(R.id.newButton);
        newButton.setOnClickListener(this);
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this);

        game = new Game(this, container);
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == newButton.getId())
        {

            if (gameCreated == false)
            {
                setContentView(R.layout.game_screen);
                initGameViews();
                started = true;
                gameCreated = true;
                game.start();
            } else
            {
                setContentView(gameLayout);
                gameLayout.removeView(game);
                game = new Game(this, container);
                initGameViews();
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
        if(v.getId() == restartButton.getId())
        {
            gameLayout.removeView(game);
            game = new Game(this, container);
            initGameViews();
            game.start();
            started = true;
        }
        if(v.getId() == mainMenuButton.getId())
        {
            setContentView(menuLayout);
            continueButton.setVisibility(View.INVISIBLE);
            continueButton.setActivated(false);
        }
    }

    public void gameOver()
    {
        game.stop();
        started = false;

        restartButton.setActivated(true);
        restartButton.setVisibility(View.VISIBLE);

        mainMenuButton.setActivated(true);
        mainMenuButton.setVisibility(View.VISIBLE);

        gameOverMessage.setVisibility(View.VISIBLE);

        menuButton.setActivated(false);
    }
    public void initGameViews()
    {
        gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);
        gameLayout.addView(game);

        menuButton = (Button) findViewById(R.id.menuButton);
        menuButton.bringToFront();
        menuButton.setOnClickListener(this);

        score = (TextView) findViewById(R.id.scoreTextView);
        score.bringToFront();

        health = (TextView) findViewById(R.id.healthTextView);
        health.bringToFront();

        gameOverButtonLayout = (LinearLayout) findViewById(R.id.gameOverButtonLayout);
        gameOverButtonLayout.bringToFront();

        mainMenuButton = (Button) findViewById(R.id.mainMenuButton);
        mainMenuButton.setOnClickListener(this);
        mainMenuButton.setVisibility(View.INVISIBLE);
        mainMenuButton.setActivated(false);

        restartButton = (Button) findViewById(R.id.restartButton);
        restartButton.setOnClickListener(this);
        restartButton.setVisibility(View.INVISIBLE);
        restartButton.setActivated(false);

        gameOverMessage = (TextView) findViewById(R.id.gameOverText);
        gameOverMessage.bringToFront();
        gameOverMessage.setVisibility(View.INVISIBLE);
    }
    public void setScore(int score)
    {
        String st = "Score: " + score;
        this.score.setText(st);
    }
    public void setHealth(int health)
    {
        String ht = "Health: " + health;
        this.health.setText(ht);
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
