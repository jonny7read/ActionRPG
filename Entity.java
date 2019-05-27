import java.util.Random;

public class Entity implements Runnable
{
	public int maxHit;
	public int health;
	public int hitSpeed;
	private String name;
	private Random ran = new Random();
	private Thread thread;
	private Entity enemy;
	
	public Entity(String name, int health, int maxHit, int hitSpeed) {
		this.name = name;
		this.health = health;
		this.maxHit = maxHit;
		this.hitSpeed = hitSpeed;
		
		thread = new Thread(this);
	}
	
	public void setEnemy(Entity enemy) {
		this.enemy = enemy;
		thread.start();
	}
	
	public void hit(Entity enemy) {
		int hit = Math.min(ran.nextInt(this.maxHit), enemy.health);
		doHit(enemy, hit);
	}

	@Override
	public void run()
	{
		while (this.enemy.health > 0 && this.health > 0) {
			hit(this.enemy);
		}
	}
	
	private void doHit(Entity enemy, int hit) {
		enemy.health = enemy.health - hit;
		System.out.println(this.name + " hit " + hit + ", " + enemy.name + " health remaining: " + enemy.health);

		if (enemy.health > 0) {
			sleep(this.hitSpeed);
		} else {
			System.out.println(enemy.name + " dead!");
		}
	}
	
	private void sleep(int millis){
		try {
			thread.sleep(millis);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}
