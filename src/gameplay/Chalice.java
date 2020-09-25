package gameplay;
/**
 * this class extends the Valuable class and has a description
 * and a value of how much the players confidence will increase by
 * @author Jazmin Vagha 16941106
 *
 */
public class Chalice extends Valuable
{
	/**
	 * this method sets all the values for the chalice
	 * @param description -  this is the description which is given in the Entity class
	 * @param value - this is the confidence of how much the valuable is worth
	 * @author Jazmin Vagha 16941106
	 */
	public Chalice(String description, int value) 
	{
		super(description, value);
	}
}
