package com.group.oodproject;

public class Laser implements Projectile {

	String name = "Short Laser";
	double damage;
	double dammult=1;
	// once we learn the start positions, we set these variables to that and
	// leave them
	static int xpos_start;
	static int ypos_start;
	int xpos_end;
	int ypos_end;

	// the next 2 could be arrays and hold different versions to provide some
	// randomization and variety
	
	// Image img=something;
	// Sound sound=something;

	public Laser() {
		damage=Projectile.baseDamage*dammult;
	}

	@Override
	public void target(float x_pos, float y_pos) {
		// TODO Auto-generated method stub

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
		//change the image to something else
	}

	@Override
	public double getDamage() {
		return 0;
	}

}
