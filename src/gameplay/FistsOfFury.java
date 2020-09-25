package gameplay;
/**
 * this class is a weapon which extends Wieldable and has a high and
 * low which is the default weapon that the player has
 * @author Jazmin Vagha 16941106
 *
 */
public class FistsOfFury extends Wieldable
{
	/**
	 * this method sets all the values for the fistsoffury
	 * @param description - this is the description which is given in the Entity class
	 * @param high - this is the highest number that can be generated for the fistsofffury
	 * @param low - this is the lowest number that can be generated for the fistsoffury
	 * @author Jazmin Vagha 16941106
	 */
	public FistsOfFury(String description, int high, int low) 
	{
		super(description, high, low);
	}
	
	/**
	 * this method sets the integer values for fistsoffurry
	 * @author Jazmin Vagha 16941106
	 */
	public FistsOfFury()
	{
		super("FistsOfFury", 15, 7);
	}

}
