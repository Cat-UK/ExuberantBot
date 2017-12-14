package Exuberant;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JDA bot = null;
		
		
			try {
				bot = new JDABuilder(AccountType.BOT).setToken(Secrets.TOKEN).buildBlocking();
				bot.getPresence().setGame(Game.of("clans for money."));
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RateLimitedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		CommandResponse cR = new CommandResponse();
		//cR.addCommands();
		bot.addEventListener(cR);
		
		

		
		
	
		
			
	}

}
