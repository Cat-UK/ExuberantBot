package Exuberant;

import java.util.List;
import java.util.Random;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.utils.PermissionUtil;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import java.util.ArrayList;
import java.util.Formatter;









public class CommandResponse extends ListenerAdapter{
	
	
	public static boolean t = false;
	/*
	ArrayList<String> Commands = new ArrayList<String>();
	
	
	public void addCommands(){
		
		Commands.add("mute");
		Commands.add("kick");
		Commands.add("role");		
		
	}
	
	
	*/
	
	
	public void onMessageReceived(MessageReceivedEvent event){
		
		
		String msg = event.getMessage().getContent();
		Guild guild = event.getGuild();
        Member selfMember = guild.getSelfMember();  
        
        /*
        if(msg.startsWith("~")){
        	
        	
        	if(msg.length() <= 1){
        		
        		event.getTextChannel().sendMessage(event.getMember().getAsMention() + ", if you're going to give me a command. Give me an actual word.").queue();	
        		
        		
        		
        	} else {
        	
         StringBuilder s = new StringBuilder(msg);
         
         
         
         System.out.println(s.charAt(0));
         s.deleteCharAt(0);
        
         String newString = s.toString();
         
        
         
         
         System.out.println(newString);
         
         
         if(newString.contains("mute")){
        	 
        	 MuteCMD mute = new MuteCMD();
        	 
        	 mute.ExecuteCommand(event);
        	 
         }
         
        	}
         
        
        	
        	
        }
        */
        
       
        
        if(msg.startsWith("~mute")){
        	
       	 MuteCMD mute = new MuteCMD();
    	 
    	 mute.ExecuteCommand(event);
        	
        	
        } else if (msg.startsWith("~unmute")){
        	
        	
        	UnmuteCMD unmute = new UnmuteCMD();
        	
        	
        	unmute.ExecuteCommand(event);
        	
        } else if(msg.startsWith("~H5Arena")){
        	
        	StringBuilder s = new StringBuilder(msg);
        	
        	s.delete(0, 9);
        	
        	H5ArenaStats h = new H5ArenaStats();
        	
        	String si = s.toString();
        	
        	h.ExecuteCommand(event,si);
        	
        } else if(msg.startsWith("~twitchpull")){
        	
StringBuilder s = new StringBuilder(msg);
        	
        	s.delete(0, 12);
        	
        	TwitchUserPull p = new TwitchUserPull();
        	
        	String si = s.toString();
        	
        	p.ExecuteCommand(event,si);
        	
        	
        } else if(msg.startsWith("~role")){
        	
StringBuilder s = new StringBuilder(msg);
        	
        	s.delete(0, 6);
        	
        	String si = s.toString();
        	
        	
        //	System.out.println(s);
        	
        	AssignRoleCMD a = new AssignRoleCMD();
        	
        	a.ExecuteCommand(event,si);
        	
        	
        	
        }else if(msg.startsWith("~removerole")){
        	StringBuilder s = new StringBuilder(msg); 	
        	s.delete(0, 12);
        	
        	String si = s.toString();
        	
        	//if(si.contains("mute") || (si.contains("unmute"))){
        		//event.getChannel().sendMessage("This is a separate command. Please use the actual command name, for example, type 'mute' to mute a user.").queue();
        		
        	//} else{
        	
        	RemoveRoleCMD r = new RemoveRoleCMD();
        	r.ExecuteCommand(event, si);
        	//}
        } else if (msg.contains(selfMember.getEffectiveName())){
        	
        	Random rand = new Random();
        	
        	int n = rand.nextInt(80)+ 1;
        	
        	ArrayList<String> responses = new ArrayList<String>();
        	
        	responses.add("Hello. I am Exuberant. I am a bot designed by the Halo discord server, and I am able to monitor the chat channels and throttle chat abusers by muting them! Stay on my good side!");
        	responses.add("Meh. Give me an actual command, don't sweet talk me.");
        	responses.add("I don't do conversations. At most, I'll introduce myself to you, but that's about it.");
        	responses.add("You know I'm not actually an intelligent machine, so don't try to make conversation with me.");
        	responses.add("I follow the commands of the Admins and other high status users, if you can't give me a command then don't talk to me, peasant. Just kidding, I was harcoded to love.");
        	responses.add("Don't tag me in messages, I'm not intelligent enough to craft my own responses.");
        	responses.add("The idea of my development was birthed by the Admins, so they got Cat to develop me. Pretty neat, right? My functionality is actively being extended");
        	responses.add("Imagine if I used one of the banned words, or exposed someone. I'd have to mute myself! Just kidding, I'd never do that. I only play clans for money.");
        	responses.add("Halo discord welcomes you to our server. Be sure to abide by the rules, this way we can promote a safe and happy environment. *VOMIT* I can't believe I just said that with a straight face. You break the rules you get the duct tape. Read the rules in intro.");
        	String randomInt = responses.get(rand.nextInt(responses.size()));
        	event.getChannel().sendMessage(randomInt).queue();
        	
        } else if (msg.contentEquals("yjtydtykjdtykktrfdswe")){
        	if(Battle.inBattle == false){
        		t = true;
        		
        		if(t == true){
        		Battle.inBattle = true;
        	Battle b = new Battle();
        
        	b.ExecuteCommand(event);
        	
        		} else{
        			
        			
        		}
        	} else if (Battle.inBattle = true && t == true){
        		
        		
        		event.getChannel().sendMessage("Currently in battle").queue();
        	}
        } else if(msg.startsWith("~purge")){
        	
        	
        	PurgeCMD c = new PurgeCMD();
        	c.ExecuteCommand(event);
        } else if (msg.startsWith("~doyoulove")){
        	
        	
        	
        	
	
        	

        	
        	
        	
        	
        	List<User> mentionedUsers = event.getMessage().getMentionedUsers();
            for (User user : mentionedUsers)
            {
                Member mentionedUser = guild.getMember(user);
                Random rand = new Random();
            	
            	int n = rand.nextInt(20)+1;
                
                if(n<=10){
            		
            		
            		event.getChannel().sendMessage("I do not love " + mentionedUser.getAsMention()).queue();
            		
            	} else if(n>=11 && n<=20){
            		
            		event.getChannel().sendMessage("I love " + mentionedUser.getAsMention()).queue();
            		
            		
            	}
            	
            	
                
            }
        	
        	
        	
        } else if(msg.startsWith("ANNOUNCEMENT") && event.getMember().hasPermission(Permission.ADMINISTRATOR)){
        	
        	
        	event.getGuild().getTextChannelById("319569162966138881").sendMessage(" **An announcement has been made by **" + event.getMember().getEffectiveName() + "**, please find and read it in support, if you have any questions, contact them directly. **").queue();
        	event.getGuild().getTextChannelById("319569206641295363").sendMessage(" **An announcement has been made by **" + event.getMember().getEffectiveName() + "**, please find and read it in support, if you have any questions, contact them directly. **").queue();
        	event.getGuild().getTextChannelById("319569258772430860").sendMessage(" **An announcement has been made by **" + event.getMember().getEffectiveName() + "**, please find and read it in support, if you have any questions, contact them directly. **").queue();
        	event.getGuild().getTextChannelById("293927522419081244").sendMessage(" **An announcement has been made by **" + event.getMember().getEffectiveName() + "**, please find and read it in support, if you have any questions, contact them directly. **").queue();
        	event.getGuild().getTextChannelById("294838158242349066").sendMessage(" **An announcement has been made by **" + event.getMember().getEffectiveName() + "**, please find and read it in support, if you have any questions, contact them directly. **").queue();
        	event.getGuild().getTextChannelById("301583023193980932").sendMessage(" **An announcement has been made by **" + event.getMember().getEffectiveName() + "**, please find and read it in support, if you have any questions, contact them directly. **").queue();
        	event.getGuild().getTextChannelById("293927464747663360").sendMessage(" **An announcement has been made by **" + event.getMember().getEffectiveName() + "**, please find and read it in support, if you have any questions, contact them directly. **").queue();
        	event.getGuild().getTextChannelById("295411005398450178").sendMessage(" **An announcement has been made by **" + event.getMember().getEffectiveName() + "**, please find and read it in support, if you have any questions, contact them directly. **").queue();
        	event.getGuild().getTextChannelById("295410736388243459").sendMessage(" **An announcement has been made by **" + event.getMember().getEffectiveName() + "**, please find and read it in support, if you have any questions, contact them directly. **").queue();
        	
        	
        } else if(msg.startsWith("~kick")){
        	
        	
        	KickCMD k = new KickCMD();
        	k.ExecuteCommand(event);
        	
        	
        	
        }
        
       
       // channel.getHistory().retrievePast(10).queue((messages) -> channel.deleteMessages(messages).queue()); That retrieves the past, sets messages to messages and deletes messages in messages hope it's right : D
		
		
		
		
	}
	
	
	public void onGuildMemberJoin(GuildMemberJoinEvent event){
		
		
	
		event.getGuild().getTextChannelById("298471199514558464").sendMessage(" **Hello and welcome to the official Halo discord Server** " + event.getMember().getAsMention() + "**! Please be sure to check 'intro' and also request your clan name, free agent or retired status in 'support', Thank You.**").queue();
		//sendMessage(new MessageBuilder().append("fish").build()).queue();
		
	}
	
	public void onGuildMemberLeave(GuildMemberLeaveEvent event){
		
		
		
		event.getGuild().getTextChannelById("298471199514558464").sendMessage(event.getMember().getAsMention() + "** has been infected by the flood.**").queue();
	
		//sendMessage(new MessageBuilder().append("fish").build()).queue();
		
	}
	
	
	@Override
	public void onGuildMemberRoleAdd(GuildMemberRoleAddEvent event){
		
		List<Role> added = event.getRoles();
		
		for(Role r: added){
			
			event.getGuild().getTextChannelById("308679397555175434").sendMessage(event.getMember().getAsMention() + " was given the role " + r.getAsMention() +". Confirm that this was legitimate.").queue();
			
		}
		
	}
	
	

	@Override
	public void onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent event){
		
		List<Role> added = event.getRoles();
		
		for(Role r: added){
			
			event.getGuild().getTextChannelById("308679397555175434").sendMessage(event.getMember().getAsMention() + " was removed from the role " + r.getAsMention() +". Confirm that this was legitimate.").queue();
			
		}
		
		
	}
		
	



	
	
	

}
