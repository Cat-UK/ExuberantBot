package Exuberant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MuteCMD extends Command{
	
	
	
	public MuteCMD(){
		

		this.description = "``` This command applies to the 'muted' role for users (NOTE: Must have role named 'muted'). ```";
		
	}
	
	
	
	
	@Override
	protected void ExecuteCommand(MessageReceivedEvent event){
		
		String msg = event.getMessage().getContent();
		Guild guild = event.getGuild();
        Member selfMember = guild.getSelfMember();  
        
        
        if (event.getMessage().getMentionedUsers().isEmpty())
        {
            event.getTextChannel().sendMessage("You must mention 1 or more Users to be muted!").queue();
        } else{
        
		if(!event.getMember().hasPermission(Permission.MANAGE_ROLES)){
			

        	
    		
    		event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " you don't have the authority to mute members.").queue();
    		
    		
    		
    		
    		
    	} else{
    		
    		 List<User> mentionedUsers = event.getMessage().getMentionedUsers();
             for (User user : mentionedUsers)
             {
                 Member mentionedUser = guild.getMember(user); 
                 
                 
                 if(!selfMember.canInteract(mentionedUser)){
                	 
                		event.getTextChannel().sendMessage("I can't mute " + mentionedUser.getAsMention() + " they are higher in status than me.").queue();
                		
                		
                		
                	 
                 }  else{
                	 
                	 
                	 if(!event.getMember().canInteract(mentionedUser)){
                		 
                		 event.getTextChannel().sendMessage("YOU CANNOT MUTE" + mentionedUser.getAsMention() + " they are higher in status THAN YOU.").queue();
                		 
                	 } else{
                		 
                		 
                		 
                		 Role muteRole = event.getGuild().getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("Muted")).findFirst().orElse(null);
                		 
                		 
                		  event.getGuild().getController().addRolesToMember(mentionedUser, muteRole).queue();
                          
                    	  
                    	  event.getTextChannel().sendMessage("``` " + mentionedUser.getEffectiveName() + " has been silenced ```").queue();
                    	  
                		 
                		 
                		 
                		 
                	 }
                	 
                	 
                 }
                 
                 
             }
    		
    	
    		
    	}
		
		
		
		
		
        }
		
		
		
	}
	

}
