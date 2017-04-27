package com.group.oodproject;

import android.content.res.Resources;

/**
 * Created by User on 4/26/2017.
 */
public class AcceleratingFastAsteroid extends Asteroid
{
    private int age;

    public AcceleratingFastAsteroid(DynamicCoordinate start, DynamicCoordinate end) {
        this.health = 100;
        this.location = start;
        this.destination = end;
        start.setDestination(end, 30);
        density = Resources.getSystem().getDisplayMetrics().density;
        age = 0;
    }

    public void update() {
        location.update();
        age++;
        this.location.setDestination(this.destination, 10 + age/10);
    }
}
