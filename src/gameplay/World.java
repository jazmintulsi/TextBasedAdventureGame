package gameplay;

import java.util.Scanner;

/**
 * this class implementes a play method and basically 
 * has methods of each of the commands possible for two 
 * modes: explore or battle
 * @author Jazmin Vagha 16941106
 *
 */
public class World 
{
	public enum PlayMode {battle,explore;}
	PlayMode mode;
	private Player player;
	private boolean gameInProgress = true;
	private Room room;
	Player player_stats;
	Wieldable weapon;
	Monster monster;
	Character enemy;
	
	/**
	 * this play method goes through a loop which while the 
	 * gameInProgress is true (currently playing) then the 
	 * two modes will have methods which contain their commands
	 * @param player - the information of the player
	 * @author Jazmin Vagha 16941106
	 */
	//--------------------------------------------------------	
	private void play(Player player)
	{
		this.player=player;
		System.out.println("Welcome player "+player.getName());

		System.out.println(player);
		this.onEnterRoom();

		while(gameInProgress)
		{
			switch(this.mode)
			{
			case explore:
				processExploreUserInput();
				break;
			case battle:
				processBattleUserInput();             
				break;
			}
		} 
	}
	
	/**
	 * this method contains the commands that are available 
	 * for battle mode which also call their own functions, 
	 * it also scans the player for their input
	 */
	private void processBattleUserInput() 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("!>");
		String inputCmd = scan.nextLine();
		String[] tokens = inputCmd.toLowerCase().split(" ");
		
