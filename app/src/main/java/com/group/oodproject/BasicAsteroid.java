package com.group.oodproject;

import android.graphics.Canvas;
import android.media.Image;

//BasicAsteroid is a concrete asteroid class that extends from AbstractAsteroid.
public class BasicAsteroid extends Asteroid{

    private int level, health, x_position_start, x_position_end, current_y, current_x,hbox_width, hbox_height;
    private Image asteroidPic;

    //TODO: BasicAsteroid constructor should create an asteroid with constant attributes (no inputs)
    public BasicAsteroid(int level, int x_position_start, int x_position_end, int hbox_width, int hbox_height) {
        this.level = level;
        this.x_position_start = x_position_start;
        this.x_position_end = x_position_end;
        this.hbox_width = hbox_width;
        this.hbox_height = hbox_height;
    }


}
