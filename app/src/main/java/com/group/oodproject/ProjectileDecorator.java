
public abstract class ProjectileDecorator implements Projectile{
	protected Projectile decoratedProjectile;
	
	public ProjectileDecorator(Projectile decoratedProjectile){
		this.decoratedProjectile=decoratedProjectile;
	}

	public void setMult(double x){
		decoratedProjectile.setMult(x);
	}
}
