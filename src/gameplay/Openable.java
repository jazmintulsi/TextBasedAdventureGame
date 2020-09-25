package gameplay;

/**
 * this class stores the pickups that needs to be opened
 * in order for the valuables to be accessed, it stores the locked 
 * and contents variable
 * @author Jazmin Vagha 16941106
 */
public abstract class Openable extends Pickup
{
	private boolean locked;
	private Pickup contents;
	
	/**
	 * this method sets the values 
	 * @author Jazmin Vagha 16941106
	 * @param description - this is the description which is given in the Entity class
	 * @param contents - this variable holds what valuable is stored in the chests
	 */
	public Openable(String description, Pickup contents)
	{
		super(description);
		this.setLocked(locked);
		this.contents = contents;
	}
	
	/**
	 * this method sets the description and sets locked to true 
	 * @author Jazmin Vagha 16941106
	 * @param description - this is the description which is given in the Entity class
	 */
	public Openable(String description)
	{
		super(description);
		this.locked = true;
	}
	
	/**this method returns a boolean if the chest is locked or not
	 * @author Jazmin Vagha 16941106
	 * @return boolean - returns a true or false if the chest is locked or not
	 */
	public boolean isLocked() 
	{
		return locked;
	}

	/**
	 * @author Jazmin Vagha 16941106
	 * this method sets the locked variable
	 * @param locked - sets the variable to locked
	 */
	public void setLocked(boolean locked) 
	{
		this.locked = locked;
	}

	/**this method returns a Pickup to get the contents
	 * @author Jazmin Vagha 16941106
	 * @return Pickup - returns a Pickup to get the contents
	 */
	public Pickup getContents() 
	{
		return contents;
	}
	
	/**
	 * @author Jazmin Vagha 16941106
	 * this method sets the contents variable
	 * @param locked - sets the contents variable
	 */
	public void setContents(Pickup contents) 
	{
		this.contents = contents;
	}
}
