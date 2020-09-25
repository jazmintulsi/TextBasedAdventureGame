package gameplay;
/**
 * this class extends Pickup and is the weapon that the
 * player will wield once it is found in the rooms, it also
 * stores a maximum and minimum number of the damage it will do
 * @author Jazmin Vagha 16941106
 */
public abstract class Wieldable extends Pickup
{
	private int high;
	private int low;
	
	/**
	 * this method sets the description and the high and low values
	 * @param description - this is the description which is given in the Entity class
	 * @param high - the highest number of damage that the weapon can do 
	 * @param low - the lowest number of damage that the weapon can do
	 * @author Jazmin Vagha 16941106
	 */
	public Wieldable(String description, int high, int low) 
	{
		super(description);
		this.high = high;
		this.low = low;
	}
	
	/**
	 * this method returns a randomly generated number between the high
	 * and low values that the weapon can hit
	 * @return int - returns and int of the randomly generated number
	 * @author Jazmin Vagha 16941106
	 */
	public int hit()
	{
		return super.randomNumberGen(this.high, this.low);
	}
	
}
