
public class UpRocket extends ProjectileDecorator {
	protected Projectile decoratedProjectile;
	
	public UpRocket(Projectile decoratedProjectile){
		super(decoratedProjectile);
		decoratedProjectile.setMult(2);
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
	public void setImg(Object thing){
		//change the image to something else
	}

}
