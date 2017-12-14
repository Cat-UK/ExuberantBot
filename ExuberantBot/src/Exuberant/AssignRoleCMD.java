package Exuberant;

import java.util.List;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class AssignRoleCMD{

	protected void ExecuteCommand(MessageReceivedEvent event, String role) {
		// TODO Auto-generated method stub
		
		
		String msg = event.getMessage().getContent();
		Guild guild = event.getGuild();
        Member selfMember = guild.getSelfMember();  
        String q = "fish";
        
        
     
       
        
        
        if (event.getMessage().getMentionedUsers().isEmpty())
        {
            event.getTextChannel().sendMessage("You must mention 1 or more Users!").queue();
        } else{
        
		if(!event.getMember().hasPermission(Permission.MANAGE_ROLES)){
    		
    		event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " you don't have the authority to assign/remove roles.").queue();
    		
    		
    		
    		
    		
    	} else{
    		
    		 List<User> mentionedUsers = event.getMessage().getMentionedUsers();
             for (User user : mentionedUsers)
             {
                 Member mentionedUser = guild.getMember(user); 
                 
                 
                 if(!selfMember.canInteract(mentionedUser)){
                	 
                		event.getTextChannel().sendMessage("I have insufficient permissions.").queue();
                		
                		
                		
                	 
                 }  else{
                	 
                	 
                	 if(!event.getMember().canInteract(mentionedUser)){
                		 
                		 event.getTextChannel().sendMessage("Nice try. You can't assign a role to" + mentionedUser.getAsMention() + " they are higher in status than you. Rekt.").queue();
                		 
                		 
                	 } else{
                		 
                		 
                	try{
                		 
                		// System.out.print(mentionedUser.getAsMention().toString());
                		 
                		 String p = mentionedUser.getEffectiveName();
                		 System.out.println(p);
                		 
                		 if(role.contains(p)){
                			 String fish = role.replace(p, "");
                			 String noodles = fish.replace("@", "");
                			// po = role.replace(p, "");
                			//po =  po.replace("@", "");
                			 String haha = noodles.trim();
                			System.out.println(haha);
                			
                			 
                			 
     						if(!event.getGuild().getRoles().stream().anyMatch(r -> r.getName().equalsIgnoreCase(haha)))
                     		 {
                     			 event.getChannel().sendMessage("Error. No such role detected!").queue();
                     			 
                     		 } else{
                     			 
                     			 
                     		 
                     		 
                     		 
                     		 Role roleset = event.getGuild().getRoles().stream().filter(r -> r.getName().equalsIgnoreCase(haha)).findFirst().orElse(null);
                     		 
                     		event.getGuild().getController().addRolesToMember(mentionedUser, roleset).queue();
                     		event.getChannel().sendMessage("Added role " + roleset.getAsMention() + " to user " + mentionedUser.getAsMention()).queue();
                            
                     		
                     		 }
                		 }else{
                			 
                			 System.out.println("fail");
               
                		 }
                		 
                		 
                	
                		 // event.getGuild().getController().addRolesToMember(mentionedUser, muteRole).queue();
                          
                    	  
                    	  //event.getTextChannel().sendMessage(mentionedUser.getEffectiveName() + " has been silenced.").queue();
                		 
                	 } catch(Exception e){
                		 
                		 event.getChannel().sendMessage("Error. Unable to add role.").queue();
                		 
                	 }
                		 
                		 
                	 }
                	 
                	 
                 }
                 
                 
             }
    		
    	
    		
    	}
		
		
		
		
		
        }
		
	}
	
	
	

}
