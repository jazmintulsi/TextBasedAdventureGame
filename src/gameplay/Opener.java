package gameplay;
/**
 * this class extends Pickup and stores the "openers", 
 * such as the key and the lockpick to open the 
 * chests 
 * @author Jazmin Vagha 16941106
 *
 */
public abstract class Opener extends Pickup
{
	/**
	 * this method sets the value for the description of opener
	 * @param description - this is the description which is given in the Entity class
	 */
	public Opener(String description) 
	{
		super(description);
	}

}
