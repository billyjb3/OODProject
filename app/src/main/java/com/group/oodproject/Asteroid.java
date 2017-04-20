package com.group.oodproject;

import android.graphics.Canvas;
import android.media.Image;

public class Asteroid {

    private int level, health, x_position_start, x_position_end, current_y, current_x,hbox_width, hbox_height;
    private Image asteroidPic;

    public Asteroid(int level, int x_position_start, int x_position_end, int hbox_width, int hbox_height) {
        this.level = level;
        this.x_position_start = x_position_start;
        this.x_position_end = x_position_end;
        this.hbox_width = hbox_width;
        this.hbox_height = hbox_height;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX_position_start() {
        return x_position_start;
    }

    public void setX_position_start(int x_position_start) {
        this.x_position_start = x_position_start;
    }

    public int getX_position_end() {
        return x_position_end;
    }

    public void setX_position_end(int x_position_end) {
        this.x_position_end = x_position_end;
    }

    public int getCurrent_y() {
        return current_y;
    }

    public void setCurrent_y(int current_y) {
        this.current_y = current_y;
    }

    public int getCurrent_x() {
        return current_x;
    }

    public void setCurrent_x(int current_x) {
        this.current_x = current_x;
    }

    public int getHbox_width() {
        return hbox_width;
    }

    public void setHbox_width(int hbox_width) {
        this.hbox_width = hbox_width;
    }

    public int getHbox_height() {
        return hbox_height;
    }

    public void setHbox_height(int hbox_height) {
        this.hbox_height = hbox_height;
    }

    public Image getAsteroidPic() {
        return asteroidPic;
    }

    public void setAsteroidPic(Image asteroidPic) {
        this.asteroidPic = asteroidPic;
    }

    public void render(Canvas canvas){};

    public void update(){
        //TODO check health condition and update img, if zero or less set img to 0%
    };
}
