package com.group.oodproject;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

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
    private TextView pickShipText;
    private LinearLayout gameOverButtonLayout;
    private ImageButton cruiserButton;
    private ImageButton battleshipButton;

    private boolean started = false;
    private boolean gameCreated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);

        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;

        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }

        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);

        container = new EngineContainer(this);
        //game = new Game(this, container);
        makeMenuViews();
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == newButton.getId())
        {

            if (gameCreated == false)
            {
                setPickView();
            }
            else
            {
                gameLayout.removeView(game);
                game = new Game(this, container);
                setPickView();
            }
        }
        else if(v.getId() == battleshipButton.getId())
        {
            container.setShipChoice(EngineContainer.BATTLESHIP);
            game = new Game(this, container);
            setGameViews();
            started = true;
            gameCreated = true;
            game.start();
        }
        else if(v.getId() == cruiserButton.getId())
        {
            container.setShipChoice(EngineContainer.CRUISER);
            game = new Game(this, container);
            setGameViews();
            started = true;
            gameCreated = true;
            game.start();
        }
        else if (v.getId() == continueButton.getId())
        {
            setContentView(gameLayout);
            started = true;
            game.start();
        }
        else if (v.getId() == menuButton.getId())
        {
            game.stop();
            started = false;
            setContentView(menuLayout);
            setContinueView();
        }
        else if(v.getId() == restartButton.getId())
        {
            gameLayout.removeView(game);
            game = new Game(this, container);
            setGameViews();
            game.start();
            started = true;
        }
        else if(v.getId() == mainMenuButton.getId())
        {
            setContentView(menuLayout);
            continueButton.setVisibility(View.INVISIBLE);
            continueButton.setActivated(false);
        }
    }

    public void setIntitialView()
    {
        newButton.setActivated(true);
        newButton.setVisibility(View.VISIBLE);
        continueButton.setActivated(false);
        continueButton.setVisibility(View.INVISIBLE);
        cruiserButton.setActivated(false);
        cruiserButton.setVisibility(View.INVISIBLE);
        battleshipButton.setActivated(false);
        battleshipButton.setVisibility(View.INVISIBLE);
        pickShipText.setVisibility(View.INVISIBLE);
    }
    public void setPickView()
    {
        newButton.setActivated(false);
        newButton.setVisibility(View.INVISIBLE);
        continueButton.setActivated(false);
        continueButton.setVisibility(View.INVISIBLE);
        cruiserButton.setActivated(true);
        cruiserButton.setVisibility(View.VISIBLE);
        battleshipButton.setActivated(true);
        battleshipButton.setVisibility(View.VISIBLE);
        pickShipText.setVisibility(View.VISIBLE);
    }
    public void setContinueView()
    {
        newButton.setActivated(true);
        newButton.setVisibility(View.VISIBLE);
        continueButton.setActivated(true);
        continueButton.setVisibility(View.VISIBLE);
        cruiserButton.setActivated(false);
        cruiserButton.setVisibility(View.INVISIBLE);
        battleshipButton.setActivated(false);
        battleshipButton.setVisibility(View.INVISIBLE);
        pickShipText.setVisibility(View.INVISIBLE);
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
    public void setGameViews()
    {
        setContentView(R.layout.game_screen);
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
    private void makeMenuViews()
    {
        menuLayout = (RelativeLayout) findViewById(R.id.menuLayout);

        newButton = (Button) findViewById(R.id.newButton);
        newButton.setOnClickListener(this);
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this);
        cruiserButton = (ImageButton) findViewById(R.id.cruiserIB);
        cruiserButton.setOnClickListener(this);
        battleshipButton = (ImageButton) findViewById(R.id.battleIB);
        battleshipButton.setOnClickListener(this);

        cruiserButton.setVisibility(View.INVISIBLE);
        cruiserButton.setActivated(false);
        battleshipButton.setVisibility(View.INVISIBLE);
        battleshipButton.setActivated(false);

        pickShipText = (TextView) findViewById(R.id.pickText);
        pickShipText.setVisibility(View.INVISIBLE);
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
