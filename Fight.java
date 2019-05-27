import java.util.*;

public class Fight
{
	private Entity player;
	private Entity enemy;
	
	public static void main(String[] args)
	{
		Entity player = new Entity("Player", 10, 5, 500);
		Entity enemy = new Entity("Enemy", 10, 5, 1000);
		Fight fight = new Fight(player, enemy);
		fight.start();
	}

	public Fight(Entity player, Entity enemy) {
		this.player = player;
		this.enemy = enemy;
	}
	
	public void start(){
		player.setEnemy(enemy);
		enemy.setEnemy(player);
	}

}
