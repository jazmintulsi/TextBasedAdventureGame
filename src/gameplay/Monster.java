package gameplay;

import java.util.Random;
/**
 * @Jazmin Vagha 16941106
 * this class extends Character and stores the information of 
 * the monster, and stores the damage, probability and the
 * health of the monster. it also stores the methods for the 
 * monster to attack
 */
public abstract class Monster extends Character
{
	int damage;
	int probability;
	Character monsterHealth;
	/**
	 * @Jazmin Vagha 16941106
	 * this method sets the instance variables
	 * @param description - this is the description which is given in the Entity class
	 * @param health - this is the health points of the monster
	 * @param damage - this is the number of the damage that the monster will do
	 * @param probability - this is the probability of the monster attacking
	 */
	public Monster(String description, int health, int damage, int probability) 
	{
		super(description, health);
		this.damage = damage;
		this.probability = probability;
	}
	
	/**
	 * this method sets the description for monster
	 * @Jazmin Vagha 16941106
	 * @param description - this is the description which is given in the Entity class
	 */
	public Monster(String description) 
	{
		super(description);
	}
	
	/**
	 * this method generates a random number between 1 and 10 
	 * and returns the damage and the random number which is the 
	 * damage that the monster will do
	 *  @Jazmin Vagha 16941106
	 *  @return int- this returns an integer of the random number that is 
	 *  generated for the damage that the monster will do
	 */
	@Override
	public int dealAttackDamage() 
	{
		int r = new Random().nextInt(10-1) + 1;
		return damage + r;
	}
	
	/**
	 * this method has a variable which is set to deal
	 * attack damage on a character and decreases the
	 * players health by a specific number
	 * @return int - this returns an int of the number of 
	 * the health of the monster after it has been attacked
	 * @author Jazmin Vagha 16941106
	 */
	public int defendAttack(Character enemy)
	{
		int d = enemy.dealAttackDamage();
		super.healthP -= d;
		return d;
	}
	
	/**
	 * this method generates a random number on when a monster
	 * will appear in a room, but if the monster has been attacked
	 * and killed by the player then the monster will not appear
	 * @return boolean - this returns the randomly generated number
	 * of the monster appearing and if the monsters health is equal to 
	 * zero, then the monster doesn't appear
	 * @author Jazmin Vagha 16941106
	 */
	public boolean appear()
	{
		int r = new Random().nextInt(101 - 0) + 0;	
		
		if(monsterHealth.healthP == 0)
		{
			return false;
		}
		else 
		{
			return r <= probability;
		}
	}
}
