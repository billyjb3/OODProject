
public class Rocket implements Projectile {

	String name="Rocket";
	double damage;
	double dammult=1.5;
	static int xpos_start;
	static int ypos_start;
	int xpos_end;
	int ypos_end;
	//Image img=something;
	//Sound sound=something;
	
	public Rocket(){
		damage=Projectile.baseDamage*dammult;
	}
	
	@Override
	public void target(Asteroid t) {
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

}
