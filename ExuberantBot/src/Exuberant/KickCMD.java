package Exuberant;

import java.util.List;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;

public class KickCMD extends Command{
	
	@Override
	protected void ExecuteCommand(MessageReceivedEvent event){
		
		String msg = event.getMessage().getContent();
		Guild guild = event.getGuild();
        Member selfMember = guild.getSelfMember();  
        
        
        if (event.getMessage().getMentionedUsers().isEmpty())
        {
            event.getTextChannel().sendMessage("You must mention 1 or more Users to be muted!").queue();
        } else{
        
		if(!event.getMember().hasPermission(Permission.KICK_MEMBERS)){
			

        	
    		
    		event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " you don't have the authority to kick members.").queue();
    		
    		
    		
    		
    		
    	} else{
    		
    		 List<User> mentionedUsers = event.getMessage().getMentionedUsers();
             for (User user : mentionedUsers)
             {
                 Member mentionedUser = guild.getMember(user); 
                 
                 
                 if(!selfMember.canInteract(mentionedUser)){
                	 
                		event.getTextChannel().sendMessage("I can't kick " + mentionedUser.getAsMention() + " they are higher in status than me.").queue();
                		
                		
                		
                	 
                 }  else{
                	 
                	 
                	 if(!event.getMember().canInteract(mentionedUser)){
                		 
                		 event.getTextChannel().sendMessage("YOU CANNOT KICK" + mentionedUser.getAsMention() + " they are higher in status THAN YOU.").queue();
                		 
                	 } else{
                		 
                		 
                		
                		 
                		 
                		 List<User> mentionedUsers1 = event.getMessage().getMentionedUsers();
                         for (User user1 : mentionedUsers)
                         {
                             Member member = guild.getMember(user1);  //We get the member object for each mentioned user to kick them!

                             //We need to make sure that we can interact with them. Interacting with a Member means you are higher
                             // in the Role hierarchy than they are. Remember, NO ONE is above the Guild's Owner. (Guild#getOwner())
                             if (!selfMember.canInteract(member))
                             {
                                event.getChannel().sendMessage("Cannot kicked member: " + member.getEffectiveName() +", they are higher " +
                                         "in the hierachy than I am!").queue();
                                 continue;   //Continue to the next mentioned user to be kicked.
                             }

                             //Remember, due to the fact that we're using queue we will never have to deal with RateLimits.
                             // JDA will do it all for you so long as you are using queue!
                             guild.getController().kick(member).queue(
                                 success -> event.getChannel().sendMessage("Kicked " + member.getEffectiveName() + "! Cya!").queue(),
                                 error ->
                                 {
                                     //The failure consumer provides a throwable. In this case we want to check for a PermissionException.
                                     if (error instanceof PermissionException)
                                     {
                                         PermissionException pe = (PermissionException) error;
                                         Permission missingPermission = pe.getPermission();  //If you want to know exactly what permission is missing, this is how.
                                                                                             //Note: some PermissionExceptions have no permission provided, only an error message!

                                         event.getChannel().sendMessage("PermissionError kicking [" + member.getEffectiveName()
                                                 + "]: " + error.getMessage()).queue();
                                     }
                                     else
                                     {
                                         event.getChannel().sendMessage("Unknown error while kicking [" + member.getEffectiveName()
                                                 + "]: " + "<" + error.getClass().getSimpleName() + ">: " + error.getMessage()).queue();
                                     }
                                 });
                          
                    	  
                    	 
                    	  
                		 
                		 
                		 
                		 
                	 }
                	 
                	 
                 }
                 
                 
             }
    		
    	
    		
    	}
		
		
		
		
		
        }
		
		
		
	}

}
}