		switch(tokens[0])
		{
		case "attack":
			attack();
			break;
		case "wield weapon": 
			wieldWeapon(tokens);
			
		case "wield fistsoffury":
			wieldFistsOfFury();
			
		case "help":
			help();
			
		default:
			System.out.println(inputCmd + "is not recognized.");
		}

	}
	
	/**
	 * this method contains the commands that are available 
	 * for explore mode which also call their own functions, 
	 * it also scans the player for their input
	 * @author Jazmin Vagha 16941106
	 */
	private void processExploreUserInput() 
	{		
		Scanner scan = new Scanner(System.in);
		System.out.print("?> ");
		String inputCmd = scan.nextLine();
		String[] tokens = inputCmd.toLowerCase().split(" ");

		switch(tokens[0])
		{
		case "pickup":
			pickup(tokens); 
			break;
			
		case "exit":
			exit();             
			break;
			
		case "door":
			door(tokens);             
			break;
			
		case "describe":
			 describe();          
			break;
			
		case "admire":
	           admire(tokens);
			break;

		case "eat":
	           eat(tokens);
			break;
			
		case "mobile":
	           mobile(tokens);
			break;
			
		case "stats":
	           stats();
			break;
			
		case "wield weapon":
	           wieldWeapon(tokens);
			break;
			
		case "wield fistsoffury":
	           wieldFistsOfFury();
			break;
			
		case "open chest":
			openChest(tokens);
			break;
			
		case "help":
			help();	           
			break;
			
		default:
			System.out.println(inputCmd + " is not recognized.");
		}
	}
	
	/**
	 * this method gets the room 
	 * @return Room - returns a Room class value
	 * @author Jazmin Vagha 16941106
	 */
	public Room getRoom() 
	{
		return this.room;
	}

	/**
	 * this method sets the room
	 * @param room - sets the room from the Room class
	 * @author Jazmin Vagha 16941106
	 */
	public void setRoom(Room room) 
	{
		this.room = room;
	}

	/**
	 * this method allows the user to pickup a valuable that is in
	 * a room, it checks if the item is in the room and then adds it 
	 * into the player's inventory and removes it from the room
	 * @param tokens - a string array which stores the users command
	 * @author Jazmin Vagha 16941106
	 */
	private void pickup(String[] tokens) // pickup item and adds to inventory and removes from the room
	{
		boolean check = false;
		
		for (int i = 0; i < room.getPickupsInRoom().getItems().length; i++)
		{
			if(room.getPickupsInRoom().getItems()[i].compareID(tokens[1]))
			{
				check = true;
			}
		}
		if(check) 
		{				
			System.out.println(player.getName() + " pickups " + tokens[1]);
			//player.getInventory().add(room.getPickupsInRoom().select(tokens[1]));
			room.pickupsInRoom.remove(tokens[1]);
		}
		else
		{
			System.out.println(tokens[1] + " is not in the room.");
		}
	}

	/**
	 * this method searches the room for an exit, and when
	 * the final room is found, the game stops 
	 * @author Jazmin Vagha 16941106
	 */
	private void exit() // searches the room for an exit
	{
		if(room.finalRoom == true)
		{
			System.out.println(this.player.getName() + " searched the whole room for an exit.../nand.../nfound one as she was about to give up!");
			System.out.println(this.player.getName() + ", your quest has finished!");
			gameInProgress = false;
		}
	}
	
	/**
	 * this method describes each of the rooms, it lists
	 * what pickups are available in each of them and 
	 * how many doors you can go through
	 * @author Jazmin Vagha 16941106
	 */
	private void describe() // describes the room, lists the pickups and doors available
	{
		System.out.println(room.getDescription());
		
		for(int i = 0; i < room.getPickupsInRoom().getItems().length; i++)
		{
			System.out.println("There is a " + room.pickupsInRoom.getItems()[i].getId() + " in the room");
		}
		System.out.println("Doors: " + room.getConnectingRooms().length);
	}
	
	/**
	 * this method allows the user to admire a valuable that is in
	 * their inventory which can be pickups in the rooms, it 
	 * checks if the item is in their inventory
	 * and allows them to admire it, which increases their confidence
	 * value, but this can only be used to increase confidence once, 
	 * but will remain in the inventory
	 * @param tokens - a string array which stores the users command
	 * @author Jazmin Vagha 16941106
	 */
	private void admire(String[] tokens) //admires a pickup and increases the confidence - used once to increase confidence but stays in inventory
	{
		
		for(int i = 0; i < tokens.length; i++)
		{
			if(room.pickupsInRoom.getItems()[i].getId().equalsIgnoreCase(tokens[1]))
			{
				if	(tokens[i] == "Chalice")
				{
					player.confidence += 35;
					System.out.println(player.getName() + " admired the Chalice, it increased your confidence by 35!");
					Pickup pickup = player.getInventory().select("Chalice");
					Consumable consumable = (Consumable) pickup;
					consumable.setConsumed(true);
				}
				
				else if	(tokens[i] == "Ring")
				{
					player.confidence += 13;
					System.out.println(player.getName() + " admired the Ring, it increased your confidence by 13!");
					Pickup pickup = player.getInventory().select("Chalice");
					Consumable consumable = (Consumable) pickup;
					consumable.setConsumed(true);
				}
				
				else if	(tokens[i] == "MoneyBag")
				{
					player.confidence += 335;
					System.out.println(player.getName() + " admired the MoneyBag, it increased your confidence by 355!");
					Pickup pickup = player.getInventory().select("Chalice");
					Consumable consumable = (Consumable) pickup;
					consumable.setConsumed(true);
				}
				else if	(tokens[1] == "Jewel")
				{
					player.confidence += 13;
					System.out.println(player.getName() + " admired the Jewel, it increased your confidence by 13!");
					Pickup pickup = player.getInventory().select("Chalice");
					Consumable consumable = (Consumable) pickup;
					consumable.setConsumed(true);
				}
				else if	(tokens[i] == "GoldBars")
				{
					player.confidence += 4;
					System.out.println(player.getName() + " admired the GoldBars, it increased your confidence by 4!");
					Pickup pickup = player.getInventory().select("Chalice");
					Consumable consumable = (Consumable) pickup;
					consumable.setConsumed(true);
				}
				else if	(tokens[i] == "Coin")
				{
					player.confidence += 2;
					System.out.println(player.getName() + " admired the Coin, it increased your confidence by 2!");
					Pickup pickup = player.getInventory().select("Chalice");
					Consumable consumable = (Consumable) pickup;
					consumable.setConsumed(true);
				}
			}
		}
	}
	
	/**
	 * this method allows the user to eat a valuable that is in
	 * their inventory which can be picked up from rooms, it 
	 * checks if the item is in their inventory
	 * and allows them to eat it, which increases their health points,
	 * but this can only be consumed once and is removed from the 
	 * players inventory
	 * @param tokens - a string array which stores the users command
	 * @author Jazmin Vagha 16941106
	 */
	private void eat(String[] tokens) //eats food that is in the inventory - increase health points - food removed from inventory once eaten
	{
		for(int i = 0; i <= tokens.length; i++)
		{			
			if(room.pickupsInRoom.getItems()[i].getId().equalsIgnoreCase(tokens[i]))
			{
				if(tokens[i] == "Mead")
				{
					player.healthP =+ 25;
					room.pickupsInRoom.remove(tokens[i]);
					System.out.println("You consumed the Mead, it increased your health by 25!");
				}
				else if(tokens[i] == "Bread")
				{
					player.healthP += 45; 
					room.pickupsInRoom.remove(tokens[i]);
					System.out.println("You consumed the Bread, it increased your health by 45!");
				}
				else if(tokens[i] == "RoastBoar")
				{
					player.healthP += 25; 
					room.pickupsInRoom.remove(tokens[i]);
					System.out.println("You consumed the RoastBoar, it increased your health by 25!");
				}
			}
		}
	}
	

	/**
	 * this method allows the user to use a mobile phone that is in
	 * their inventory, which can be picked up from the rooms,
	 * it checks if the mobile is in their inventory
	 * and allows them to use it, which increases their confidence
	 * value, and remains in their inventory
	 * @param tokens - a string array which stores the users command
	 * @author Jazmin Vagha 16941106
	 */
	private void mobile(String[] tokens) //uses mobile phone if in inventory
	{
		for(int i = 0; i <= room.pickupsInRoom.getItems().length; i++)
		{			
			if(room.pickupsInRoom.getItems()[i].getId().equalsIgnoreCase(tokens[i]))
			{
				System.out.println(player.getName() + " uses mobile phone");
				player.confidence += 39;
			}
		}
	}
	
	/**
	 * this method allows the user to see what their current stats
	 * look like, if it has increased or decreased since the start,
	 * it shows the players health and confidence value and also
	 * shows what the player currently has in their inventory
	 * @author Jazmin Vagha 16941106
	 */
	private void stats() // shows the current stats of the player
	{
		System.out.println(player_stats.toString());
		System.out.println("You have the following items in your inventory: " + player.getInventory().getItems());
	}
	
	
	/**
	 * this methods allows the user to wield a weapon that they have
	 * in their inventory, which can be picked up in the rooms. they
	 * can wield weapons ready for battles, as long as they have the
	 * weapon in their inventory 
	 * @param tokens - a string array which stores the users command
	 * @author Jazmin Vagha 16941106
	 */
	private void wieldWeapon(String[] tokens) //wields weapon from inventory for battle
	{
		for(int i = 0; i <= room.pickupsInRoom.getItems().length; i++)
		{			
			if(room.pickupsInRoom.getItems()[i].getId().equalsIgnoreCase(tokens[i]))
			{
				System.out.println(player.getName() + " wields " + weapon.getDescription());
			}
		}
	}
	
	/**
	 * allows the user to set their weapon to fists of fury 
	 * which is the default weapon 
	 * @author Jazmin Vagha 16941106
	 */
	private void wieldFistsOfFury() //wields fist of fury - not in inventory
	{
		player.setWeapon(weapon);
	}
	
	/**
	 * the help methods lets the user know which commands are available 
	 * in the mode they they are in 
	 * @author Jazmin Vagha 16941106
	 */
	private void help() // tells the player the commands that are available in that mode
	{
		if(this.mode == mode.battle)
		{
			System.out.println("Battle modes: attack, wield weapon, wield fistsoffury, help");
		}
		else if(this.mode == mode.explore)
		{
			System.out.println("Explore modes: describe, pickup, admire, eat, wield, mobile, stats, open chest, help, exit");
		}
	}
	
	/**
	 * the attack method allows the user to attack the 
	 * monster that has appeared in a room and goes to 
	 * battle mode, when the player dies, the game ends.
	 * when the monster dies, the player resumes the 
	 * game in explore mode
	 * @author Jazmin Vagha 16941106
	 */
	private void attack() //attacks the monster in the room using the wielded weapon
	{
		if(monster.appear())
		{
			this.mode = PlayMode.battle;
			player.defendAttack(enemy);
			monster.defendAttack(enemy);
			if(player.healthP == 0)
			{
				exit();
			}
			else if(enemy.healthP == 0)
			{
				this.mode = PlayMode.explore;
			}
		}
	}
	
	/**
	 * the door method allows the user to type in the 
	 * command and the door number and enter that room
	 * @param tokens - a string array which stores the users command
	 * @author Jazmin Vagha 16941106
	 */
	private void door(String[] tokens) 
	{
		int door = Integer.parseInt(tokens[1]);
		setRoom(getRoom().getConnectingRooms()[door]);
	}
	
	/**
	 * allows the user to open a chest that they have found in 
	 * a room but only allows them to open it if they have either
	 * a key or a lockpick and add the items to their inventory
	 * and removes it from the room
	 * @param tokens -  a string array which stores the users command
	 * @author Jazmin Vagha 16941106
	 */
	private void openChest(String[] tokens) //opens treasure/war chest that is in inventory - contents placed in inventory and chest removed from the room
	{		
		for(int i = 0; i <= room.pickupsInRoom.getItems().length; i++)
		{			
			if(room.pickupsInRoom.getItems()[1].getId().equalsIgnoreCase(tokens[i]))
			{
				Openable warchest = (Openable) player.getInventory().select(tokens[i]);
				player.getInventory().add(warchest.getContents());
				room.pickupsInRoom.remove(tokens[i]);
			}
		}
	}
	 /**
	  * this method sets the start room for the game
	  * @param startRoom - the room the game starts at
	  * @author Jazmin Vagha 16941106
	  */
	public World(Room startRoom) 
	{
		this.mode = PlayMode.explore;
		room = startRoom;
	}
	
	/**
	 * this method describes a room when the player has 
	 * entered the room and makes a monster appear with 
	 * the probability made in previous classes, if a 
	 * monster appears, the game goes to battle mode
	 * @author Jazmin Vagha 16941106
	 */
	private void onEnterRoom()
	{
		describe();
		if(this.room.monster != null)
		{	
			boolean monsterSurprise = this.room.getMonster().appear();
			if(monsterSurprise)
			{
				this.mode = PlayMode.battle;
			}
		}		
	}
	
	//--------------------------------------------------------
	public static void main(String[] args) 
	{
		World world = ReadWorldDataFile.simpleWorld();
		Player playerOne = new Player("Sir Kendric","Shiny Armour",100,50);
		world.play(playerOne);		
	}
	//--------------------------------------------------------
}
