package gameplay;
/**
 * this class extends Pickup and sets the constructors
 * for the food class and also tells you whether or not
 * an item has been consumed or not
 * @author Jazmin Vagha 16941106
 *
 */
public abstract class Consumable extends Pickup
{
	private boolean consumed;
	
	/**
	 * this method sets all the values for the consumable and sets consumed to false
	 * @author Jazmin Vagha 16941106
	 * @param description - this is the description which is given in the Entity class
	 */
	public Consumable(String description) 
	{
		super(description);
		this.setConsumed(false);
	}

	/**
	 * this method returns true if the pickup has been consumed
	 * @author Jazmin Vagha 16941106
	 * @return boolean if the pickup is consumed or not
	 */
	public boolean isConsumed() 
	{
		return consumed;
	}
	/**
	 * this method sets consumed
	 * @author Jazmin Vagha 16941106
	 * @param consumed - whether or not the pickup has been consumed or not,
	 *  could be food or valuable
	 */
	public void setConsumed(boolean consumed) 
	{
		this.consumed = consumed;
	}

}
