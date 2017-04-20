
public interface Projectile {
	double baseDamage=1;
	
	public void target(Asteroid t);
	public void render(Object canvas);
	public void update();
	public void setMult(double x);
	public void setImg(Object thing);
}
