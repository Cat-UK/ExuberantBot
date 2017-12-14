package Exuberant;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PurgeCMD {
	
	
	public void ExecuteCommand(MessageReceivedEvent event){
		

		String msg = event.getMessage().getContent();
		Guild guild = event.getGuild();
        Member selfMember = guild.getSelfMember();  
		
        
if(!event.getMember().hasPermission(Permission.MANAGE_ROLES)){
    		
    		event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " you don't have the authority to purge messages.").queue();
    		
} else{


    		
    		
    		
		
		StringBuilder s = new StringBuilder(msg); 	
    	s.delete(0, 6);
    	
    	
    	String si = s.toString();
 
    	String haha = si.trim();
       	System.out.println(haha);
    	
    	try{
    	int num = Integer.parseInt(haha);
    	System.out.println(num);
    	
    	event.getChannel().getHistory().retrievePast(num).queue((messages) -> event.getTextChannel().deleteMessages(messages).queue());
    	} catch (NumberFormatException e){
    		
    		event.getChannel().sendMessage("Give me an actual number.").queue();
    		
    	}
    	
    	
    	
		
		
	}

	}

}
