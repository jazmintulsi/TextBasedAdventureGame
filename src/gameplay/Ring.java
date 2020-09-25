package gameplay;
/**
 * this class extends the Valuable class and has a description
 * and a value of how much the players confidence will increase by
 * @author Jazmin Vagha 16941106
 *
 */
public class Ring extends Valuable
{
	/**
	 * this method sets the description and the value that the 
	 * confidence will go up by
	 * @param description -  this is the description which is given in the Entity class
	 * @param value - this is the confidence of how much the valuable is worth
	 * @author Jazmin Vagha 16941106
	 */
	public Ring(String description, int value) 
	{
		super(description, value);
	}
}