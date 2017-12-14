package Exuberant;

import java.util.List;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.utils.PermissionUtil;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
public class MessageResponse extends ListenerAdapter {
	
	public void onMessageReceived(MessageReceivedEvent event){
		
		String msg = event.getMessage().getContent();
		/*
		if(msg.startsWith("hello")){
			
			String senderName = event.getAuthor().getName();
			
			String response = senderName + " , I am under development! Try again later.";
			
			event.getTextChannel().sendMessage(response).queue();
			
			
		}
		*/
		
	
		 
		if(event.isFromType(ChannelType.TEXT)){
			Guild guild = event.getGuild();
            Member selfMember = guild.getSelfMember();  
		
			if(msg.startsWith("~mute")){
		
		  if (event.getMessage().getMentionedUsers().isEmpty())
          {
              event.getTextChannel().sendMessage("You must mention 1 or more Users to be kicked!").queue();
          }
          else
          {
        	  
        	  Role muteRole = event.getGuild().getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("muted")).findFirst().orElse(null);
        	  
        		
        	  
        	  if (!selfMember.hasPermission(Permission.MANAGE_ROLES))
              {
                  event.getTextChannel().sendMessage("I don't have permission").queue();
                  
             
                 
              } else{
            	  
            	  
 
                if(!event.getMember().hasPermission(Permission.MANAGE_ROLES))
                  {
                      event.getTextChannel().sendMessage(" You do not have permissions to assign the 'Muted' role!").queue();
                      
                  }else{
                	  
                	 
                	  
                	
                    	  
                	  List<User> mentionedUsers = event.getMessage().getMentionedUsers();
                      for (User user : mentionedUsers)
                      {
                          Member member = guild.getMember(user); 
                          
                          if (!selfMember.canInteract(member))
                          {
                              event.getTextChannel().sendMessage("Cannot mute member: " + member.getEffectiveName() +", they are higher " +
                                      "in the hierachy than I am!").queue();
                              
                             
                              
                         
                              continue;   //Continue to the next mentioned user to be kicked.
                              
                              
                          }else{
                        	  
 if(!event.getMember().canInteract(member)){
                            	  
                            	  event.getTextChannel().sendMessage("You can't mute: " + member.getEffectiveName() +", they are higher THAN YOUUUUUUUU !").queue();  
                            	  
 } else {
                            	  event.getGuild().getController().addRolesToMember(member, muteRole).queue();
                                  
                            	  
                            	  event.getTextChannel().sendMessage(member.getEffectiveName() + "has been silenced.").queue();
                              }
                        	  
                        	 
                          }

                      }
                      
                  
              }
                  
                  
                  
                  
		
	
		  
		  
		}
		  
        	  
        	  if(msg.startsWith("~mute")){
        			
        		  if (event.getMessage().getMentionedUsers().isEmpty())
                  {
                      event.getTextChannel().sendMessage("You must mention 1 or more Users to be kicked!").queue();
                  }
                  else
                  {
                	  
                	 
                		
                	  
                	  if (!PermissionUtil.canInteract(selfMember, muteRole))
                      {
                          event.getTextChannel().sendMessage("I don't have permission").queue();
                          
                     
                         
                      } else{
                    	  
                    	  
         
                        if(!event.getMember().hasPermission(Permission.MANAGE_ROLES))
                          {
                              event.getTextChannel().sendMessage(" You do not have permissions to assign the 'Muted' role!").queue();
                              
                          }else{
                        	  
                        	  
                        	
                            	  
                        	  List<User> mentionedUsers = event.getMessage().getMentionedUsers();
                              for (User user : mentionedUsers)
                              {
                                  Member member = guild.getMember(user); 
                                  
                                  if (!selfMember.canInteract(member))
                                  {
                                      event.getTextChannel().sendMessage("Cannot mute member: " + member.getEffectiveName() +", they are higher " +
                                              "in the hierachy than I am!").queue();
                                      continue;   //Continue to the next mentioned user to be kicked.
                                      
                                      
                                  }else{
                                	  
                                	  event.getGuild().getController().addRolesToMember(member, muteRole).queue();
                                
                                	  
                                	  event.getTextChannel().sendMessage(member.getEffectiveName() + "has been silenced.").queue();
                                  }

                              }
                              
                          
                      }
                          
                          
                          
                          
        		
        	
        		  
        		  
        		}
          }
		  
	

	

}
		
	}
	
		// if (!selfMember.hasPermission(Permission.KICK_MEMBERS))
       //  {
        // }
        // }
	}
	

}
		
	}
}
