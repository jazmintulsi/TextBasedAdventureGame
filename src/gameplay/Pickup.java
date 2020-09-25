package gameplay;
/**
 * this class is extends Entity and stores a constructor 
 * which has the description for a specific pickup
 * @author Jazmin Vagha 16941106 
 */
public abstract class Pickup extends Entity
{
	/**
	 * this method is based from the constructor in the Entity class
	 * and sets the description of a pickup
	 * @param description
	 */
	public Pickup(String description) 
	{
		super(description);
	}	
}
