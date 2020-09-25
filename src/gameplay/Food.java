package gameplay;

/**
 * @author Jazmin Vagha 16941106
 * this class extends Consumable and stores the
 * health points and the description of the 3
 * foods: mead, roast boar and bread
 */
public abstract class Food extends Consumable 
{
	int healthPoints;
	
	/**
	 * this method sets all the values for the food 
	 * @author Jazmin Vagha 16941106
	 * @param description - this is the description which is given in the Entity class
	 * @param health - the health points which each food has
	 * consumed is also set to false as the food is initially not consumed
	 */
	public Food(String description, int health) 
	{
		super(description);
		this.setHealthPoints(health);
		this.setConsumed(false);
	}
	
	/**
	 * this method returns and gets the health points 
	 * @author Jazmin Vagha 16941106
	 * @return int - returns an integer of the health points
	 */
	public int getHealthPoints() 
	{
		return healthPoints;
	}

	/**
	 * this method sets the health points
	 * @author Jazmin Vagha 16941106
	 * @param healthPoints - sets the health points 
	 */
	public void setHealthPoints(int healthPoints) 
	{
		this.healthPoints = healthPoints;
	}
}
