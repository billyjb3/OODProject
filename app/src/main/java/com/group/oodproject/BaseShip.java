package com.group.oodproject;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class BaseShip extends MotherShip
{

    public BaseShip(ScreenManager screenManager)
    {
        this.screenManager = screenManager;
        this.name = "Super Awesome Space Ship Alpha";

        this.level = 1;
        this.health = 100;

        this.width = 50;
        this.height = 50;
    }
}
