package gameplay;
/**
 * this class holds the players information, such as
 * their name, confidence value, weapon they are wielding
 * and their inventory. it also has two other methods 
 * to deal the attack damage and defend the attack
 * @author Jazmin Vagha 16941106
 *
 */
public class Player extends Character
{
	int confidence;
	private String name;
	private Wieldable weapon;
	private Inventory inventory;
	
	/**
	 * this method is a constructor that sets each of the
	 * instance variables and sets the default weapon to 
	 * fistsoffury
	 * @param name - this is the name of the player
	 * @param description - this is the description which is given in the Entity class
	 * @param health - this is the health of the player
	 * @param confidence - this is the players confidence level
	 * @author Jazmin Vagha 16941106
	 */
	public Player(String name,  String description, int health, int confidence)
	{
		super(description, health);
		this.setName(name);
		this.confidence = confidence;
		weapon = new FistsOfFury();
	}

	/**
	 * this method calculates the damage that the weapon has 
	 * done to the monster and returns it
	 * @return int - this method returns an int of the damage
	 * that the weapon has done to the monster and also how
	 * much of the confidence it has hit
	 * @author Jazmin Vagha 16941106
	 */
	public int dealAttackDamage()
	{		
		int damage = weapon.hit();
		
		return damage + damage * confidence/100;
	} 
	
	/**
	 * this method calculated the damage the weapon has 
	 * done to the monster
	 * @return int - this returns an integer of how much
	 * of the confidence and the health of a monster has 
	 * been damaged
	 * @param enemy - this is the monster of the type Character
	 * which has the values of the health and confidence
	 * @author Jazmin Vagha 16941106
	 */
	public int defendAttack(Character enemy)
	{
		int d = enemy.dealAttackDamage(); 
		super.healthP -= d;
		this.confidence -= d/2;
		return d;
	}

	/**
	 * this method gets the confidence of the player
	 * @return int - this returns an integer value of the confidence
	 * @author Jazmin Vagha 16941106
	 */
	public int getConfidence() 
	{
		return confidence;
	}

	/**
	 * this method sets the confidence of the player
	 * @param confidence - this is the confidence of the player
	 * @author Jazmin Vagha 16941106
	 */
	public void setConfidence(int confidence) 
	{
		this.confidence = confidence;
	}
	
	/**
	 * this method gets the name of the player
	 * @return int - this returns an String value of the name
	 * @author Jazmin Vagha 16941106
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * this method sets the name of the player
	 * @param name - this is a String value of the name
	 * @author Jazmin Vagha 16941106
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * this method gets the current inventory of the player
	 * @return Inventory - this returns an Inventory value that 
	 * the player has
	 * @author Jazmin Vagha 16941106
	 */
	public Inventory getInventory() 
	{
		return inventory;
	}

	/**
	 * this method sets the Inventory of the player
	 * @param inventory - this is a Inventory value of the
	 * players inventory
	 * @author Jazmin Vagha 16941106
	 */
	public void setInventory(Inventory inventory)
	{
		this.inventory = inventory;
	}

	/**
	 * this method gets the weapon of the player
	 * @return Wieldable - this returns a Wieldable value of the weapon
	 * that the player has
	 * @author Jazmin Vagha 16941106
	 */
	public Wieldable getWeapon() 
	{
		return weapon;
	}
	
	/**
	 * this method sets the weapon of the player
	 * @return int - this is a Wieldable value of the weapon
	 * that the player has
	 * @author Jazmin Vagha 16941106
	 */
	public void setWeapon(Wieldable weapon)
	{
		this.weapon = weapon;
	}

	/**
	 * this returns the health, confidence value and the 
	 * weapon that the player is currently wielding
	 * @author Jazmin Vagha 16941106
	 * @return String - toString representation which returns 
	 * health, confidence and the weapon being wielded
	 */
	public String toString()
	{
		return "Health: " + this.healthP + " Confidence: " + this.confidence + " Wielding: " + weapon; 
	}

}               
