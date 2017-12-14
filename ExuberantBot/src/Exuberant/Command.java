package Exuberant;


import java.util.ArrayList;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;


public abstract class Command {
	
	
	protected String description = "No help available.";
	protected String RequiredRole = null;
	
	
	
	
	
	
	String Command;
	
	MessageReceivedEvent message;
	
	
	
	
	
	
	
	
	protected abstract void ExecuteCommand( MessageReceivedEvent event);
	//protected abstract  void getDescription();
}