package com.group.oodproject;

import android.content.res.Resources;

/**
 * Created by User on 4/26/2017.
 */

public class BasicAsteroid extends Asteroid {

    public BasicAsteroid(DynamicCoordinate start, DynamicCoordinate end) {
        this.health = 100;
        this.location = start;
        start.setDestination(end, 15);
        density = Resources.getSystem().getDisplayMetrics().density;
    }

    public void update() {
        location.update();
    }

}
