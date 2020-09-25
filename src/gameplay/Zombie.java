package gameplay;
/**
 * this class extends the Monster class and has a description
 * and stores how much damage the monster for have and their
 * starting health
 * @author Jazmin Vagha 16941106
 */
public class Zombie extends Monster
{
	/**
	 * 
	 * @Jazmin Vagha 16941106
	 * this method sets all the values for the zombie
	 * @param description - this is the description which is given in the Entity class
	 * @param health - this is the health points of the monster
	 * @param damage - this is the number of the damage that the monster will do
	 * @param probability - this is the probability of the monster attacking
	 */
	public Zombie(String description, int health, int damage, int probability) 
	{
		super(description, health, damage, probability);
	}
	
	/**
	 * this method sets the integer values for the zombie
	 * @author Jazmin Vagha 16941106
	 * @param probability - this sets each of the parameters above for the monster
	 */
	public Zombie(int probability) 
	{
		super("Zombie", 40, 20, probability);
	}
}
