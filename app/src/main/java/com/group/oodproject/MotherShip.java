package com.group.oodproject;

import android.graphics.Canvas;

public interface MotherShip {
 public String getName();
 public int getHealth();
 public Projectile getWeapon();
 public int getLevel();
 public String getImg();
 public int getHitBoxWidth();
 public int getHitBoxHeight();
 public void setHealth(int health);
 public void setLevel(int level);
 public void setImg(String img);
 public void setHitBoxWidth(int width);
 public void setHitBoxHeight(int height);
 public void setName(String name);
 public void fire(int xCord, int yCord);
 public void damage(int damageAmount);
 public void destroy();
 public void render(Canvas canvas);
}
