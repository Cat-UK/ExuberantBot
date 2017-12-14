package Exuberant;

import java.util.List;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class UnmuteCMD extends Command{
	
	
	
	
	@Override
	protected void ExecuteCommand(MessageReceivedEvent event){
		
		String msg = event.getMessage().getContent();
		Guild guild = event.getGuild();
        Member selfMember = guild.getSelfMember();  
        
        /*
        if (event.getMessage().getMentionedUsers().isEmpty())
        {
            event.getTextChannel().sendMessage("There is nobody to unmute. Please mention at least 1 user.").queue();
        } else{
        	
        	//List<Role> userRoles = event.getMember().getRoles();
        	boolean found = false;
        
        		Role required = event.getMember().getRoles().stream().filter(role -> role.getName().equalsIgnoreCase("a.i. managers")).findFirst().orElse(null);
        		if(required == null && !event.getMember().isOwner()){
        			found = false;
        			
        		}else{
        			
        			found = true;
        		}
        		
        		
        		
        		
        		
            
        	
        	
        	if(found == false){
        		
        	event.getTextChannel().sendMessage("You need the role admin role to do that!").queue();	
        	} else{
        		
        		event.getTextChannel().sendMessage("You got it.").queue();
        		
        		 List<User> mentionedUsers = event.getMessage().getMentionedUsers();
                 for (User user : mentionedUsers)
                 {
                     Member mentionedUser = guild.getMember(user); 
                     
                     
                     if(!selfMember.canInteract(mentionedUser)){
                    	 
                    		event.getTextChannel().sendMessage("I can't mute  " + mentionedUser.getAsMention() + " if they are higher in rank than me. Therefore, I cannot unmute them either!" ).queue();
                    		
                    		
                    		
                    	 
                     }  else{
                    	 
                    	 
                    	 if(!event.getMember().canInteract(mentionedUser)){
                    		 
                    		 
                    		 
                    		 event.getTextChannel().sendMessage("You cannot unmute" + mentionedUser.getAsMention() + " they are higher in status than  you.").queue();
                    		 
                    	 } else{
                    		 
                    		 
                    		 
                    		 Role muteRole = event.getGuild().getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("muted")).findFirst().orElse(null);
                    		 
                    		 
                    		  event.getGuild().getController().removeRolesFromMember(mentionedUser, muteRole).queue();
                              
                        	  
                        	  event.getTextChannel().sendMessage("The duct tape has been removed. " + mentionedUser.getAsMention() + " can communicate now").queue();
                    		 
                    		 
                    		 
                    		 
                    	 }
                    	 
                    	 
                     }
                     
                     
                 }
                 
        		
        		
        	}
        	
        	
            }
        
        
        /////if(event.getGuild().getMember(event.getMessage().getAuthor()).isOwner() || event.getGuild().getMember(event.getMessage().getAuthor()).hasPermission(BAN_MEMBERS) )
        
        
        
        
        
       // event.getMember().getRoles().stream().filter(role -> role.getName().equalsIgoreCase("admin"))
        
        //if(event.getGuild().getMember(event.getMessage().getAuthor()).isOwner() || event.getGuild().getMember(event.getMessage().getAuthor()).hasPermission(BAN_MEMBERS) )
        
        
        */
        
        
        if (event.getMessage().getMentionedUsers().isEmpty())
        {
            event.getTextChannel().sendMessage("There is nobody to unmute. Please mention at least 1 user.").queue();
        } else{
        
		if(!event.getMember().hasPermission(Permission.MANAGE_ROLES)){
    		
    		event.getTextChannel().sendMessage(event.getAuthor() + "you don't have the authority to unmute members.").queue();
    		
    		
    		
    		
    		
    	} else{
    		
    		 List<User> mentionedUsers = event.getMessage().getMentionedUsers();
             for (User user : mentionedUsers)
             {
                 Member mentionedUser = guild.getMember(user); 
                 
                 
                 if(!selfMember.canInteract(mentionedUser)){
                	 
                		event.getTextChannel().sendMessage("I can't mute  " + mentionedUser.getAsMention() + " if they are higher in rank than me. Therefore, I cannot unmute them either!" ).queue();
                		
                		
                		
                	 
                 }  else{
                	 
                	 
                	 if(!event.getMember().canInteract(mentionedUser)){
                		 
                		 
                		 
                		 event.getTextChannel().sendMessage("You cannot unmute" + mentionedUser.getAsMention() + " they are higher in status than  you.").queue();
                		 
                	 } else{
                		 
                		 
                		 
                		 Role muteRole = event.getGuild().getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("Muted")).findFirst().orElse(null);
                		 
                		 event.getGuild().getController().removeRolesFromMember(mentionedUser, muteRole).queue();
                         
                   	  
                   	  event.getTextChannel().sendMessage("``` The duct tape has been removed. " + mentionedUser.getEffectiveName() + " can communicate now ```").queue();
                		 
                		 
                		 
                	 }
                	 
                	 
                 }
                 
                 
             }
             
             
             
            
    		
    	
    		
    	}
		
		
        }
		
		
		
		
		
		
		
		
		///
		
		
		
		
        }
		
		
		
	}
	
	
	
	
	


