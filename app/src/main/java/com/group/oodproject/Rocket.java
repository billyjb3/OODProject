package com.group.oodproject;

public class Rocket implements Projectile {

	String name="Rocket";
	double damage;
	double dammult=1.5;
	static int xpos_start;
	static int ypos_start;
	int xpos_end;
	int ypos_end;

	//Sound sound=something;
	
	public Rocket(){
		damage=Projectile.baseDamage*dammult;

	}
	
	@Override
	public void target(float x_pos, float y_pos) {


	}

	@Override
	public void render(Object canvas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMult(double x) {
		dammult=dammult*x;
	}
	
	@Override
	public void setImg(Object thing){

	}

	@Override
	public double getDamage() {
		return 0;
	}

}
