package gameplay;

/**
 * this class stores the descriptions and the id for 
 * all the classes, it also has get and set methods 
 * for the id and description variables
 * @author Jazmin Vagha 16941106
 */
import java.util.Random;

public abstract class Entity 
{
	private String id;
	private String description;
	
	/**
	 * this method sets all the values for the entity, it sets
	 * the id to a simple form
	 * @author Jazmin Vagha 16941106
	 * @param description - this is the description which is set for all the classes
	 */
	public Entity(String description)
	{
		this.description = description;
		this.id = this.getClass().getSimpleName();
	}
	
	/**
	 * this method gets the description and returns a string
	 * @author Jazmin Vagha 16941106
	 * @return String - this returns a string of description
	 */
	public String getDescription() 
	{
		return description;
	}

	/**
	 * this method set the description 
	 * @author Jazmin Vagha 16941106
	 * @param description - this sets the description
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}

	/** this methods get the entity id and returns a string
	 * @author Jazmin Vagha 16941106
	 * @return String - this returns a string of ID 
	 */
	public String getId() 
	{
		return id;
	}
	
	/**
	 * this method randomly generates a number between the high and low and returns it
	 * @author Jazmin Vagha 16941106
	 * @param highN - the highest number to be randomly generated
	 * @param lowN - the lowest number to be randomly generated 
	 * @return int - returns an integer of the random number generated
	 */
	protected int randomNumberGen(int highN , int lowN)
	{
		return new Random().nextInt(highN-lowN) + lowN;
	}
	
	/**
	 * this method compares two strings and if the ID matches then
	 * true is returned
	 * @author Jazmin Vagha 16941106
	 * @param compare - this compares two strings to find an ID
	 * @return boolean - returns true or false depending if the strings matched
	 */
	public boolean compareID(String compare)
	{
		boolean check =	compare.equalsIgnoreCase(this.id);
		return check;
	}
	
	/**
	 * this returns the value stored in id
	 * @author Jazmin Vagha 16941106
	 * @return String - toString representation which returns ID
	 */
	public String toString()
	{
		return this.id;
	}
	
}
