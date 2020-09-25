package gameplay;
/**
 * this class extends Entity and stores the health points of the character
 * and the description
 * @author Jazmin Vagha 16941106
 *
 */
public abstract class Character extends Entity
{
	int healthP;
	
	/**
	 * this method sets all the values for the character
	 * @param description - this is the description which is given in the Entity class
	 * @param health - the health points of the character
	 * @author Jazmin Vagha 16941106
	 */
	public Character(String description,  int health) 
	{
		super(description);
		this.healthP = health;
	}
	/**
	 * this method sets all the values for the character
	 * @param description - this is the description which is given in the Entity class
	 * @author Jazmin Vagha 16941106
	 */
	public Character(String description) 
	{
		super(description);
	}

	protected abstract int dealAttackDamage();
	public abstract int defendAttack(Character enemy);
}
