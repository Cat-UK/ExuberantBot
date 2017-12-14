package Exuberant;

import java.util.Random;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Battle {
	
	
	
	public static boolean inBattle = false;
	public boolean valid = true;
	
	public void ExecuteCommand(MessageReceivedEvent event){ 
		
	
	
	
	
	
			
	
		//inBattle = true;
		
		
		while(inBattle = true){

	

			// System objects
			
			Random rand = new Random();

			// Game variables
			String[] enemies = { "Promethean Knight", "Elite", "Grunt", "Promethean Soldier" };
			int maxEnemyHealth = 75;
			int enemyAttackDamage = 25;

			// Player variables
			int health = 100;
			int attackDmg = 50;
			int numHealthPots = 3;
			int shieldsCharge = 30;
			int healthPotionDropChance = 50; // Percentage

			boolean running = true;
			
			event.getChannel().sendMessage("Spartan! You're needed in battle. Take 'em out!").queue();
			//System.out.println("Welcome to the dungeon!");

			// Label
			GAME:
			while (running) {
				event.getChannel().sendMessage("--------------------------------------").queue();
				//System.out.println("--------------------------------------");

				int enemyHealth = rand.nextInt(maxEnemyHealth);
				String enemy = enemies[rand.nextInt(enemies.length)];
				//System.out.println("\t# " + enemy + " has appeared! #\n");
				event.getChannel().sendMessage("\t# " + enemy + " has appeared! #\n").queue();
				while (enemyHealth > 0) {
					event.getChannel().sendMessage("\tYour HP: " + health).queue();
					//System.out.println("\tYour HP: " + health);
					//System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
					event.getChannel().sendMessage("\t" + enemy + "'s HP: " + enemyHealth).queue();
					//System.out.println("\n\tWhat would you like to do?");
					event.getChannel().sendMessage("\n\tWhat would you like to do?").queue();
					event.getChannel().sendMessage("\t1. Attack").queue();
					//System.out.println("\t1. Attack");
					event.getChannel().sendMessage("\t2. Drink health potion").queue();
					//System.out.println("\t2. Drink health potion");
					event.getChannel().sendMessage("\t3. Run").queue();
					//System.out.println("\t3. Run");

					String input = event.getMessage().getContent();
					if (input.equals("1")) {
						int damageDealt = rand.nextInt(attackDmg);
						int damageTaken = rand.nextInt(enemyAttackDamage);

						enemyHealth -= damageDealt;
						health -= damageTaken;

						event.getChannel().sendMessage("\t> You strike the " + enemy + " for " + damageDealt + " damage").queue();
						event.getChannel().sendMessage("\t> You recieved " + damageTaken + " in retaliation").queue();

						if (health < 1) {
							event.getChannel().sendMessage("\t You have taken too much damage, you are too weak to go on").queue();
							break;
						}
					} else if (input.equals("2")) {

						if (numHealthPots > 0) {
							health += shieldsCharge;
							numHealthPots--;
							event.getChannel().sendMessage("\t> You retreated from battle for a short time, shields charged for: " + shieldsCharge + "."
									+ "\n\t> You now have" + health + "Health."
									+ "\n\t> You now have" + numHealthPots + " health potions left.\n").queue();
						} else {
							event.getChannel().sendMessage("\t> You have no health potions, defeat enemies for a chance to get one").queue();
						}

					} else if (input.equals("3")) {
						event.getChannel().sendMessage("\t> You run away from the " + enemy).queue();
						continue GAME;
					} else {
						valid = false;
						while(valid = false){
							
							
						}
						while (!input.equals("1") && !input.equals("2") && !input.contentEquals("3")) {
							event.getChannel().sendMessage("If you are using Exuberant for moderation commands, please provide an actual option number after you're done.").queue();
							input = event.getMessage().getContent();

						}
						
						
						//event.getChannel().sendMessage("\tInvalid command").queue();
					}
				}
				if (health < 1) {
					event.getChannel().sendMessage("An evac arrives and escorts you away from the battle, severely weakened, it's not over.").queue();
					break;
				}
				event.getChannel().sendMessage("--------------------------------------").queue();
				event.getChannel().sendMessage(" # " + enemy + " was defeated! # ").queue();
				event.getChannel().sendMessage(" # You have " + health + "HP left # ").queue();
				// If the random number is less than 50 it drops
				if (rand.nextInt(100) < healthPotionDropChance) {
					numHealthPots++;
					event.getChannel().sendMessage(" # The " + enemy + " dropped an overshield. # ").queue();
					event.getChannel().sendMessage(" # You now have " + numHealthPots + " health potion(s). # ").queue();
				}
				event.getChannel().sendMessage("--------------------------------------").queue();
				event.getChannel().sendMessage("What would you like to do now?").queue();
				event.getChannel().sendMessage("1. Continue fighting").queue();
				event.getChannel().sendMessage("2. Retreat from battle").queue();
				String input = event.getMessage().getContent();

				while (!input.equals("1") && !input.equals("2")) {
					event.getChannel().sendMessage("If you are using Exuberant for moderation commands, please provide an actual option number after you're done.").queue();
					input = event.getMessage().getContent();

				}
				if (input.equals("1")) {
					event.getChannel().sendMessage("You continue your adventure.").queue();
				} else if (input.equals("2")) {
					event.getChannel().sendMessage("You exit the dungeon.").queue();
					inBattle = false;
					CommandResponse.t = false;
					break;
				}
			}
			event.getChannel().sendMessage("######################").queue();
			event.getChannel().sendMessage("# THANKS FOR PLAYING #").queue();
			event.getChannel().sendMessage("######################").queue();
		
	
		}
}
	
	
}


