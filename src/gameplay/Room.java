package gameplay;
/**
 * the room class extends Entity and holds the values
 * of a monster, the pickups available in a room, the 
 * connecting rooms and the final room
 * @author Jazmin Vagha 16941106
 *
 */
public class Room extends Entity
{
	Monster monster;
	Inventory pickupsInRoom;
	Room[] connecting;
	boolean finalRoom;
	
	/**
	 * this is a constructor that initilizes all of the 
	 * variables to null or false
	 * @author Jazmin Vagha 16941106
	 */
	public Room()
	{
		super("");
		this.monster = null;
		this.pickupsInRoom = null;
		this.connecting = null;
		this.finalRoom = false;		
	}
	
	/**
	 * this method sets the values of description, pickups in a room and the 
	 * the connecting rooms
	 * @param description - this is the description which is given in the Entity class
	 * @param pickupsInRoom - the pickups that are available in a room
	 * @param connectingRooms - the rooms that are connected together (by doors)
	 * @author Jazmin Vagha 16941106
	 */
	public Room(String description,Inventory pickupsInRoom, Room[] connectingRooms)
	{
		super(description);
		this.pickupsInRoom = pickupsInRoom;
		this.connecting = connectingRooms;
	}

	/**
	 * this method gets the Monster
	 * @return Monster - this returns a Monster value
	 * @author Jazmin Vagha 16941106
	 */
	public Monster getMonster() 
	{
		return monster;
	}

	/**
	 * this method sets the monsterr
	 * @param monster - this is the monster
	 * @author Jazmin Vagha 16941106
	 */
	public void setMonster(Monster monster) 
	{
		this.monster = monster;
	}
	
	/**
	 * this method gets the pickups that are available in a room
	 * @return Inventory - this returns the pickups that are in a
	 * room using the inventory
	 * @author Jazmin Vagha 16941106
	 */
	public Inventory getPickupsInRoom() 
	{
		return pickupsInRoom;
	}

	/**
	 * this method sets the pickups that are in a room
	 * @param pickupsInRoom - this is the pickups in a room
	 * @author Jazmin Vagha 16941106
	 */
	public void setPickupsInRoom(Inventory pickupsInRoom) 
	{
		this.pickupsInRoom = pickupsInRoom;
	}

	/**
	 * this method gets the connecting rooms - rooms connected
	 * by doors
	 * @return Room[] - this returns a Room array
	 * @author Jazmin Vagha 16941106
	 */
	public Room[] getConnectingRooms() 
	{
		return connecting;
	}
	
	/**
	 * this method sets the connecting rooms
	 * @param connecting - this is rooms that are connecting
	 * @author Jazmin Vagha 16941106
	 */
	public void setConnectingRooms(Room[] connecting) 
	{
		this.connecting = connecting;
	}
	
	/**
	 * this method gets the final rooms and is a true/false method
	 * @return boolean - this returns a boolean value of the final room
	 * @author Jazmin Vagha 16941106
	 */
	public boolean isFinalRoom() 
	{
		return finalRoom;
	}

	/**
	 * this method sets the final room
	 * @param finalRoom - this is the final room of the game
	 * @author Jazmin Vagha 16941106
	 */
	public void setFinalRoom(boolean finalRoom) 
	{
		this.finalRoom = finalRoom;
	}
}
