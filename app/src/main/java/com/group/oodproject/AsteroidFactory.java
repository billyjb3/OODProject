package com.group.oodproject;

/**
 * Created by jsli3 on 4/19/2017.
 */

public class AsteroidFactory {
    //TODO: instead of the current inputs, createASteroid should only take in 1 string input called type.
    public static Asteroid CreateAsteroid(int level, int x_position_start, int x_position_end, int hbox_width, int hbox_height){
        return new BasicAsteroid(level, x_position_start, x_position_end, hbox_width, hbox_height);
    }

}
