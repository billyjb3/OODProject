package com.group.oodproject;

/**
 * Created by User on 4/26/2017.
 */

public class EngineContainer
{
    GameActivity gameActivity;
    Game game;
    GameFacade gameFacade;

    private int shipChoice;
    private int weaponChoice; //ship contains preset weapon or players choice?

    public EngineContainer(GameActivity gameActivity)
    {
        this.gameActivity = gameActivity;
    }
    public void setGame(Game game)
    {
        this.game = game;
    }
    public void setGameFacade(GameFacade gameFacade)
    {
        this.gameFacade = gameFacade;
    }

    public GameActivity getGameActivity()
    {
        return gameActivity;
    }
    public Game getGame()
    {
        return game;
    }
    public GameFacade getGameFacade()
    {
        return gameFacade;
    }
    public void setShipChoice(int choice)
    {
        this.shipChoice = choice;
    }
    public int getShipChoice()
    {
        return shipChoice;
    }
}
