package gameplay;
/**
 * this class extends Consumable and sets the values
 * and description to a valuable - confidence points
 * @author Jazmin Vagha 16941106
 *
 */
public abstract class Valuable extends Consumable 
{
	private int value;
	
	/**
	 * this method sets the values and descriptions to a valuable
	 * @param description - this is the description which is given in the Entity class
	 * @param value - this is the value that the players confidence
	 * will increase by from the valuable
	 * @author Jazmin Vagha 16941106
	 */
	public Valuable(String description, int value) 
	{
		super(description);
		this.setValue(value);
		this.setConsumed(false);
	}

	/**
	 * this method gets the value of how much the confidence will 
	 * increase by from a valuable
	 * @return int - this returns an integer value of the worth of 
	 * the valuable
	 * @author Jazmin Vagha 16941106
	 */
	public int getValue() 
	{
		return value;
	}

	/**
	 * this method sets the value of how much the confidence will
	 * increase by from a valuable
	 * @param value - this is the int value of the worth of the valuable
	 * @author Jazmin Vagha 16941106
	 */
	public void setValue(int value) 
	{
		this.value = value;
	}

}
